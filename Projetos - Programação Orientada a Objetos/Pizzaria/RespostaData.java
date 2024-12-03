package Projeto.Pizzaria;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RespostaData extends Resposta{
	private LocalDate localDate = LocalDate.now();
	DateTimeFormatter dataComBarra = DateTimeFormatter.ofPattern("dd/MM/YYYY");
	
	public RespostaData(String keyWord){
    	super(keyWord);
    }

	public boolean verifica(String entrada){
		return entrada.contains(keyWord);
	}

    public String produz(){
		return "Hoje é dia " + localDate.format(dataComBarra);
	}
}