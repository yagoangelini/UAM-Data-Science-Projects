package Projeto.Chiclete;

import java.util.ArrayList;

public class Comanda { //Controla a comanda do cliente
    private ArrayList<Sabores> comanda = new ArrayList<>(); //Cria uma ArrayList de Sabores, os quais o cliente pedirá
    private String endereco; //variável que armazena o endereco do cliente
    private int fPagamento=0; //variável que armazena a forma de pagamento escolhida pelo cliente
    private float total=0; //variável que armazena o total da compra

    public void setEndereco(String endereco){
        this.endereco = endereco;
    }

    public void setfPagamento(int fPagamento){
        this.fPagamento = fPagamento;
    }

    /**
     * Adiciona o pedido do cliente à arrayList de sabores da comanda do cliente
     * @param sabor Sabores
     */
    public void adicionar(Sabores sabor){
        comanda.add(sabor);
    }

    /**
     * Calcula e retorna o total da compra do cliente
     * @return total
     */
    public float calcularTotal(){
        total = 0;
        for(int i=0; i<comanda.size(); i++){
            total += comanda.get(i).getPreco();
        }
        return total;
    }

    /**
     * Caso a forma de pagamento já tenha sido definida pelo cliente, retorna ela, caso contrário, retorna uma String vazia.
     */
    public String retornaFormaDePagamento(){
        if(fPagamento == 0){
            return "";
        }
        return "Forma de pagamento: " + fPagamento;
    }

    /**
     * Imprime a comanda completa do cliente
     */
    public void imprimirComanda(){
        System.out.println("============COMANDA============");
        for(int i=0; i<comanda.size();i++){
            System.out.println(comanda.get(i));
        }
        System.out.println("\nTotal: R$" + calcularTotal() +
                           "\nEndereço: " + endereco + "\n" +
                           retornaFormaDePagamento());
    }
}
