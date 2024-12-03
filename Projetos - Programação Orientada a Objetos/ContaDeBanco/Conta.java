package APS.ContaDeBanco;

public abstract class Conta{
    private int numConta;
    private String nomeCliente;
    private String CPF;
    private double saldo=0;


    //CONSTRUTOR
    public Conta(int numConta, String nomeCliente, String CPF){
        this.numConta = numConta;
        this.nomeCliente = nomeCliente;
        this.CPF = CPF;
    }


    //GETTERS e SETTERS
    public String getNomeCliente(){
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente){
        this.nomeCliente = nomeCliente;
    }

    public int getNumConta(){
        return numConta;
    }

    protected void setNumConta(int numConta){
        this.numConta = numConta;
    }

    public String getCPF(){
        return CPF;
    }

    protected void setCPF(String CPF){
        this.CPF = CPF;
    }

    public double getSaldo(){
        return saldo;
    }

    protected void setSaldo(double saldo){
        this.saldo = saldo;
    }


    //MÉTODOS
    public boolean sacar(double valorSacado){
        if(saldo >= valorSacado){
            saldo -= valorSacado;
            return true;
        }
        //System.out.println("Não foi possível realizar o saque, saldo insuficiente.\n");
        return false;
    }

    
    public boolean depositar(double valorDepositado){
        if(valorDepositado > 0){
            saldo += valorDepositado;
            return true;
        }
        return false;
    }

    public String toString(){
        return "Número da conta: " + numConta +
               "\nNome do Cliente: " + nomeCliente +
               "\nCPF: " + CPF +
               String.format("\nSaldo: R$%.2f", saldo) + "\n";
    }

}


