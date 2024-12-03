package AulaExtra.Pilha;

import javax.swing.JOptionPane;

public class Main{
    public static void main(String[] args) {
        Metodos m = new Metodos();
        String[] opcoes = {" 1 - Push ", " 2 - Pop ", " 3 - Empty ", " 4 - Top ", " 5 - Size ", " 6 - Sair "};

        while(true){
            int op = JOptionPane.showOptionDialog(null, "Escolha uma das opções", "M E N U", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
            switch(op){
                case 0:
                    try{
                        int valor = Integer.parseInt(JOptionPane.showInputDialog(null, "Valor", "Push", JOptionPane.QUESTION_MESSAGE));
                        m.push(valor);
                    }catch(NumberFormatException e){
                        JOptionPane.showMessageDialog(null, "Valor inválido", "ERRO", JOptionPane.ERROR_MESSAGE, null);
                    }
                    break;
                case 1:
                    try{
                        m.pop();
                        JOptionPane.showMessageDialog(null, "Remoção realizada com sucesso!", "Pop", JOptionPane.INFORMATION_MESSAGE, null);
                    }catch(NullPointerException e){
                        JOptionPane.showMessageDialog(null, "Lista vazia", "ERRO", JOptionPane.ERROR_MESSAGE, null);
                    }
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, m.empty()? "Sim":"Não", "Empty", JOptionPane.INFORMATION_MESSAGE, null);
                    break;
                case 3:
                    try{
                        JOptionPane.showMessageDialog(null, m.top().getInfo(), "Top", JOptionPane.INFORMATION_MESSAGE, null);
                    }catch(NullPointerException e){
                        JOptionPane.showMessageDialog(null, "Lista vazia", "ERRO", JOptionPane.ERROR_MESSAGE, null);
                    }
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, m.size(), "Size", JOptionPane.INFORMATION_MESSAGE, null);
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }
}
