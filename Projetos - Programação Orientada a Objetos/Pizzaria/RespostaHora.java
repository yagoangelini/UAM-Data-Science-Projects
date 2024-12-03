package Projeto.Pizzaria;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class RespostaHora extends Resposta{
	private LocalTime localTime = LocalTime.now();
	DateTimeFormatter tempoFormatado = DateTimeFormatter.ofPattern("H:mm:ss");
	
	public RespostaHora(String keyWord){
    	super(keyWord);
    }

	public boolean verifica(String entrada){
		return entrada.contains(keyWord);
	}

    public String produz(){
		return "Agora são " + localTime.format(tempoFormatado);
	}
}
