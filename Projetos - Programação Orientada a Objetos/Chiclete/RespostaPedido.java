package Projeto.Chiclete;
import java.util.Scanner;

public class RespostaPedido extends Resposta{
    private Scanner sc = new Scanner(System.in);
    private Comanda comanda;
    private Produtos produtos;
    private Sabores temp;
    private char resp = 'S';
    private String endereco=null;
    private int fPagamento=0;
    
    public RespostaPedido(String keyWord, Produtos produtos){
        super(keyWord);
        this.produtos = produtos;
    }
    
    @Override
    public boolean verifica(String entrada){
		return entrada.contains(keyWord);
	}

    @Override
    public String produz(){
        comanda = new Comanda();
        System.out.println();
		produtos.imprimirProdutos(); //Imprime a lista de produtos
        System.out.println();
        do{
            System.out.println("\nCHICLEBOT - Qual o sabor desejado (Informe o nome)?\n");
            System.out.print("> ");
            temp = produtos.pesquisar(sc.nextLine().toUpperCase()); //Pesquisa com caixa alta, pois os nomes dos sabores estão em caixa alta
            if(temp != null){
                comanda.adicionar(temp); //Adiciona o sabor desejado à comanda
                System.out.println("\nCHICLEBOT - Deseja mais algum produto (S ou N)?\n");
                System.out.print("> ");
                resp = sc.nextLine().toUpperCase().charAt(0);
            }else
                System.out.println("\nCHICLEBOT - Informe um produto válido."); //Imprime erro se for um sabor inválido
        }while(temp == null || resp == 'S'); //Enquanto a entrada não for um sabor válido OU desejar mais algum produto

        do{
            System.out.println("\nCHICLEBOT - Qual o endereço para entrega?\n");
            System.out.print("> ");
            endereco = sc.nextLine();
            if(endereco != null) //Se não for um endereço válido
                comanda.setEndereco(endereco); //Envia o endereço do cliente para a comanda
        }while(endereco == null); //Enquanto não for um endereço válido

        System.out.println("\n");
        comanda.imprimirComanda(); //Imprime a comanda do cliente

        do{
            System.out.println("\n======================FORMAS DE PAGAMENTO======================");
            System.out.println("1 - Dinheiro");
            System.out.println("2 - Cartão de crédito");
            System.out.println("3 - Cartão de débito");
            System.out.println("Obs: O pagamento será realizado na entrega.\n");
            System.out.println("\nCHICLEBOT - Qual a forma de pagamento (Informe o número)?\n");
            System.out.print("> ");
            fPagamento = sc.nextInt();
            sc.nextLine();//Limpa o buffer
            if(fPagamento>=1 && fPagamento<=3)
                comanda.setfPagamento(fPagamento); //Caso seja inserida uma forma de pagamento válida, envia a forma escolhida pelo cliente para a comanda
            else
                System.out.println("\nCHICLEBOT - Informe uma forma de pagamento válida.");
        }while(!(fPagamento>=1 && fPagamento<=3));

        System.out.println("\n");
        comanda.imprimirComanda(); //Imprime a comanda do cliente com a forma de pagamento

        return "\nCHICLEBOT - Pedido fechado e realizado com sucesso!\n" + "\nCHICLEBOT - Em que mais posso ajudar?\n";
	}
}
