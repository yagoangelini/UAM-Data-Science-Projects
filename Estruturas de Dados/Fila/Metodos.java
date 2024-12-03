package Aula10.Fila;

public class Metodos {
    private Elemento inicio=null, atual, aux;
    private int quantidadeElementos=0;
    
    /**
     * Insere um elemento na fila.
     * @param info Object
     */
    public void enqueue(Object info){
        if(empty()){ //Se for o primeiro elemento a ser inserido
            //Instancia um novoElemento que tem anterior e próximo nulos e contém uma informação
            Elemento novoElemento = new Elemento(null, null, info);
            //O Elemento inicial agora é o novoElemento criado
            this.inicio = novoElemento;
            //O Elemento aux agora é o novoElemento criado
            this.aux = this.inicio;
            //O Elemento atual agora é o novoElemento criado
            this.atual = this.inicio;
        }else{
            //Instancia um novoElemento que tem o atual como anterior, próximo nulo e contém uma informação
            Elemento novoElemento = new Elemento(atual, null, info);
            this.aux = this.atual; //1º MODO DE TRATAR O AUX, está recebendo o anterior de novoElemento
            //O atual agora é o novoElemento criado
            this.atual = novoElemento;
            //O próximo do aux agora é o novoElemento
            aux.setProx(atual);
                //this.aux = atual; //2º MODO DE TRATAR O AUX, coloca o aux na mesma posição que o novoElemento
        }
        quantidadeElementos++;
    }

    /**
     * Remove um elemento da lista.
     */
    public void dequeue() throws IllegalArgumentException {
        Elemento remove = inicio;
        if(!empty()){ //Se a fila não estiver vazia
            //REMOÇÃO DO PRIMEIRO ELEMENTO DA FILA (ÚNICO)
            if(quantidadeElementos==1)
                inicio = null;
            //REMOÇÃO DO PRIMEIRO ELEMENTO DA FILA
            else{
                //Agora o inicio será o próximo do Elemento a ser removido
                inicio = remove.getProx();
                //Atribui o anterior do Elemento próximo para null, porque agora ele é o primeiro
                inicio.setAnt(null);
                //Atribui como nulo o próximo do Elemento a ser removido
                remove.setProx(null);
            }
            quantidadeElementos--;
        }else
            //Lança uma exceção
            throw new IllegalArgumentException("Lista vazia.\n");
    }

    /**
     * Retorna se a lista está vazia ou não.
     * @return true se a lista estiver vazia, false em caso contrário.
     */
    public boolean empty(){
        return (this.inicio==null);
    }

    /**
     * Retorna a quantidade de elementos na fila.
     * @return quantidadeElementos int
     */
    public int size(){
        return quantidadeElementos;
    }

    /**
     * Retorna o primeiro elemento da fila (último a ser colocado).
     * @return inicio Elemento
     */
    public Elemento front() throws IllegalArgumentException{
        if(!empty())
            return inicio;
        throw new IllegalArgumentException("Lista vazia.\n");
    }
}
