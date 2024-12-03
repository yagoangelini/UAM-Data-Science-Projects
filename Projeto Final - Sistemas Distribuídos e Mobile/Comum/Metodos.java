import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.Remote; // importa pacotes do RMI
import java.rmi.RemoteException;

public interface Metodos extends Remote // Necessita herdar Remote para obter invocação remota
{
	public Status adicionarConta(Conta conta) throws RemoteException;
	public Conta buscarConta(ArgsBuscarExibirRemover argumentos) throws RemoteException;
	public StatusAndDados exibirConta(ArgsBuscarExibirRemover argumentos) throws RemoteException;
	public Status removerConta(ArgsBuscarExibirRemover argumentos) throws RemoteException;
	public Status transferir(ArgsTransferir argumentos) throws RemoteException;
	public Status sacar(ArgsSacarDepositar argumentos) throws RemoteException;
	public Status depositar(ArgsSacarDepositar argumentos) throws RemoteException;
	public void stopServer() throws RemoteException, MalformedURLException, NotBoundException;
}
