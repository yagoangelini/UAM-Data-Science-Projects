package Projeto.Chiclete;

import java.util.ArrayList;

public class Chatbot{
	private ArrayList<Resposta> respostasConhecidas = new ArrayList<>();
	
  	public void adiciona(Resposta r){
    	respostasConhecidas.add(r);
    }
  
  	public String processar(String texto){
    	for(int i=0; i<respostasConhecidas.size(); i++){
        	if(respostasConhecidas.get(i).verifica(texto))
				return respostasConhecidas.get(i).produz();
        }
		return "Desculpe, não conheço essa.";
    }
}