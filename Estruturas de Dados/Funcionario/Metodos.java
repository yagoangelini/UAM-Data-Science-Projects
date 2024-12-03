package Aula06.Funcionario;

//import java.util.Arrays;

public class Metodos {
    
    private static int quantidade = 0, i = 0;
    private static Funcionario[] lista = new Funcionario[2];

  /**
   * Inserir dados do tipo Funcionario no array.
   *
   * @param lista Funcionario
   */

  public static void inserir(Funcionario f) {
      lista = alocarNovoArray(lista);
      System.out.println("Tamanho: " + lista.length);
      //lista = Arrays.copyOf(lista, quantidade+2);
      lista[i] = new Funcionario();//Objetos
      lista[i].setNome(f.getNome());
      lista[i].setSalario(f.getSalario());
      lista[i].setMatricula(i + 1);
      i++;
      quantidade++;
  }
/*
  public static void inserir(Funcionario[] lista) {
    Scanner teclado = new Scanner(System.in);
    for (i = 0; i < lista.length; i++) {
      lista[i] = new Funcionario();//Objetos
      System.out.print("Nome: ");
      lista[i].setNome(teclado.nextLine());
      System.out.print("Salário: ");
      lista[i].setSalario(teclado.nextDouble());
      lista[i].setMatricula((i + 1));
      teclado.nextLine();//Limpa o buffer
      quantidade++;
    }
    teclado.close();
  }
*/
  /**
   * Pesquisar sequencialmente a matrícula do array.
   * @param matricula int
   * @return Funcionario
   */

  public static Funcionario pesquisarMatricula(int matricula) {
    for (i = 0; i < lista.length; i++) {
      if(matricula==lista[i].getMatricula())
        return lista[i];
    }
    return null;
  }

  /**
   * Imprimir um relatório de todos os funcionários.
   */
  public static void exibir(){
    for(i=0; i<quantidade; i++){
      System.out.println("\n" + lista[i].getMatricula());
      System.out.println(lista[i].getNome());
      System.out.println(lista[i].getSalario() + "\n");
    }
    /*
    for(Funcionario funcionario:lista){
      System.out.println(funcionario);
    }
    */

    /*
    System.out.println(Arrays.toString(lista));
    */
  }

  /**
   * Remove, por matrícula, um funcionario da lista.
   * @param matricula int
   */
  public static void removerFuncionario(int matricula){
    Funcionario funcionario = pesquisarMatricula(matricula);
    if(funcionario!=null){
      for(i=matricula; i<lista.length; i++){
        lista[i-1] = lista[i];
      }
      quantidade--;
      lista[i-1] = null;
    }else{
      System.out.println("Funcionário não encontrado!");
    }
  }

  /**
   * Faz a alocação de um novo array se o array atual necessitar de maior tamanho.
   * @param lista Funcionario[]
   * @return
   */

  public static Funcionario[] alocarNovoArray(Funcionario[] lista){
    Funcionario[] lista2; //Referência ao array do tipo Funcionario
    if(quantidade >= lista.length){
      lista2 = new Funcionario[quantidade+2];
      //Copiar os dados
      for(int i=0; i<lista.length; i++){
        lista2[i] = lista[i];
      }
      //System.arraycopy(lista, 0, lista2, 0, lista.length);
      return lista2;
    }
    return lista;
  }
}

