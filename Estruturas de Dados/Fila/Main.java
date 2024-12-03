package Aula10.Fila;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) throws NumberFormatException {
        Metodos metodo = new Metodos();
        final String ERRO = "ERRO";

        while(true){
            //Interface gráfica
            //Input é uma entrada de dados
            //Operação 1 faça tal coisa, 2 tal coisa, etc.
            //Entramos com uma informação e ele exibe algo
            //As informações inseridas são recebidas como String
            int op = Integer.parseInt(JOptionPane.showInputDialog("1 - Enqueue\n" +
                                                                   "2 - Dequeue\n" +
                                                                   "3 - Size\n" +
                                                                   "4 - Empty\n" +
                                                                   "5 - Front\n" +
                                                                   "6 - Sair\n"));
            //O parse é um método que converte definitivamente String em int
            switch(op){
                case 1:
                    int num = Integer.parseInt(JOptionPane.showInputDialog("Digite um número"));
                    metodo.enqueue(num);
                    break;
                case 2:
                    try{
                        metodo.dequeue();
                    }catch (IllegalArgumentException e){
                        JOptionPane.showMessageDialog(null, e.getMessage(), ERRO, JOptionPane.ERROR_MESSAGE);
                        //O Primeiro parâmetro é null porque não estamos trabalhando com frames
                        //O Segundo é a mensagem
                        //O Terceiro é o título da janela (final String ERRO = "ERRO")
                        //o Quarto é o ícone da mensagem
                    }
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, metodo.size(), "Size", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, (metodo.empty())? "Sim":"Não", "Empty", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 5:
                    try{
                        JOptionPane.showMessageDialog(null, metodo.front().getInfo());
                    }catch(IllegalArgumentException e){
                        //Colocar a exceção específica é uma boa prática de programação
                        //A classe Exception é a superclasse das exceções
                        JOptionPane.showMessageDialog(null, e.getMessage(), ERRO, JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case 6:
                    System.exit(0);
                    break;
                    //Break não obrigatório
                    //Alguns programadores dizem ser uma boa prática usar o break até no default para
                    //evitar erros no programa. 
                    //System.exit(0) finaliza o programa
                    //O 0 é como uma mensagem padrão para dizer que o programa foi interrompido sem erros.
                default:
                    break;
                 
            }
        }

    }
}
