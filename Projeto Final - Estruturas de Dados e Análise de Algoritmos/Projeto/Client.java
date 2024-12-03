public class Client{ //Classe que representa cada elelemento da fila
  //Dados
  private String name;
  private int age;
  //Referência ao proximo Elemento
  private Client prox;

  public Client(String name, int age){
    this.name = name;
    this.age = age;
    this.prox = null;
  }

  public String getName(){
    return this.name;
  }

  public int getAge(){
    return this.age;
  }

  public boolean isElderly(){
    return (age>=60);
  }

  public Client getProx(){
    return this.prox;
  }

  public void setProx(Client prox){
    this.prox = prox;
  }

  @Override
  public String toString(){
    return "\nNome: " + this.name +
           "\nIdade: " + this.age + "\n";
  }
}