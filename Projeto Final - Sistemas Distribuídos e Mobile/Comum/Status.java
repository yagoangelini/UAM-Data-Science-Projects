import java.io.Serializable; // Porque a mensagem precisa virar um serial pela rede

//Criada para padronizar todos os retornos das funções da interface, enviando a mensagem de status das operações
public class Status implements Serializable{
    private int status;
    
    public Status() {
        this.status = 0;
    }

    public Status(int status){
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
    
    public void setStatus(int status) {
        this.status = status;
    }

    public void exibirMensagem(){
        switch(this.status){
            case 0:
                System.out.println("\n\nSUCESSO - Operação realizada com êxito.\n");
                break;
            case 1:
                System.out.println("\n\nERRO 0x00001 - Conta não adicionada.\n");
                break;
            case 2:
                System.out.println("\n\nERRO 0x00002 - Conta de origem não encontrada.\n");
                break;
            case 3:
                System.out.println("\n\nERRO 0x00003 - Saldo atual da conta de origem insuficiente.\n");
                break;
            case 4:
                System.out.println("\n\nERRO 0x00004 - Conta de destino não encontrada.\n");
                break;
            case 5:
                System.out.println("\n\nERRO 0x00005 - Informe um valor maior que 0.\n");
                break;
            case 6:
                System.out.println("\n\nERRO 0x00006 - Informe um caractere válido.\n");
                break;
            case 7:
                System.out.println("\n\nERRO 0x00007 - A conta de origem e a de destino devem ser diferentes.\n");
                break;
            case 8:
                System.out.println("\n\nERRO 0x00008 - CPF já está cadastrado no sistema.\n");
                break;
        }
    }
}
