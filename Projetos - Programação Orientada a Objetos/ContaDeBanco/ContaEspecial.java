package APS.ContaDeBanco;

public class ContaEspecial extends ContaCorrente{
    String nomeDoGerenteResponsavel;

    public ContaEspecial(int numConta, String nomeCliente, String CPF, String nomeDoGerenteResponsavel){
        super(numConta, nomeCliente, CPF);
        this.nomeDoGerenteResponsavel = nomeDoGerenteResponsavel;
    }

    public ContaEspecial(int numConta, String nomeCliente, String CPF, double limite, String nomeDoGerenteResponsavel){
        super(numConta, nomeCliente, CPF, limite);
        this.nomeDoGerenteResponsavel = nomeDoGerenteResponsavel;
    }

    public void setNomeDoGerente(String nomeDoGerenteResponsavel){
        this.nomeDoGerenteResponsavel = nomeDoGerenteResponsavel;
    }

    public String getNomeDoGerente(){
        return nomeDoGerenteResponsavel;
    }

    @Override
    public String toString(){
        return super.toString() +
               "Nome do Gerente Responsável: " + nomeDoGerenteResponsavel + "\n";
    }
}
