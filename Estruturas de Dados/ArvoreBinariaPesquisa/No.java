package Aula13.ArvoreBinariaPesquisa;

public class No {
    private No esquerda, direita;
    private int valor;

    public No(){} //Construtor vazio (boa prática)

    public No(No esquerda, No direita, int valor) {
        this.esquerda = esquerda;
        this.direita = direita;
        this.valor = valor;
    }

    public No getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(No esquerda) {
        this.esquerda = esquerda;
    }

    public No getDireita() {
        return direita;
    }

    public void setDireita(No direita) {
        this.direita = direita;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    
    @Override
    public String toString() {
        return "No [direita=" + direita + ", esquerda=" + esquerda + ", valor=" + valor + "]";
    }
}
