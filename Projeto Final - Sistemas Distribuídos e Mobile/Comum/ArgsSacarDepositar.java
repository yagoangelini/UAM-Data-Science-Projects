import java.io.Serializable; // Porque a mensagem precisa virar um serial pela rede

// Usada para os métodos: sacar() e depositar()
public class ArgsSacarDepositar implements Serializable{
    private String cpf;
    private double valor;

    /**
     * @param cpf
     * @param valor
     */
    public ArgsSacarDepositar(String cpf, double valor) {
        this.cpf = cpf;
        this.valor = valor;
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
     * @return the valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(double valor) {
        this.valor = valor;
    }
    
}
