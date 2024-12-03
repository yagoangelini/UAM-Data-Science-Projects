//Criada para permitir a impressão dos dados do cliente no Processo Cliente, e não somente no Processo Servidor
//Além disso, retorna o Status da operação junto
public class StatusAndDados extends Status{
    String dados;

    public StatusAndDados(){
        super();
    }

    public StatusAndDados(int status, String dados){
        super(status);
        if(dados != "")
            this.dados = "\n────────────────────────────────────────┤\n" + dados + "\n"; // Apenas para fins de visualização
        else
            this.dados = dados;
    }

    public void exibirDados(){
        System.out.print(dados);
    }

}
