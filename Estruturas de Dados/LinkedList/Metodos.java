package Aula08.LinkedList;

public class Metodos {
    private Elemento atual=null;
    private int quantidade=0;
    
    public Elemento getAtual() {
        return atual;
    }

    /**
     * 
     * Inserir um Elemento na Lista Simplesmente Encadeada
     * @param objeto
     */
    public void inserirElemento(Object objeto){
        Elemento novoElemento = new Elemento(objeto, atual);
        //Passa a informação que quer que fique dentro do elemento, e 
        //o atual no momento é null
        this.atual = novoElemento;
        //Assim, o atual agora recebe o novo elemento
        //O elemento criado com o construtor, recebe a referência ao elemento anterior
        //que nessa classe chama-se atual. Logo depois, ele é alterado nessa classe,
        //mas seu valor permanece inalterado dentro do Elemento construído
        quantidade++;
    }

    /**
     * Exibir as informações da Lista Simplesmente Encadeada
     * Os elementos serão exibidos do último para o primeiro.
     */
    public void exibir(){
        Elemento exibe = this.atual;
        //Criação da referência que aponta para o atual
        //Do fim para o início
        while(exibe!=null){//Enquanto não chega no início da lista
            System.out.println(exibe.getObjeto());//imprime a informação que o Elemento carrega
            exibe = exibe.getAnt();//exibe recebe o elemento anterior, e depois o anterior do anterior...

        }
    }

    /*
    public Elemento pesquisar(Object objeto){
        Elemento pesquisa = this.atual;
        while(pesquisa != null){
         if(pesquisa.getObjeto().equals(objeto)){
            //Usamos equals porque estávamos tratando com strings
           return pesquisa;
         }
         pesquisa = pesquisa.getAnt();
        }
        return null;
    }
    */

    /**
     * Pesquisa por id na lista simplesmente encadeada, do fim para o início.
     * Caso não encontre, imprime erro.
     * @param id
     * @return Pessoa, se for encontrada, e null se não for encontrada
     */
    public Pessoa pesquisar(int id){
        Elemento pesquisa = this.atual;
        Pessoa p;
        while(pesquisa!=null){
            p = (Pessoa) pesquisa.getObjeto(); //Casting = Conversão temporária = Continua sendo Elemento
            if(p.getId() == id)
                return p;
            pesquisa = pesquisa.getAnt();
        }
        System.out.println("\nElemento não encontrado\n");
        return null;
    }

    /**
     * Auxiliar do método remove().
     * Retorna o vetor que contém o Elemento a ser removido e o Elemento à direita do que será removido.
     * @param objeto
     * @return Elemento[] se for encontrada, e null se não for encontrada.
     */
    private Elemento[] encontrarParaRemover(Object objeto){
        Elemento pesquisa = this.atual, auxPesquisa = null;
        Elemento[] pesq = new Elemento[2];
        while(pesquisa!=null){
            if(pesquisa.getObjeto().equals(objeto)){
                pesq[0] = pesquisa; //Elemento a ser removido
                pesq[1] = auxPesquisa; //Elemento à direita (Antes -- Depois)
                return pesq;
            }
            auxPesquisa = pesquisa;
            pesquisa = pesquisa.getAnt();
        }
        return null;
    }

    /**
     * Primeiro encontraParaRemover() o Elemento, e se não for nulo, prossegue.
     * Remove um Elemento da lista simplesmente encadeada.
     * @param objeto
     */
    public void remover(Object objeto){
        Elemento remove = encontrarParaRemover(objeto)[0];
        Elemento auxRemove = encontrarParaRemover(objeto)[1];
        if(remove!=null){
            //REMOVER ÚLTIMO DA DIREITA
            if(auxRemove == null){ //ou if(remove==this.atual)
                this.atual = remove.getAnt(); //O novo atual é o elemento da esquerda
                remove.setAnt(null); //Corta a conexão entre esse elemento e o anterior
                //Agora o Garbage Collector cuida da eliminação desse Elemento da memória
            }
            //REMOVER PRIMEIRO DA ESQUERDA
            else if(remove.getAnt() == null){ //Se o elemento da esquerda é null, então esse é o 1º elemento
                auxRemove.setAnt(null); //Só precisa declarar o anterior como null
                //Não é necessário mudar o atual porque o atual é o último da direita
            }
            //REMOVER UMA POSIÇÃO QUALQUER
            else{
                //Agora o anterior do elemento da direita do removido será o anterior do removido
                auxRemove.setAnt(remove.getAnt());
                //Desconecta o removido do anterior
                remove.setAnt(null);
            }
        }
    }
    
}
