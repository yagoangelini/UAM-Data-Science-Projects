package Aula06.Funcionario;

import java.util.Scanner;

public class Main{
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String nome;
    double salario;
    char resp;

    do{
      System.out.print("Nome: ");
      nome = sc.nextLine();
      System.out.print("Salário: R$");
      salario = sc.nextDouble();
      sc.nextLine();

      Funcionario f = new Funcionario(nome, salario);
      Metodos.inserir(f);

      System.out.println("Deseja cadastrar mais um funcionário (S ou N)?  ");
      resp = sc.nextLine().charAt(0);

    }while(resp == 'S' || resp == 's');

    
    Funcionario funcionario = Metodos.pesquisarMatricula(1);
    if(funcionario!=null)
      System.out.println(funcionario);
    else
      System.out.println("Funcionário não encontrado!");
    
    System.out.println("----------ANTES DA REMOÇÃO----------");
    Metodos.exibir();

    Metodos.removerFuncionario(1);
    System.out.println("----------DEPOIS DA REMOÇÃO----------");
    Metodos.exibir();

    sc.close();

  }
}
