package Projeto.Chiclete;
public class RespostaContador extends Resposta{
    private int cont=0;

    public RespostaContador(String keyWord){
        super(keyWord);
    }

    @Override
    public boolean verifica(String entrada){
		return entrada.contains(keyWord);
	}

    @Override
    public String produz(){
        cont++;
        return "Conta atual: " + cont;
	}
}
