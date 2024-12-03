package Projeto.Professor;

public class RespostaContador extends Resposta{
    int cont=0;

    public RespostaContador(String keyWord){
        super(keyWord);
    }

    public boolean verifica(String entrada){
		return entrada.contains(keyWord);
	}

    public String produz(){
        cont++;
        return "Conta atual: " + cont;
	}
}
