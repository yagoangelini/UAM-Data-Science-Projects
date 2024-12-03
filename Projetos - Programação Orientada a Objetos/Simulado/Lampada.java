package Simulado;

public class Lampada {
    private boolean estado;
    private int pot;
    private int contMudancas=0;
    
    public Lampada(int pot){
        this.pot = pot;
        estado = false;
    }

    public boolean getEstado(){
        if(contMudancas >= pot/10)
            return false;
        return estado;
    }

    public void setEstado(boolean estado){
        if(this.estado != estado){
            this.estado = estado;
            contMudancas++;
        }
    }
}
