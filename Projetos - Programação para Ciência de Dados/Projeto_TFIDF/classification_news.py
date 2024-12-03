# -*- coding: utf-8 -*-
import os
from pyspark.context import SparkContext
from pyspark.sql import SparkSession
from pyspark.sql.functions import col, regexp_replace, trim, lower
from pyspark.ml.feature import HashingTF, Tokenizer, StopWordsRemover, IDF
from pyspark.ml import Pipeline
from pyspark.ml.classification import LogisticRegression
from pyspark.ml.evaluation import MulticlassClassificationEvaluator
from pyspark.conf import SparkConf
from nltk.corpus import stopwords

# =============================================================================
# Definições Iniciais
# =============================================================================
PATH = os.path.dirname(os.path.realpath('__file__'))
esquema = 'id_documento STRING, assunto INT, titulo STRING, text STRING'
list_stopwords = stopwords.words('english')
list_stopwords.extend(["http","https","amp","rt","t","c",'x','s','o'])


# =============================================================================
# Sessão Spark
# =============================================================================
config = SparkConf().setAll([('spark.executor.memory', '27g'), ('spark.executor.cores', '16'), ('spark.cores.max', '16'), ('spark.driver.memory','27g'),
                             ("spark.sql.inMemoryColumnarStorage.compressed", True), ("spark.sql.inMemoryColumnarStorage.batchSize",10000)])

sc = SparkContext(appName = 'Clasificação - Assunto News', master = 'local[2]', conf=config)
spark = SparkSession(sc)


# =============================================================================
# Abrindo base de dados
# =============================================================================
dataset = spark.read.csv(os.path.join(PATH, 'news.csv'), schema = esquema)
valores_missing = {col: dataset.filter(dataset[col].isNull()).count() for col in dataset.columns}; print(valores_missing)

dataset.groupby('assunto').count().orderBy('assunto').show()
dataset.groupby('text').count().orderBy('count', ascending = False).show(truncate = False)
dataset.groupby('id_documento').count().orderBy('count', ascending = False).show()

exit()

# =============================================================================
# Transformação dos dados
# =============================================================================
dataset = dataset.withColumnRenamed('assunto', 'label')

# Padronização do Texto 
dataset = (dataset.withColumn("text", regexp_replace(col("text"), "\W+", " ")) # \W+ remove caracteres especiais, como: ",@.()-;
                  .withColumn("text", trim(col("text")))  # remove espaçoes em branco no inicio e fim da string
                  .withColumn("text", lower(col("text"))) # transforma todo o texto em minusculo
                  )

# Divisão em treino e teste
(dados_treino, dados_teste) = dataset.randomSplit([0.7, 0.3], seed=157)

dados_treino.count()
dados_teste.count()

# =============================================================================
# Modelagem
# =============================================================================

# Modelo
lr = LogisticRegression(**{'maxIter': 100, 'regParam': 0.1})

# Definição dos Stages 
tokenizer = Tokenizer(inputCol = 'text', outputCol = "termos")
stopWordsRemover = StopWordsRemover(inputCol=tokenizer.getOutputCol(), outputCol="termos_sem_stopwords").setStopWords(list_stopwords)
hashingTF = HashingTF(inputCol = stopWordsRemover.getOutputCol(), outputCol = 'termos_HashTF')
idf = IDF(inputCol = hashingTF.getOutputCol(), outputCol = 'features')

# Criação do Pipeline
pipeline = Pipeline(stages = [tokenizer, stopWordsRemover, hashingTF, idf, lr])

model = pipeline.fit(dados_treino)

# =============================================================================
# Avaliação do Modelo
# =============================================================================
avaliador = MulticlassClassificationEvaluator(predictionCol = 'prediction', labelCol = 'label', metricName = 'accuracy')

prediction = model.transform(dados_teste)

# Acurácia do Modelo
avaliador.evaluate(prediction)

# Confusion Matrix
confision_matrix = prediction.groupBy('label', 'prediction').count().orderBy('label', 'prediction')
confision_matrix.toPandas().to_csv(os.path.join(PATH, 'report_confusion_matrix.csv'), index = False)

# =============================================================================
# Salvando o Modelo
# =============================================================================
model.write().overwrite().save(os.path.join(PATH, 'model_best'))
