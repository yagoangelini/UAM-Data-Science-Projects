package Projeto.Chiclete;
public abstract class Resposta{
	protected String keyWord;

    public Resposta(String keyWord){
        this.keyWord = keyWord;
    }

	public abstract boolean verifica(String entrada);
    
    public abstract String produz();
}