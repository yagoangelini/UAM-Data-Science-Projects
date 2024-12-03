package APS.ContaDeBanco;

public class ContaCorrente extends Conta{
    double limite = 0;

    //CONSTRUTORES
    public ContaCorrente(int numConta, String nomeCliente, String CPF){
        super(numConta, nomeCliente, CPF);
    }

    public ContaCorrente(int numConta, String nomeCliente, String CPF, double limite){
        super(numConta, nomeCliente, CPF);
        this.limite = limite;
    }


    //MÉTODOS
    public boolean usandoLimite(){
        return (getSaldo()<0)? true:false;
    }

    @Override
    public boolean sacar(double valorSacado){
        if((getSaldo() + limite) >= valorSacado){
            setSaldo(getSaldo() - valorSacado);
            return true;
        }
        //System.out.println("Não foi possível realizar o saque, limite insuficiente.\n");
        return false;
    }

    @Override
    public String toString(){
        return super.toString() +
               String.format("Limite: R$%.2f", limite) + "\n";
    }
}
