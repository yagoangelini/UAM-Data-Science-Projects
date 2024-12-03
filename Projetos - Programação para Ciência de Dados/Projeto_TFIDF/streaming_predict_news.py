# -*- coding: utf-8 -*-
import os 
from pyspark.sql.functions import col, regexp_replace, trim, lower
from pyspark.sql import SparkSession
from pyspark.ml.pipeline import PipelineModel

if __name__ == '__main__':
    
    PATH = os.path.dirname(os.path.realpath('__file__'))
    
    print(" --[ News Streaming ]-- ")

    spark = SparkSession.builder.appName("prevendo news").getOrCreate()

    # Definindo o esquema
    esquema = "id STRING, titulo STRING, text STRING, time TIMESTAMP"

    # Abrindo dataset
    dataset = spark.readStream.option('sep', ';').schema(esquema).csv('news_streaming')

    # Padronização do Texto 
    dataset = (dataset.withColumn("text", regexp_replace(col("text"), "\W+", " ")) # \W+ remove caracteres especiais, como: ",@.()-
                      .withColumn("text", trim(col("text")))  # remove espaçoes em branco no inicio e fim da string
                      .withColumn("text", lower(col("text"))) # transforma todo o texto em minusculo
                      )
    
    # read pickled model via pipeline api
    model_news = PipelineModel.load(os.path.join(PATH, 'model_best'))
    dataset_c = dataset.select('id', 'time')
    predictionsDF = model_news.transform(dataset)
    predictionsDF = predictionsDF.select('id', 'text', 'prediction')
    predictionsDF = predictionsDF.groupBy('id', 'text', 'prediction').count()
    predictionsDF = predictionsDF.drop('count')
    
    # Configura a saida do stream
    # query = df_group_vendas.writeStream.format('console').option('truncate', 'false').outputMode('complete').start()
    query = predictionsDF.writeStream.outputMode('complete').format('console').start()

    query.awaitTermination()