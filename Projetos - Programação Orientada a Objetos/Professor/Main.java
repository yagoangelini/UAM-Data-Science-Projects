package Projeto.Professor;

import java.util.ArrayList;
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Chatbot bot = new Chatbot();

        // criando as respostas
        Resposta rs1 = new RespostaSimples("nome", "Meus amigos me chamam de AnhembiBot.");
        Resposta rs2 = new RespostaData("dia");
        Resposta rs3 = new RespostaHora("hora");
        Resposta rs4 = new RespostaContador("conta");

        // criando as piadas
        ArrayList<String> piadas = new ArrayList<>();
        piadas.add("Qual é o peixe baterista ? A truta !");
        piadas.add("Qual é o peixe que cai do céu? Atum !");
        Resposta rs5 = new RespostaAleatoria("piada", piadas);

        // adicionando as respostas ao chatbot
        bot.adiciona(rs1);
        bot.adiciona(rs2);
        bot.adiciona(rs3);
        bot.adiciona(rs4);
        bot.adiciona(rs5);

        System.out.println("------------------------------------");
        System.out.println("Iniciando o chatbot");
        System.out.println("------------------------------------");
        Scanner entrada = new Scanner (System.in);
        String texto;

        // loop infinito para ficar lendo as perguntas do usuario
        while(true){
            System.out.print("> ");
            texto = entrada.nextLine();
            System.out.println(bot.processar(texto));
        }
    }
}