import java.io.Serializable; // Porque a mensagem precisa virar um serial pela rede
import java.util.ArrayList;
import java.util.Random;

// Criada para conter os dados de uma conta de cliente, incluindo seu extrato
public class Conta implements Serializable{
    private int numConta;
    private String nomeCliente;
    private String cpf;
    private double saldo;
    private double limite; //Limite da conta
    private ArrayList<Comprovante> comprovantes = new ArrayList<>(); //Lista de comprovantes = Extrato da Conta
    private Random gerador = new Random(); //Para nextInt()

    /**
     * @param numConta
     * @param nomeCliente
     * @param cpf
     * @param saldo
     */

    public Conta(){
        this.numConta = gerador.nextInt(9998) + 1;
        this.saldo = 0;
        this.limite = 500; // Regra de negócio: O limite padrão do nosso banco é de R$500,00
    }

    public Conta(String nomeCliente, String cpf) {
        this.numConta = gerador.nextInt(9998) + 1;
        this.nomeCliente = nomeCliente;
        this.cpf = cpf;
        this.saldo = 0;
        this.limite = 500; // Regra de negócio: O limite padrão do nosso banco é de R$500,00
    }

    /**
     * @return the numConta
     */
    public int getNumConta() {
        return numConta;
    }

    /**
     * @return the nomeCliente
     */
    public String getNomeCliente() {
        return nomeCliente;
    }

    /**
     * @param nomeCliente the nomeCliente to set
     */
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the saldo
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * @return the limite
     */
    public double getLimite() {
        return limite;
    }

    /**
     * @return the comprovantes
     */
    public ArrayList<Comprovante> getComprovantes() {
        return comprovantes;
    }

    /**
     * @param saldo the saldo to set
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        String lista_de_comprovantes = "────────────────────────────────────────┤\nEXTRATO\n────────────────────────────────────────┤\n"; // Título do extrato

        for(Comprovante comprovante : comprovantes){
            lista_de_comprovantes += comprovante.toString(); //Concatenando comprovantes numa string patra imprimi-la depois
        }

        return 	String.format("DADOS DA CONTA") + "\n────────────────────────────────────────┤\n" +
                String.format("%15s: %s\n", "Número da Conta", this.numConta) +
                String.format("%15s: %s\n", "Nome do Cliente", this.nomeCliente) +
                String.format("%15s: %s\n", "CPF", this.cpf) +

                ((this.saldo >= 0)?
                    String.format("%15s: R$%.2f\n", "Saldo", this.saldo) 
                    :
                    String.format("%15s: -R$%.2f\n", "Saldo", this.saldo*(-1))) + // Se o valor for negativo, imprime um - antes do símbolo da moeda, e remove o - que estava após o símbolo da moeda
                
                ((comprovantes.size() > 0)?
                    lista_de_comprovantes //Se existirem comprovantes na lista, imprime ela
                    :
                    ("────────────────────────────────────────┤")); // Caso não existam comprovantes, imprima uma string vazia
    }
}
