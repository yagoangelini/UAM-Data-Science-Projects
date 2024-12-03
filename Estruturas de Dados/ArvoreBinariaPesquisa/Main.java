package Aula13.ArvoreBinariaPesquisa;

public class Main {
    public static void main(String[] args) {
        Metodos m = new Metodos();

        m.inserir(12);
        m.inserir(3);
        m.inserir(45);
        m.inserir(6);
        m.inserir(17);
        m.inserir(11);
        m.inserir(22);
        m.inserir(9);
        m.inserir(0);
        m.inserir(36);
        m.inserir(48);
        m.inserir(11);
        
        //m.PercursoOrdem(m.getRaiz());

        //m.PercursoPreOrdem(m.getRaiz());

        m.PercursoPosOrdem(m.getRaiz());

        System.out.println(m.buscar(13));
    }
}
