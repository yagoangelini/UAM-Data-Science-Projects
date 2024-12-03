package Aula08.LinkedList;

public class Elemento {
    private Object objeto;
    //Usando a classe Object, a superclasse do Java, podemos colocar
    //qualquer tipo de dado dentro dessa variável
    private Elemento ant;
    
    public Elemento(){
        
    }

    public Elemento(Object objeto, Elemento ant) {
        this.objeto = objeto;
        this.ant = ant;
    }

    public Object getObjeto() {
        return objeto;
    }

    public void setObjeto(Object objeto) {
        this.objeto = objeto;
    }

    public Elemento getAnt() {
        return ant;
    }

    public void setAnt(Elemento ant) {
        this.ant = ant;
    }
}
