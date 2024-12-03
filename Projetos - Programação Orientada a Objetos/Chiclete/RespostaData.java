package Projeto.Chiclete;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RespostaData extends Resposta{
	private LocalDate localDate = LocalDate.now();
	private DateTimeFormatter dataComBarra = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public RespostaData(String keyWord){
    	super(keyWord);
    }

	@Override
	public boolean verifica(String entrada){
		return entrada.contains(keyWord);
	}

	@Override
    public String produz(){
		return "Hoje é dia " + localDate.format(dataComBarra);
	}
}