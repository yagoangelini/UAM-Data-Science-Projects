# -*- coding: utf-8 -*-
import os
import pandas as pd
from time import sleep
from datetime import datetime

if __name__ == '__main__':

    PATH = os.path.dirname(os.path.realpath('__file__'))

    print(" --[ Gerando News ]-- ")
    
    contador = 0
    while True:
        contador += 1

        # Aguarda 60 segundos
        sleep(5)
        
        dataset = pd.read_csv(os.path.join(PATH, 'news.csv'), header=None)
        new = dataset.sample(n=1,replace=True).drop(columns = [1])
        
        data_formatada = datetime.now().strftime("%Y-%m-%dT%H:%M:%S")

        dado = str(new.iloc[0, 0]) + ";" + str(new.iloc[0, 1]).replace(';', '')  + ";" + str(new.iloc[0, 2]).replace(';', '') + ';' + data_formatada

        print(dado)

        # Salva o nome_arquivo
        f = open(os.path.join(PATH, 'news_streaming', f'new_{contador}.csv'), "w")
        f.write(dado)
        f.close()
