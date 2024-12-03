package Projeto.Pizzaria;

public class Sabores{
	private int id;
	private String nome;
	private float preco;
	
	public Sabores(int id, String nome, String ingredientes, float preco){
		this.id = id;
		this.nome = nome;
		this.preco = preco;
	}

	public int getId(){return id;}

	public String getNome(){return nome;}

	public float getPreco(){return preco;}

	public void setId(int id){this.id = id;}

	public void setNome(String nome){this.nome = nome;}

	public void setPreco(float preco){this.preco = preco;}

	public boolean verifica(String entrada){
		return nome.contains(entrada);
	}
}

