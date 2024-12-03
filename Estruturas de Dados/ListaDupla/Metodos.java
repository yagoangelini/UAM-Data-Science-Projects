package Aula09.ListaDupla;

public class Metodos {
    private Elemento inicio=null, atual, aux;
    private int quantidadeElementos=0;
    
    /**
     * Insere um novo Elemento na lista.
     * Possui diferentes instruções para a inserção do primeiro Elemento.
     * 
     * @param info Object
     */
    public void inserirElemento(Object info){
        if(this.inicio==null){ //Se for o primeiro elemento a ser inserido
            //Instancia um novoElemento que tem anterior e próximo nulos e contém uma informação
            Elemento novoElemento = new Elemento(null, null, info);
            //O Elemento inicial agora é o novoElemento criado
            this.inicio = novoElemento;
            //O Elemento aux agora é o novoElemento criado
            this.aux = this.inicio;
            //O Elemento atual agora é o novoElemento criado
            this.atual = this.inicio;
            quantidadeElementos++;
        }else{
            //Instancia um novoElemento que tem o atual como anterior, próximo nulo e contém uma informação
            Elemento novoElemento = new Elemento(atual, null, info);
            this.aux = this.atual; //1º MODO DE TRATAR O AUX, está recebendo o anterior de novoElemento
            //O atual agora é o novoElemento criado
            this.atual = novoElemento;
            //O próximo do aux agora é o novoElemento
            aux.setProx(atual);
                //this.aux = atual; //2º MODO DE TRATAR O AUX, coloca o aux na mesma posição que o novoElemento
            quantidadeElementos++;
        }
    }

    /**
     * Exibe um relatório detalhado da lista do início para o final.
     */
    public void exibirDoInicio(){
        Elemento exibe = inicio;
        //Enquanto não chegar no Elemento depois do último da lista
        while(exibe!=null){
            System.out.println(exibe.getInfo()); //Imprime a informação contida no Elemento
            exibe = exibe.getProx(); //Exibe pega o próximo Elemento
        }
    }

    /**
     * Exibe um relatório detalhado da lista do fim para o início.
     */
    public void exibirDoFinal(){
        Elemento exibe = atual;
        //Enquanto não chegar no anterior do primeiro Elemento da lista
        while(exibe!=null){
            System.out.println(exibe.getInfo()); //Imprime a informação contida no Elemento
            exibe = exibe.getAnt(); //Exibe pega o Elemento anterior
        }
    }

    /**
     * Pesquisa um Elemento na lista e retorna ele por info.
     * 
     * @param info Object
     * 
     * @return Elemento se encontrar, null em caso contrário.
     */
    public Elemento pesquisar(Object info){
        Elemento pesq = inicio;
        //Enquanto não chegar no Elemento depois do último da lista
        while(pesq!=null){
            if(pesq.getInfo()==info) //Se a informação contida no Elemento for igual à passada por parâmetro
                return pesq; //Retorna o pesq
            pesq = pesq.getProx(); //Pesq pega o próximo Elemento
        }
        return null; //Caso não encontre retorna null
    }

    /**
     * Remove por info um funcionário da Lista com a ajuda do método pesquisar(Object info).
     * Possui instruções diferentes se:
     * 1) Houver somente 1 funcionário na lista
     * 2) Se o Funcionário a ser removido for o primeiro
     * 3) Se o Funcionário a ser removido for o último
     * 4) Se o funcionário a ser removido estiver em uma outra posição qualquer
     * 
     * Após a remoção, a quantidade de Elementos é decrementada.
     * 
     * @param info Object
     * 
     * @return true se a remoção for bem sucedida, false em caso contrário.
     */
    public boolean removerElemento(Object info){
        Elemento remove = pesquisar(info);
        if(remove!=null){ //Se a pesquisa não retornar null
            //REMOÇÃO DO PRIMEIRO ELEMENTO (ÚNICO)
            if(quantidadeElementos==1){
                inicio = null;
                aux = null;
                atual = null;
            }
            //REMOÇÃO DO PRIMEIRO ELEMENTO
            else if(remove == inicio){
                //Agora o inicio será o próximo do Elemento a ser removido
                inicio = remove.getProx();
                //Atribui o anterior do Elemento próximo para null, porque agora ele é o primeiro
                inicio.setAnt(null);
                //Atribui como nulo o próximo do Elemento a ser removido
                remove.setProx(null);
            }
            //REMOÇÃO DO ÚLTIMO ELEMENTO
            else if(remove == atual){
                //Agora o atual será o anterior do Elemento a ser removido
                atual = remove.getAnt();
                //Atribui o próximo do Elemento anterior para null, porque agora ele é o último
                atual.setProx(null);
                //Atribui como nulo o anterior do Elemento a ser removido
                remove.setAnt(null);
            }
            //REMOÇÃO DE UM ELEMENTO EM POSIÇÃO QUALUQER
            else{
                //Atribui o próximo do Elemento anterior para o próximo do Elemento a ser removido
                remove.getAnt().setProx(remove.getProx());
                //Atribui o anterior do próximo Elemento para o Elemento anterior do que será ser removido
                remove.getProx().setAnt(remove.getAnt());
                //Atribui como nulo o próximo do Elemento a ser removido
                remove.setProx(null);
                //Atribui como nulo o anterior do Elemento a ser removido
                remove.setAnt(null);
            }
            quantidadeElementos--;
            return true;
        }
        return false;
    }
}
