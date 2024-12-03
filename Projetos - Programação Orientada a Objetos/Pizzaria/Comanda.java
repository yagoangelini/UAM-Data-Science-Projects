package Projeto.Pizzaria;

import java.util.ArrayList;

public class Comanda{
    private ArrayList<Sabores> comanda = new ArrayList<>();

    public void adicionar(Sabores sabor){
        comanda.add(sabor);
    }

    // public void adicionarMetade(Sabores sabor1, Sabores sabor2){
    //     Sabores temp = valorDaMaior(sabor1, sabor2);
    //     comanda.add(
    //         new Sabores(
    //             temp.getId(),
    //             sabor1.getNome() + " + " + sabor2.getNome(),
    //             temp.getPreco()
    //         )
    //     );
    // }

    public Sabores valorDaMaior(Sabores sabor1, Sabores sabor2){
        if(sabor1.getPreco() > sabor2.getPreco())
            return sabor1;
        else
            return sabor2;
    }
}
