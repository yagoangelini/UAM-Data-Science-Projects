package Projeto.Pizzaria;

public abstract class Resposta{
	String keyWord;

    public Resposta(String keyWord){
        this.keyWord = keyWord;
    }

	public abstract boolean verifica(String entrada);
    
    public abstract String produz();
}