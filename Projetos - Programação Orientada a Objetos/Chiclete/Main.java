package Projeto.Chiclete;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Chatbot bot = new Chatbot();
        Produtos produtos = new Produtos();

        // criando as respostas
        Resposta rs1 = new RespostaSimples("nome", "Meus amigos me chamam de AnhembiBot.");
        Resposta rs2 = new RespostaData("dia");
        Resposta rs3 = new RespostaHora("hora");
        Resposta rs4 = new RespostaContador("conta");

        // criando os produtos
        produtos.adicionar(new Sabores(1, "BLUE", 20.5f, 15.00f));
        produtos.adicionar(new Sabores(2, "GREEN", 20.5f, 15.00f));
        produtos.adicionar(new Sabores(3, "PINK", 20.5f, 15.00f));
        produtos.adicionar(new Sabores(4, "RED", 20.5f, 15.00f));
        produtos.adicionar(new Sabores(5, "WHITE", 20.5f, 15.00f));
        produtos.adicionar(new Sabores(6, "BLACK", 25.2f, 30.00f));
        produtos.adicionar(new Sabores(7, "ORANGE", 20.5f, 15.00f));
        produtos.adicionar(new Sabores(8, "PURPLE", 20.5f, 15.00f));
        produtos.adicionar(new Sabores(9, "YELLOW", 20.5f, 15.00f));
        produtos.adicionar(new Sabores(10, "SILVER", 25.5f, 30.00f));
        Resposta rs5 = new RespostaAleatoria("recomenda", produtos);
        Resposta rs6 = new RespostaPedido("pedido", produtos);

        // adicionando as respostas ao chatbot
        bot.adiciona(rs1);
        bot.adiciona(rs2);
        bot.adiciona(rs3);
        bot.adiciona(rs4);
        bot.adiciona(rs5);
        bot.adiciona(rs6);


        System.out.println("------------------------------------");
        System.out.println("Iniciando o chatbot");
        System.out.println("------------------------------------");
        System.out.println("CHICLEBOT - Olá, meu nome é ChicleBot, como posso te ajudar?\n");
        Scanner entrada = new Scanner (System.in);
        String texto;

        // loop infinito para ficar lendo as perguntas do usuario
        do{
            System.out.print("> ");
            texto = entrada.nextLine().toLowerCase(); //A variável texto recebe a entrada em caixa baixa
            if(texto.contains("obrigado") || texto.contains("nada"))
                System.out.println("\nCHICLEBOT - Muito obrigado. Até a próxima!\n");
            else
                System.out.println("\n" + bot.processar(texto) + "\n");

        }while(!(texto.contains("obrigado") || texto.contains("nada")));

        entrada.close();
    }
}