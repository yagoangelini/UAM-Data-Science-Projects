package Projeto.Chiclete;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class RespostaHora extends Resposta{
	private LocalTime localTime = LocalTime.now();
	private DateTimeFormatter tempoFormatado = DateTimeFormatter.ofPattern("HH:mm:ss");
	
	public RespostaHora(String keyWord){
    	super(keyWord);
    }

	@Override
	public boolean verifica(String entrada){
		return entrada.contains(keyWord);
	}

	@Override
    public String produz(){
		return "Agora são " + localTime.format(tempoFormatado);
	}
}
