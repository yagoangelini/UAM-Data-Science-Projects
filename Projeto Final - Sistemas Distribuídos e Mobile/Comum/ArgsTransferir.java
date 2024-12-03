import java.io.Serializable; // Porque a mensagem precisa virar um serial pela rede

// Usada para o método: transferir()
public class ArgsTransferir implements Serializable{
    private String cpf_conta_origem;
    private String cpf_conta_destino;
    private double valor;
    
    /**
     * @param cpf_conta_origem
     * @param cpf_conta_destino
     * @param valor
     */
    public ArgsTransferir(String cpf_conta_origem, String cpf_conta_destino, double valor) {
        this.cpf_conta_origem = cpf_conta_origem;
        this.cpf_conta_destino = cpf_conta_destino;
        this.valor = valor;
    }

    /**
     * @return the cpf_conta_origem
     */
    public String getCpf_conta_origem() {
        return cpf_conta_origem;
    }

    /**
     * @param cpf_conta_origem the cpf_conta_origem to set
     */
    public void setCpf_conta_origem(String cpf_conta_origem) {
        this.cpf_conta_origem = cpf_conta_origem;
    }

    /**
     * @return the cpf_conta_destino
     */
    public String getCpf_conta_destino() {
        return cpf_conta_destino;
    }

    /**
     * @param cpf_conta_destino the cpf_conta_destino to set
     */
    public void setCpf_conta_destino(String cpf_conta_destino) {
        this.cpf_conta_destino = cpf_conta_destino;
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
