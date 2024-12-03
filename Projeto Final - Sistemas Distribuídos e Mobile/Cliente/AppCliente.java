import java.net.MalformedURLException;
import java.rmi.*;
import java.util.Scanner;

public class AppCliente {
	public static void main(String args[]) throws MalformedURLException, RemoteException, NotBoundException {
		Scanner sc = new Scanner(System.in); // Scanner para entrtada de dados
		int opcao; // Vai guardar a opção do menu

		do{
			// MENU PRINCIPAL
			System.out.println("\n\n ┌──────┤ GOLDS BANK ├──────┐");
			System.out.printf(" │ %-24s │\n", "Informe uma das opcoes:");
			System.out.printf(" │ %-24s │\n", "1 - Adicionar Conta");
			System.out.printf(" │ %-24s │\n", "2 - Remover Conta");
			System.out.printf(" │ %-24s │\n", "3 - Exibir Dados"); 
			System.out.printf(" │ %-24s │\n", "4 - Transferir"); 
			System.out.printf(" │ %-24s │\n", "5 - Sacar");
			System.out.printf(" │ %-24s │\n", "6 - Depositar");
			System.out.printf(" │ %-24s │\n", "0 - Sair");
			System.out.println(" └──────────────────────────┘\n\n");
			System.out.print("Informe uma opção: ");
			opcao = sc.nextInt();
			sc.nextLine(); // Limpa o buffer
			System.out.print("\n"); // Pula uma linha

			// Acesso ao Binder pelo nome que fora registrado
			Metodos metodos = (Metodos) Naming.lookup("rmi://localhost:1099/Metodos");

			Status status = new Status(); // Para receber a resposta do servidor
			// Precisa ser inicializado para sempre "zerar" após uma nova entrada do menu principal

			switch(opcao){

				case 1: // Adicionar Conta
					Conta conta = new Conta();
					System.out.print("Informe o NOME do cliente: ");
					conta.setNomeCliente(sc.nextLine());
					System.out.print("Informe o CPF do cliente: ");
					conta.setCpf(sc.nextLine());
					status = metodos.adicionarConta(conta);
					break;

				case 2: // Remover Conta
					System.out.print("Informe o CPF do titular da conta a ser removida: ");
					String cpf_para_remover = sc.nextLine();
					status = metodos.removerConta(new ArgsBuscarExibirRemover(cpf_para_remover));
					break;

				case 3: //Exibir Dados
					System.out.print("Informe o CPF do titular da conta a ser exibida: ");
					String cpf_para_buscar = sc.nextLine();
					status = metodos.exibirConta(new ArgsBuscarExibirRemover(cpf_para_buscar));
					((StatusAndDados)status).exibirDados();
					break;

				case 4: //Transferir
					System.out.print("Informe o CPF do titular da conta que irá transferir: ");
					String cpf_conta_origem = sc.nextLine();
					System.out.print("Informe o CPF do titular da conta que receberá a transferência: ");
					String cpf_conta_destino = sc.nextLine();
					System.out.print("Qual valor deseja transferir? R$");
					double valor_a_transferir = sc.nextDouble();
					status = metodos.transferir(new ArgsTransferir(cpf_conta_origem, cpf_conta_destino, valor_a_transferir));
					break;

				case 5: // Sacar
					System.out.print("Informe o CPF do titular da conta da qual deseja sacar: ");
					String cpf_conta_sacar = sc.nextLine();
					System.out.print("Qual valor a ser sacado? R$");
					double valor_a_sacar = sc.nextDouble();
					status = metodos.sacar(new ArgsSacarDepositar(cpf_conta_sacar, valor_a_sacar));
					break;

				case 6: // Depositar
					System.out.print("Informe o CPF do titular da conta na qual deseja depositar: ");
					String cpf_conta_depositar = sc.nextLine();
					System.out.print("Qual valor a ser depositado? R$");
					double valor_a_depositar = sc.nextDouble();
					status = metodos.depositar(new ArgsSacarDepositar(cpf_conta_depositar, valor_a_depositar));
					break;

				case 0:
					System.out.println("Tudo bem, Tchau!\n");
					sc.close(); // Fecha o Scanner

					try {
						metodos.stopServer(); // Encerra o Processo Servidor
					} catch (Exception e) {
						System.exit(0); // Encerra o Processo Cliente
					}
					
					break;
				
				default:
					status = new Status(6);
			}

			status.exibirMensagem(); // Imprime o status da operação, recebido do servidor

		}while(opcao != 0); // Enquanto a opção for diferente de "0 - Sair", repita

		sc.close(); // Fecha o Scanner
	}
}