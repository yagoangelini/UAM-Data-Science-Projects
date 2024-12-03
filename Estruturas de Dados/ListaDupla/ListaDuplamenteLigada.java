package Aula09.ListaDupla;

public class ListaDuplamenteLigada {
    public static void main(String[] args) {
        Metodos m = new Metodos();

        m.inserirElemento("123");
        //m.inserirElemento("Teste");
        //m.inserirElemento("Testando");

        m.exibirDoFinal();
        System.out.println();

        m.exibirDoInicio();
        System.out.println();

        System.out.println(m.pesquisar("123"));

        // System.out.println(m.quantidadeElementos + "\n");

        m.removerElemento("123");

        m.exibirDoInicio();
        System.out.println();

        System.out.println(m.pesquisar("123"));

        // System.out.println(m.quantidadeElementos);
    }
}
