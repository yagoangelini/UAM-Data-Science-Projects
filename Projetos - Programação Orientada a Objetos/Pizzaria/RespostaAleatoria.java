package Projeto.Pizzaria;

import java.util.Collections;
import java.util.Random;

public class RespostaAleatoria extends Resposta{
	Cardapio cardapio;
	Random gerador = new Random();

	public RespostaAleatoria(String keyWord, Cardapio cardapio){
    	super(keyWord);
		this.cardapio = cardapio;
    }

	public boolean verifica(String entrada){
		return entrada.contains(keyWord);
	}

    public String produz(){
		Collections.shuffle(cardapio.getCardapio());
		return "Se eu fosse escolher, escolheria essa:\n" + cardapio.getCardapio().get(gerador.nextInt(cardapio.getCardapio().size()));
	}

}
