package Aula06.Funcionario;

public class Funcionario {

    private String nome;
    private double salario;
    private int matricula;
  
    @Override
    public String toString() {
      return "Funcionario [matricula=" + matricula + ", nome=" + nome + ", salario=" + salario + "]";
    }

    public String getNome() {
      return nome;
    }

    public void setNome(String nome) {
      this.nome = nome;
    }

    public double getSalario() {
      return salario;
    }

    public void setSalario(double salario) {
      this.salario = salario;
    }

    public int getMatricula() {
      return matricula;
    }

    public void setMatricula(int matricula) {
      this.matricula = matricula;
    }

    public Funcionario() {
    }

    public Funcionario(String nome, double salario) {
      this.nome = nome;
      this.salario = salario;
    }
}


