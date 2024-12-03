package Projeto.Chiclete;
public class Sabores { 
    private int id;
    private String nome;
    private float peso, preco;

    public Sabores(int id, String nome, float peso, float preco){
        this.id = id;
        this.nome = nome;
        this.peso = peso;
        this.preco = preco;
    }

    public String getNome(){
        return nome;
    }

    public float getPreco(){
        return preco;
    }

    public String toString(){
        return String.format("%02d - ", id) + "Nome: " + nome + " | Peso: " + peso + " | Preço: R$" + preco;
    }

    public boolean verifica(String entrada){
        return entrada.contains(nome);
    }
}
