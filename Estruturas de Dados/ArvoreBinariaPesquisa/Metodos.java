package Aula13.ArvoreBinariaPesquisa;

public class Metodos {
    private No raiz=null, atual;

    public No getRaiz(){
        return this.raiz;
    }

    public void inserir(int valor){
        No novoNo = new No(null, null, valor);
        if(this.raiz==null){//Se não houver nenhum elemento, adiciona a raiz
            this.raiz = novoNo;
            this.atual = raiz;
        }else{
            this.atual = raiz; //Como o atual se desloca a cada inserção ele precisa ser resetado.
            while(true){ //não sabemos quantas comparações, por isso loop infinito
                if(novoNo.getValor()>=atual.getValor()){ //Se o valor do novoNo for maior, vamos adicionar à direita
                    if(atual.getDireita() == null){ //Se a posição à direita na árvore estiver vazia
                        atual.setDireita(novoNo); //Agora o novoNo será posicionado à direita de atual
                        break; //Sai do while
                    }
                    //else
                    atual = atual.getDireita(); //Pega o valor a direita do atual (desce na árvore)
                }else{
                    if(atual.getEsquerda() == null){ //Se a posição à esquerda na árvore estiver vazia
                        atual.setEsquerda(novoNo); //Agora o novoNo será posicionado à esquerda de atual
                        break; //Sai do while
                    }
                    //else
                    atual = atual.getEsquerda(); //Pega o valor a esquerda do atual (desce na árvore)
                }
            }
        }
    }

    public void PercursoOrdem(No no){ //Ele é chamado enviando a raiz como parâmetro
        if(no != null){ //Se o no não for nulo
            PercursoOrdem(no.getEsquerda());//Percore a subárvore da esquerda
            System.out.print(no.getValor() + " ");//Imprime o valor do nó e visita a raiz na hora certa
            PercursoOrdem(no.getDireita());//Percore a subárvore da direita
        }
    }

    public void PercursoPreOrdem(No no){
        if(no != null){
            System.out.print(no.getValor() + " ");//Imprime o valor do nó e visita a raiz na hora certa
            PercursoPreOrdem(no.getEsquerda());//Percore a subárvore da esquerda
            PercursoPreOrdem(no.getDireita());//Percore a subárvore da direita
        }
    }

    public void PercursoPosOrdem(No no){
        if(no != null){     
            PercursoPosOrdem(no.getEsquerda());//Percore a subárvore da esquerda
            PercursoPosOrdem(no.getDireita());//Percore a subárvore da direita
            System.out.print(no.getValor() + " ");//Imprime o valor do nó e visita a raiz na hora certa
        }
    }

    public boolean buscar(int valor){
        No no = this.raiz;

        while(no!=null){
            if(valor == no.getValor())//Se o valor for encontrado, retorna true
                return true;
            else if(valor>=no.getValor())//Se o valor buscado for maior ou igual que o valor atual
                no = no.getDireita();//o nó recebe o nó da direita
            else
                no = no.getEsquerda();//o nó recebe o nó da esquerda
        }
        return false;
    }
}
