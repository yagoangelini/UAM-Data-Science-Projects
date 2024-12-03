package Aula10.Fila;

public class Elemento {
    private Elemento ant, prox; //Para guardar a referência aos Elementos anterior e próximo
    private Object info; //Armazena a informação contida no Elemento
    //Usamos a classe Object para que qualquer tipo de dado possa ser isnerido


    public Elemento(Elemento ant, Elemento prox, Object info){
        this.ant = ant;
        this.prox = prox;
        this.info = info;
    }

    public Elemento getAnt() { return ant; }

    public void setAnt(Elemento ant) { this.ant = ant; }

    public Elemento getProx() { return prox; }

    public void setProx(Elemento prox) { this.prox = prox; }

    public Object getInfo(){ return this.info; }

    public void setInfo(Object info){ this.info = info; }

    public String toString(){
        return "Elemento | Informação: " + info + "\n";
    }

}
