package APS.ContaDeBanco;

public class ContaPoupanca extends Conta{

    //CONSTRUTOR
    public ContaPoupanca(int numConta, String nomeCliente, String CPF){
        super(numConta, nomeCliente, CPF);
    }

    public void calcularRendimento(double porcentagemRendimento){
        setSaldo(getSaldo() * (1 + (porcentagemRendimento/100)));
    }
}
