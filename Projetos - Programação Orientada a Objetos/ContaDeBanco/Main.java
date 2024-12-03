package APS.ContaDeBanco;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main(String[] args) {
        GerenciarConta admin = new GerenciarConta();
        Scanner sc = new Scanner(System.in);
        int op = 0, tipo = 0;

        /**
         * Implementação do rendimento da poupança por minuto.
         * No GoldBank Prime, a porcentagem de rendimento por minuto é de 10%.
         */
        final long time = 60000;//A cada 60000ms = 1 minuto
        Timer timer = new Timer();
        TimerTask tarefa = new TimerTask(){
            public void run(){
                try{
                    for(int i=0; i<admin.getContas().size(); i++){
                        if(admin.getContas().get(i) instanceof ContaPoupanca){
                            ContaPoupanca c = (ContaPoupanca) admin.getContas().get(i);
                            c.calcularRendimento(10);
                        }
                    }
                }catch(Exception e){
                    e.printStackTrace();//Imprime a exceção e
                }
            }
        };
        //Executa o rendimento da poupança a cada 60000ms.
        timer.scheduleAtFixedRate(tarefa, time, time);

        System.out.println("Seja bem-vindo ao GoldBank Prime! Informe como podemos te ajudar.\n");

        do{

            System.out.println("╭─────────────────────────────────────╮");
            System.out.printf("│  %-33s  │\n│  %-33s  │\n│  %-33s  │\n", "", "GOLDBANK PRIME - MENU", "");
            System.out.printf("│  %-33s  │\n", "1 - Adicionar Conta");
            System.out.printf("│  %-33s  │\n", "2 - Remover Conta");
            System.out.printf("│  %-33s  │\n", "3 - Buscar Contas Especiais");
            System.out.printf("│  %-33s  │\n", "4 - Buscar Clientes Usando Limite");
            System.out.printf("│  %-33s  │\n", "5 - Buscar Conta");
            System.out.printf("│  %-33s  │\n", "6 - Transferir Valor");
            System.out.printf("│  %-33s  │\n", "7 - Sacar");
            System.out.printf("│  %-33s  │\n", "8 - Depositar");
            System.out.printf("│  %-33s  │\n", "9 - Listar Contas");
            System.out.printf("│  %-33s  │\n│  %-33s  │\n", "0 - Sair", "");
            System.out.println("╰─────────────────────────────────────╯\n");
            
            System.out.print("» Informe a opção desejada: ");
            op = sc.nextInt();
            sc.nextLine();
            System.out.println();

            switch(op){
                case 1:
                    do{    
                        System.out.println("Qual tipo de conta deseja criar?\n");
                        System.out.println(" 1 - Conta Corrente");
                        System.out.println(" 2 - Conta Poupança");
                        System.out.println(" 3 - Conta Especial");
                        System.out.print("\n» Informe a opção desejada: ");
                        tipo = sc.nextInt();
                        sc.nextLine();
                        if(!(tipo>=1 && tipo<=3))
                            System.out.println("\n╳ Informe uma opção válida ╳\n");
                    }while(!(tipo>=1 && tipo<=3));

                    System.out.print("\n» Informe o número da conta: ");
                    int numConta = sc.nextInt();
                    sc.nextLine();
                    System.out.print("» Informe o Nome do cliente: ");
                    String nomeCliente = sc.nextLine();
                    System.out.print("» Informe o CPF do cliente: ");
                    String CPF = sc.nextLine();

                    switch(tipo){
                        case 1:
                            System.out.print("» Informe o limite da conta: ");
                            double limite = sc.nextDouble();
                            sc.nextLine();
                            admin.adicionarConta(new ContaCorrente(numConta, nomeCliente, CPF, limite));
                            System.out.println("\nConta Corrente cadastrada com sucesso!\n");
                            break;
                        case 2:
                            admin.adicionarConta(new ContaPoupanca(numConta, nomeCliente, CPF));
                            System.out.println("\nConta Poupança cadastrada com sucesso!\n");
                            break;
                        case 3:
                            System.out.print("» Informe o limite da conta: ");
                            limite = sc.nextDouble();
                            sc.nextLine();
                            System.out.print("» Informe o Nome do Gerente Responsável: ");
                            String nomeDoGerenteResponsavel = sc.nextLine();
                            admin.adicionarConta(new ContaEspecial(numConta, nomeCliente, CPF, limite, nomeDoGerenteResponsavel));
                            System.out.println("\nConta Especial cadastrada com sucesso!\n");
                            break;
                    }
                    break;

                case 2:
                    System.out.print("Informe o número da conta a ser removida: ");
                    System.out.println((admin.removerConta(sc.nextInt()))? "\nRemoção realizada com sucesso!\n":"\n╳ Falha na remoção ╳\n");
                    break;

                case 3:
                    System.out.println(admin.buscarContasEspeciais());
                    break;

                case 4:
                    System.out.println(admin.buscarClientesUsandoLimite());
                    break;

                case 5:
                    System.out.print("Informe o número da conta a ser pesquisada: ");
                    Conta cPesquisa = admin.buscarConta(sc.nextInt());
                    if(cPesquisa == null)
                        System.out.println("\n╳ Nenhuma conta encontrada ╳\n");
                    else
                        System.out.println("\n" + cPesquisa);
                    break;

                case 6:
                    System.out.print("Informe o número da conta Fonte: ");
                    int numContaFonte = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Informe o número da conta Destino: ");
                    int numContaDestino = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Qual o valor a ser transferido? R$");
                    double valor = sc.nextDouble();
                    sc.nextLine();
                    System.out.println((admin.transferirValor(numContaFonte, numContaDestino, valor))? "\nTransferência realizada com sucesso!\n":"\n╳ Falha na transferência ╳\n");
                    break;

                case 7:
                    System.out.print("Informe o número da conta para sacar: ");
                    numConta = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Qual o valor a ser sacado? R$");
                    valor = sc.nextDouble();
                    sc.nextLine();
                    System.out.println((admin.sacar(numConta, valor))? "\nSaque realizado com sucesso!\n":"\n╳ Falha no saque ╳\n");
                    break;

                case 8:
                    System.out.print("Informe o número da conta para depositar: ");
                    numConta = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Qual o valor a ser depositado? R$");
                    valor = sc.nextDouble();
                    sc.nextLine();
                    System.out.println((admin.depositar(numConta, valor))? "\nDepósito realizado com sucesso!\n":"\n╳ Falha no depósito ╳\n");
                    break;

                case 9:
                    System.out.println(admin.listarContas());
                    break;

                case 0:
                    break;

                default:
                    System.out.println("\n╳ Informe um código válido ╳\n");
            }

        }while(op != 0);

        System.out.println("\nTchau!\n");

        sc.close();
    }
}
