package Projeto.Chiclete;
import java.util.ArrayList;

public class Produtos {
    private ArrayList<Sabores> produtos = new ArrayList<>();

    /**
     * Adiciona um produto à lista de produtos.
     * @param sabor Sabores
     */
    public void adicionar(Sabores sabor){
        produtos.add(sabor);
    }

    /**
     * Retorna a lista de produtos.
     * @return produtos
     */
    public ArrayList<Sabores> getProdutos(){
        return produtos;
    }

    /** 
     * Imprime a lista de produtos.
    */
    public void imprimirProdutos(){
        System.out.println("\n==================PRODUTOS==================");
        for(int i=0; i<produtos.size(); i++){
            System.out.println(produtos.get(i));
        }
    }

    /**
     * Pesquisa na lista de produtos se há algum produto com o nome passado por parâmetro.
     * @param entrada String
     * @return A instância de produtos que contém o nome especificado, ou null se não encontrar.
     */
    public Sabores pesquisar(String entrada){
        for(int i=0; i<produtos.size(); i++){
            if(produtos.get(i).verifica(entrada))
                return produtos.get(i);
        }
        return null;
    }
}
