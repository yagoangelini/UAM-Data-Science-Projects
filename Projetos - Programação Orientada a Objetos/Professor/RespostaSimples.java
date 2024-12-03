package Projeto.Professor;

public class RespostaSimples extends Resposta{
	String respostaRobo;
  
  	public RespostaSimples(String keyWord, String respostaRobo){
    	super(keyWord);
      	this.respostaRobo = respostaRobo;
    }

	public boolean verifica(String entrada){
		return entrada.contains(keyWord);
	}

    public String produz(){
		return respostaRobo;
	}
}
