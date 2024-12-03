package Projeto.Chiclete;
public class RespostaSimples extends Resposta{
	private String respostaRobo;
  
  	public RespostaSimples(String keyWord, String respostaRobo){
    	super(keyWord);
      	this.respostaRobo = respostaRobo;
    }

	@Override
	public boolean verifica(String entrada){
		return entrada.contains(keyWord);
	}

	@Override
    public String produz(){
		return this.respostaRobo;
	}
}