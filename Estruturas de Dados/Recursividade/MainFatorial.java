package Aula13.Recursividade;

public class MainFatorial {
    public static void main(String[] args) {
        System.out.println(fatRecursivo(6));

        System.out.println(fatRecursivo(5));
    }

    public static int fatRecursivo(int n){
        if(n<=1)
            return 1;
        else
            //n! = n * (n-1)!
            return n * fatRecursivo(n-1);
    }
    
    public static int fatIterativo(int n){
        int fat=1;
        for(int i=1;i<=n;i++){
          fat *= i; //fat=fat*i
        }
        return fat;
    }
}



