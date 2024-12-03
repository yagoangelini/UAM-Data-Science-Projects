import java.io.Serializable; // Porque a mensagem precisa virar um serial pela rede

// Criada para conter o relatório de uma operação realizada pelo cliente
public class Comprovante implements Serializable{
    private String tipo_de_atividade;
    private String data_e_hora;
    private double valor;
    private String cpf_origem;
    private String cpf_destino;

    /**
     * @param tipo_de_atividade
     * @param data_e_hora
     * @param valor
     * @param cpf_origem
     * @param cpf_destino
     */
    public Comprovante(String tipo_de_atividade, String data_e_hora, double valor, String cpf) {
        this.tipo_de_atividade = tipo_de_atividade;
        this.data_e_hora = data_e_hora;
        this.valor = valor;

        if(this.valor >= 0)
            this.cpf_origem = cpf;
        else
            this.cpf_destino = cpf;
    }

    /**
     * @param tipo_de_atividade
     * @param data_e_hora
     * @param valor
     */
    public Comprovante(String tipo_de_atividade, String data_e_hora, double valor) {
        this.tipo_de_atividade = tipo_de_atividade;
        this.data_e_hora = data_e_hora;
        this.valor = valor;
    }



    public String toString(){
        return tipo_de_atividade +
               
               "\nValor: " + ((this.valor >= 0)?
                                String.format("+R$%.2f", this.valor) // Se o valor for positivo, imprime um + antes do símbolo da moeda
                                :
                                String.format("-R$%.2f", this.valor * (-1))) + // Se o valor for negativo, imprime um - antes do símbolo da moeda, e remove o - que estava após o símbolo da moeda
               
               ((cpf_origem != null && cpf_destino != null)? // Se os CPF's não forem nulos (ou seja, se não for saque ou transferência), faça
                    ((this.valor >= 0)?
                        ("\nCPF de Origem da transação: " + cpf_origem) // Se o valor é positivo, então o dinheiro entrou na conta, portanto temos um CPF de origem do dinheiro.
                        :
                        ("\nCPF de Destino da transação: " + cpf_destino)) // Se o valor é negativo, então o dinheiro saiu da conta, portanto temos um CPF de destino do dinheiro.
                    :
                    ("")) + // Se os CPF's forem nulos (ou seja, se for saque ou transferência), então, imprima uma string vazia, porque essas operações envolvem somente o CPF do titular, que já foi impresso nos dados da conta
               "\nData e Hora: " + data_e_hora +
               "\n────────────────────────────────────────┤\n";
    }
}
