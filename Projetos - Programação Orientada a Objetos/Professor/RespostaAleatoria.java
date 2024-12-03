package Projeto.Professor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class RespostaAleatoria extends Resposta{
	ArrayList<String> possiveisRespostas;
	Random gerador = new Random();

	public RespostaAleatoria(String keyWord, ArrayList<String> possiveisRespostas){
    	super(keyWord);
		this.possiveisRespostas = possiveisRespostas;
    }

	public boolean verifica(String entrada){
		return entrada.contains(keyWord);
	}

    public String produz(){
		Collections.shuffle(possiveisRespostas);
		return possiveisRespostas.get(gerador.nextInt(possiveisRespostas.size()));
	}

}
