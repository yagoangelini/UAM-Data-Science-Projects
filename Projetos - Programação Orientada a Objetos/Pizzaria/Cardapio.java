package Projeto.Pizzaria;

import java.util.ArrayList;

public class Cardapio{
    private ArrayList<Sabores> cardapio = new ArrayList<>();

    public void adicionarItem(Sabores sabor){
        cardapio.add(sabor);
    }

	public ArrayList<Sabores> getCardapio() {
        return cardapio;
    }

    public Sabores pesquisar(String texto){
    	for(int i=0; i<cardapio.size(); i++){
        	if(cardapio.get(i).verifica(texto))
				return cardapio.get(i);
        }
		return null;
    }
}

