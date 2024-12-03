package Projeto.Chiclete;
import java.util.Collections;
import java.util.Random;

public class RespostaAleatoria extends Resposta{
	private Produtos possiveisRespostas;
	private Random gerador = new Random();

	public RespostaAleatoria(String keyWord, Produtos possiveisRespostas){
    	super(keyWord);
		this.possiveisRespostas = possiveisRespostas;
    }

	@Override
	public boolean verifica(String entrada){
		return entrada.contains(keyWord);
	}

	@Override
    public String produz(){
		Collections.shuffle(possiveisRespostas.getProdutos()); //Embaralha a lista de possíveis respostas
		System.out.print("\nCHICLEBOT - Se eu tivesse que escolher, escolheria esse:");
		return possiveisRespostas.getProdutos().get(gerador.nextInt(possiveisRespostas.getProdutos().size())) + ""; //Retorna uma posição aleatória da lista embaralhada
	}

}
