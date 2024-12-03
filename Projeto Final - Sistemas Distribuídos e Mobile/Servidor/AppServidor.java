import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class AppServidor {

    public static void main(String[] args) throws RemoteException, MalformedURLException {
        Metodos metodos = new MetodosImpl(); // Objeto remoto

        LocateRegistry.createRegistry(1099); // Põe o binder no ar
        
        // Cria uma instancia do objeto e registra no Binder
        Naming.rebind("rmi://localhost:1099/Metodos", metodos);
    }
}