package Simulado;

public class Produto {
    private int estoque;
    private float preco;
    //private int vendas=0;
    private int receita=0;

    public Produto(int estoque, float preco){
        this.estoque = estoque;
        this.preco = preco;
    }

    public int getEstoque(){
        return estoque;
    }

    public float getPreco(){
        return preco;
    }
    public float getReceita(){
        //return vendas*preco;
        return receita;
    }

    public void ajustarPreco(float porcentagem){
        preco += preco*(porcentagem/100);
    }

    public float tentarCompra(float pagamento){
        if(pagamento>=preco && estoque>0){
            //vendas++;
            receita += preco;
            estoque--;
            return pagamento-preco;
        }else{
            return pagamento;
        }
    }
}
