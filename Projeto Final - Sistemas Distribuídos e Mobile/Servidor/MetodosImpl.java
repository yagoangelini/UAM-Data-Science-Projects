import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class MetodosImpl extends UnicastRemoteObject implements Metodos{

	ArrayList<Conta> contas = new ArrayList<>(); // Lista de contas de clientes do banco
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss"); // Formatador de data para armazenamento no comprovante

	// Todas as classes remotas (servidores) herdam UnicastRemoteObject e implementam a interface definida
	public MetodosImpl() throws RemoteException{
		// Chamando o construtor da superclasse (Metodos)
		super();
	}

	/** 
	 * Método usado para adicionar uma conta de cliente na lista
	 * @param conta
	 * @return <code>Status</code> da operação
	 * @throws RemoteException
	 */
	public Status adicionarConta(Conta conta) throws RemoteException{
		for (Conta c : contas) {
			if(c.getCpf().equals(conta.getCpf()))
				return new Status(8); // ERRO 0x00008 - CPF já está cadastrado no sistema.
		}
		
		if(contas.add(conta)) // Se deu certo adicionar a conta na lista de contas
			return new Status(0); // SUCESSO - Operação realizada com êxito.
		
		return new Status(1); // ERRO 0x00001 - Conta não adicionada.
	}

	/** 
	 * Método usado para buscar uma conta de cliente na lista
	 * @param argumentos
	 * @return <code>Conta</code> se encontrar, <code>null</code>, caso contrário
	 * @throws RemoteException
	 */
	public Conta buscarConta(ArgsBuscarExibirRemover argumentos) throws RemoteException{
		for (Conta conta : contas) {
			if(conta.getCpf().equals(argumentos.getCpf()))
				return conta;
		}
		return null;
	}
	
	
	/** 
	 * Método que imprime os dados de um cliente da lista no Processo Servidor, e retorna esses dados para serem impressos no Processo CLiente também
	 * @param argumentos
	 * @return <code>StatusAndDados</code>, que contém o Status da operação e os Dados do cliente
	 * @throws RemoteException
	 */
	public StatusAndDados exibirConta(ArgsBuscarExibirRemover argumentos) throws RemoteException{
		Conta conta = buscarConta(new ArgsBuscarExibirRemover(argumentos.getCpf()));
		
		if(conta != null){
			System.out.println("────────────────────────────────────────┤\n" + conta.toString() + "\n\n");
			return new StatusAndDados(0, conta.toString()); // SUCESSO - Operação realizada com êxito.
		}
		
		return new StatusAndDados(2, ""); // ERRO 0x00002 - Conta de origem não encontrada.
	}
	
	
	/** 
	 * Método usado para remover uma conta de cliente da lista
	 * @param argumentos
	 * @return <code>Status</code> da operação
	 * @throws RemoteException
	 */
	public Status removerConta(ArgsBuscarExibirRemover argumentos) throws RemoteException{
		Conta conta = buscarConta(new ArgsBuscarExibirRemover(argumentos.getCpf()));

		if(conta != null){
			contas.remove(conta);
			return new Status(0); // SUCESSO - Operação realizada com êxito.
		}

		return new Status(2); // ERRO 0x00002 - Conta de origem não encontrada.
	}

	
	/** 
	 * Método usado para transferência de valores entre contas de clientes
	 * @param argumentos
	 * @return <code>Status</code> da operação
	 * @throws RemoteException
	 */
	public Status transferir(ArgsTransferir argumentos) throws RemoteException{
		if(argumentos.getValor() > 0){
			Conta conta_origem = buscarConta(new ArgsBuscarExibirRemover(argumentos.getCpf_conta_origem()));
			Conta conta_destino = buscarConta(new ArgsBuscarExibirRemover(argumentos.getCpf_conta_destino()));

			if(conta_origem == null)
				return new Status(2); // ERRO 0x00002 - Conta de origem não encontrada.
			else if(conta_destino == null)
				return new Status(4); // ERRO 0x00004 - Conta de destino não encontrada.
			else if(conta_origem == conta_destino)
				return new Status(7); // ERRO 0x00007 - A conta de origem e a de destino devem ser diferentes.

			//ATUALIZANDO SALDO ORIGEM
			if((conta_origem.getSaldo() - argumentos.getValor()) >= (0 - conta_origem.getLimite())){
				conta_origem.setSaldo(conta_origem.getSaldo() - argumentos.getValor());
				Comprovante comprovante = new Comprovante("TRANSFERÊNCIA", dtf.format(LocalDateTime.now()), argumentos.getValor() * (-1), argumentos.getCpf_conta_destino());
				conta_origem.getComprovantes().add(comprovante);
			}else
				return new Status(3); // ERRO 0x00003 - Saldo atual da conta de origem insuficiente.

			//ATUALIZANDO SALDO DESTINO
			conta_destino.setSaldo(conta_destino.getSaldo() + argumentos.getValor());
			Comprovante comprovante = new Comprovante("TRANSFERÊNCIA", dtf.format(LocalDateTime.now()), argumentos.getValor(), argumentos.getCpf_conta_origem());
			conta_destino.getComprovantes().add(comprovante);
			return new Status(0); // SUCESSO - Operação realizada com êxito.
		}
		return new Status(5); // ERRO 0x00005 - Informe um valor maior que 0.
	}

	
	/** 
	 * Método usado para sacar dinheiro de uma conta de cliente
	 * @param argumentos
	 * @return <code>Status</code> da operação
	 * @throws RemoteException
	 */
	public Status sacar(ArgsSacarDepositar argumentos) throws RemoteException{
		if(argumentos.getValor() > 0){
			Conta conta = buscarConta(new ArgsBuscarExibirRemover(argumentos.getCpf()));

			if(conta != null){
				if((conta.getSaldo() - argumentos.getValor()) >= (0 - conta.getLimite())){
					conta.setSaldo(conta.getSaldo() - argumentos.getValor());
					Comprovante comprovante = new Comprovante("SAQUE", dtf.format(LocalDateTime.now()), argumentos.getValor() * (-1));
					conta.getComprovantes().add(comprovante);
					return new Status(0); // SUCESSO - Operação realizada com êxito.
				}
				return new Status(3); // ERRO 0x00003 - Saldo atual da conta de origem insuficiente.
			}

			return new Status(2); // ERRO 0x00002 - Conta de origem não encontrada.
		}
		return new Status(5); // ERRO 0x00005 - Informe um valor maior que 0.
	}

	
	/** 
	 * Método usado para depositar dinheiro em uma conta de cliente
	 * @param argumentos
	 * @return <code>Status</code> da operação
	 * @throws RemoteException
	 */
	public Status depositar(ArgsSacarDepositar argumentos) throws RemoteException{
		if(argumentos.getValor() > 0){
			Conta conta = buscarConta(new ArgsBuscarExibirRemover(argumentos.getCpf()));

			if(conta != null){
				conta.setSaldo(conta.getSaldo() + argumentos.getValor());
				Comprovante comprovante = new Comprovante("DEPÓSITO", dtf.format(LocalDateTime.now()), argumentos.getValor());
				conta.getComprovantes().add(comprovante);
				return new Status(0); // SUCESSO - Operação realizada com êxito.
			}

			return new Status(2); // ERRO 0x00002 - Conta de origem não encontrada.
		}
		return new Status(5); // ERRO 0x00005 - Informe um valor maior que 0.
	}

	
	/** 
	 * Método usado para encerrar o processo Servidor
	 * @throws RemoteException
	 * @throws MalformedURLException
	 * @throws NotBoundException
	 */
	public void stopServer() throws RemoteException, MalformedURLException, NotBoundException{
		System.out.println("Tudo bem, Tchau!\n");
		Naming.unbind("rmi://localhost:1099/Metodos"); // Remove do Binder a instância criada do objeto
		System.exit(0); //Encerra o processo Servidor
	}
}