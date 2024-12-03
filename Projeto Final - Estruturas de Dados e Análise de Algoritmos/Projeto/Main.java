import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    ManageAttendance atendimento = new ManageAttendance(4);
    int option;

    do{
      // MENU PRINCIPAL
      System.out.println("\n\n ┌──┤ BANCO: DINHEIRO DA MÃO ├──┐");
      System.out.printf(" │ %-28s │\n", "");
      System.out.printf(" │ %-28s │\n", "Informe uma das opções:");
      System.out.printf(" │ %-28s │\n", "1 - Incluir Cliente na fila"); //Chegada do cliente na agência
      System.out.printf(" │ %-28s │\n", "2 - Mostrar Próximo"); //Verificar quem é o próximo a ser atendido
      System.out.printf(" │ %-28s │\n", "3 - Atender Próximo"); //Atender um cliente (ao atender o cliente, o nome e a idade dele deve ser apresentada)
      System.out.printf(" │ %-28s │\n", "4 - Exibir Filas"); //Exibir as filas (idoso e não idoso)
      System.out.printf(" │ %-28s │\n", "5 - Finalizar Programa"); //Finalizar o programa (que só poderá ser finalizado caso não tenha mais clientes aguardando)
      System.out.printf(" │ %-28s │\n", "");
      System.out.println(" └──────────────────────────────┘\n");

      System.out.print("Informe uma opção: ");
      option = sc.nextInt();

      sc.nextLine(); // Limpa o buffer
      System.out.print("\n"); // Pula uma linha

      switch(option){
        case 1:
          System.out.print("Informe o nome: ");
          String nome = sc.nextLine();
          System.out.print("Informe a idade: ");
          int idade = sc.nextInt();
          
          atendimento.addClient(new Client(nome, idade));
          break;
        case 2:
          Client proximo = atendimento.showNext();
          if(proximo != null)
            System.out.println("\n─── PRÓXIMO CLIENTE ───" + proximo.toString());
          else
            System.out.println("\n\nERRO - Nenhuma pessoa nas filas.\n");
          break;
        case 3:
          Client atendido = atendimento.getNext();
          if(atendido != null)
            System.out.println("\n─── CLIENTE ATENDIDO ───" + atendido.toString());
          else
            System.out.println("\n\nERRO - Nenhuma pessoa nas filas.\n");
          break;
        case 4:
          System.out.println(atendimento.showQueues());
          break;
        case 5:
          if(atendimento.isEmpty()){
            System.out.println("\n========================================");
            System.out.println("ADEUS, AMIGO! Espero que tenha gostado!");
            System.out.println("========================================\n\n");
            sc.close(); //Fecha o scanner
            System.exit(0);
          }
          else
            System.out.println("ERRO - A fila deve estar vazia antes de encerrar o programa.");
            option = 0; //Limpar variável option para reexibir Menu Principal
            break;
        default:
          System.out.println("ERRO - Opção inválida.");
      }
    }while(option != 5);
  }
}