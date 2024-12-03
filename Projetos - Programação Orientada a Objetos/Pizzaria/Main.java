package Projeto.Pizzaria;

import java.util.Scanner;
import java.lang.Thread;
public class Main{
    public static void main(String[] args){
        Chatbot bot = new Chatbot();
        Cardapio cardapio = new Cardapio();
        Comanda comanda = new Comanda();

        // criando as respostas
        Resposta rs1 = new RespostaSimples("nome", "Pizzaiolo, a seu dispor!");
        Resposta rs2 = new RespostaData("dia");
        Resposta rs3 = new RespostaHora("hora");
        Resposta rs4 = new RespostaContador("conta");

        // criando o cardápio
        cardapio.adicionarItem(new Sabores(1, "À MODA", "Frango, palmito e mussarela", 35.00f));
        cardapio.adicionarItem(new Sabores(2, "BAURU", "Brócolis coberto com mussarela", 32.00f));
        cardapio.adicionarItem(new Sabores(3, "BRÓCOLIS", "Calabresa e cebola", 32.00f));
        cardapio.adicionarItem(new Sabores(4, "CALABRESA", "Frango, palmito e mussarela", 32.00f));
        cardapio.adicionarItem(new Sabores(5, "DO PIZZAIOLO", "Peito de peru, mussarela, catupiry, ovo e bacon", 32.00f));
        cardapio.adicionarItem(new Sabores(6, "FRANGO", "Frango coberto com catupiry", 35.00f));
        cardapio.adicionarItem(new Sabores(7, "JARDINEIRA", "Escarola, Palmito, bacon, ervilha, ovo e tomate", 35.00f));
        cardapio.adicionarItem(new Sabores(8, "PORTUGUESA", "Presunto, ovo, cebola, ervilha e mussarela", 35.00f));
        cardapio.adicionarItem(new Sabores(9, "PORTUGUESA II", "Presunto, palmito, catupiry, bacon e ovo", 35.00f));
        cardapio.adicionarItem(new Sabores(10, "QUATRO QUEIJOS", "Mussarela, catupiry, provolene e parmesão", 37.00f));
        Resposta rs5 = new RespostaAleatoria("recomenda", cardapio);
        Resposta rs6 = new RespostaPedido("pedido", comanda, cardapio);

        // adicionando as respostas ao chatbot
        bot.adiciona(rs1);
        bot.adiciona(rs2);
        bot.adiciona(rs3);
        bot.adiciona(rs4);
        bot.adiciona(rs5);
        bot.adiciona(rs6);

        System.out.println("------------------------------------");
        System.out.println("Iniciando o chatbot");

        try{
            Thread.sleep(1500);
        }catch(InterruptedException ex){
            Thread.currentThread().interrupt();
        }

        System.out.println("------------------------------------");
        System.out.println("PIZZAIOLO - Olá! Meu nome é Pizzaiolo, como posso te ajudar?\n");
        Scanner sc = new Scanner (System.in);
        String texto;

        do{
            System.out.print("> ");
            texto = sc.nextLine();
            if((texto.contains("obrigado") || texto.contains("fico no aguardo") || texto.contains("espero a entrega"))){
                System.out.println("\nPIZZAIOLO - Bom apetite! Volte sempre.\n");
                break;
            }
            System.out.println("\nPIZZAIOLO - " + bot.processar(texto) + "\n");
        }while(true);

        sc.close();
    }
}