package AulaExtra.Pilha;

public class Metodos {
    private Elemento atual, aux;
    //Não é necessário um Elemento início, porque não precisamos usá-lo em uma pilha, apenas o do topo
    private int quantidadeElementos=0;
    
    /**
     * Insere um novo Elemento na fila.
     * 
     * @param info Object
     */
    public void push(Object info){
        if(empty()){ //Se for o primeiro elemento a ser inserido
            //Instancia um novoElemento que tem anterior e próximo nulos e contém uma informação
            Elemento novoElemento = new Elemento(null, null, info);
            //O Elemento aux agora é o novoElemento criado
            this.atual = novoElemento;
            //O Elemento atual agora é o novoElemento criado
            this.aux = atual;
        }else{
            //Instancia um novoElemento que tem o atual como anterior, próximo nulo e contém uma informação
            Elemento novoElemento = new Elemento(atual, null, info);
            this.aux = this.atual; //1º MODO DE TRATAR O AUX, está recebendo o anterior de novoElemento
            //O atual agora é o novoElemento criado
            this.atual = novoElemento;
            //O próximo do aux agora é o novoElemento
            this.aux.setProx(atual);
                //this.aux = atual; //2º MODO DE TRATAR O AUX, coloca o aux na mesma posição que o novoElemento
        }
        this.quantidadeElementos++;
    }

    /**
     * Remove o elemento localizado no topo da pilha.
     * Após a remoção, a quantidade de Elementos é decrementada.
     * 
     * @param info Object
     * @return true se a remoção for bem sucedida, false em caso contrário.
     * @throws NullPointerException
     */
    public void pop() throws NullPointerException{
        if(!empty()){
            //REMOÇÃO DO PRIMEIRO ELEMENTO (ÚNICO)
            if(quantidadeElementos==1){
                this.aux = null;
                this.atual = null;
            }
            //REMOÇÃO DO PRIMEIRO ELEMENTO
            else{
                Elemento remove = this.atual;
                //Agora o atual será o anterior do Elemento a ser removido
                this.atual = atual.getAnt();
                //Atribui o próximo do Elemento anterior do removido para null, porque agora ele é o primeiro
                this.atual.setProx(null);
                //Atribui como nulo o anterior do Elemento a ser removido
                remove.setAnt(null);
            }
            this.quantidadeElementos--;
        }else{
            throw new NullPointerException("\n╳ Lista vazia ╳\n");
        }
    }

    /**
     * Retorna se a pilha está vazia ou não.
     * 
     * @return {@code true} se a lista está vazia, {@code false} em caso contrário.
     */
    public boolean empty(){
        return (this.quantidadeElementos==0);
        //return (atual==null);
    }

    /**
     * Retorna o elemento do topo da pilha.
     * 
     * @return {@code atual} Elemento
     */
    public Elemento top() throws NullPointerException{
        if(!empty())
            return this.atual;
        throw new NullPointerException("\n╳ Lista vazia ╳\n");
    }

    /**
     * Retorna o tamanho da pilha.
     * 
     * @return {@code quantidadeElementos} int
     */
    public int size(){
        return this.quantidadeElementos;
    }
}
