package Projeto.Pizzaria;

import java.util.Scanner;

public class RespostaPedido extends Resposta{
	int qtd, cont;
	float total;
	Scanner sc = new Scanner(System.in);
	Cardapio cardapio;
	Comanda comanda;
	Sabores temp01, temp02;
	//String resp;
  
	public RespostaPedido(String keyWord, Comanda comanda, Cardapio cardapio){
    	super(keyWord);
		this.cardapio = cardapio;
		this.comanda = comanda;
    }

	public boolean verifica(String entrada){
		return entrada.contains(keyWord);
	}

    public String produz(){
		System.out.println("\nPIZZAIOLO - Pois sim. Gostaria de quantas pizzas?\n");
		System.out.print("> ");
		qtd = sc.nextInt();
		sc.nextLine();
		for(int i=0; i<qtd; i++){
			do{
				cont=0;
				System.out.println("\nA " + i+1 + "ª pizza será Inteira de 1 sabor ou Meio a Meio?\n");
				System.out.print("> ");
				if(sc.nextLine().contains("inteira") == true){
					do{
						System.out.println("\nPIZZAIOLO - Qual o sabor da pizza?\n");
						System.out.print("> ");
						temp01 = cardapio.pesquisar(sc.nextLine());
						if(temp01 != null)
							comanda.adicionar(temp01);
						else
							System.out.println("\nNão temos esse sabor, tente novamente.\n");
					}while(temp01 == null);
				}else if(sc.nextLine().contains("meio")){
					do{
						System.out.println("\nPIZZAIOLO - Qual o sabor da primeira metade?\n");
						System.out.print("> ");
						temp01 = cardapio.pesquisar(sc.nextLine());
						if(temp01 != null)
							do{
								System.out.println("\nPIZZAIOLO - Qual o sabor da segunda metade?\n");
								System.out.print("> ");
								temp02 = cardapio.pesquisar(sc.nextLine());
								// if(temp02 != null)
								// 	comanda.adicionarMetade(temp01, temp02);
								// else
								// 	System.out.println("\nNão temos esse sabor, tente novamente.\n");
							}while(temp02 != null);
						else
							System.out.println("\nNão temos esse sabor, tente novamente.\n");
					}while(temp01 == null);
				}else{
					System.out.println("\nDesculpe, não entendi.\n");
					cont++;
				}
			}while(cont>0);
		}
		return "";
	}
}
