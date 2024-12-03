package Aula08.LinkedList;

public class ListaSimplesmenteLigada {
    public static void main(String[] args) {
        Metodos m = new Metodos();
        Pessoa pessoa1 = new Pessoa("Marco", 45, 1);
        Pessoa pessoa2 = new Pessoa("Ana", 43, 2);
        Pessoa pessoa3 = new Pessoa("Yago", 19, 3);
        Pessoa pessoa4 = new Pessoa("Teste", 20, 4);

        m.inserirElemento(pessoa1);
        m.inserirElemento(pessoa2);
        m.inserirElemento(pessoa3);
        m.inserirElemento(pessoa4);

        m.exibir();
        System.out.println();

        m.remover(pessoa4);

        m.exibir();
        System.out.println();
        
        System.out.println(m.pesquisar(1));
        //Usamos .getObjeto() para imprimir o objeto que o Elemento contém, ao invés
        //da referência, porque não há um toString, porque é só uma lista de exemplos
    }
}
