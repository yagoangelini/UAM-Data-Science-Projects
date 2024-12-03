import java.io.Serializable; // Porque a mensagem precisa virar um serial pela rede

// Usada para os métodos: buscarConta(), exibirConta(), removerConta()
public class ArgsBuscarExibirRemover implements Serializable{ 
    private String cpf;

    /**
     * @param cpf
     */
    public ArgsBuscarExibirRemover(String cpf) {
        this.cpf = cpf;
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

}
