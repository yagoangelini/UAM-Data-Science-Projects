package APS.ContaDeBanco;

import java.util.ArrayList;

public class GerenciarConta {
    private ArrayList<Conta> contas = new ArrayList<>();

    public ArrayList<Conta> getContas(){
        return contas;
    }

    /**
     * Adiciona uma conta na lista de contas do banco.
     * @param c Conta
     */
    public void adicionarConta(Conta c){
        contas.add(c);
    }

    /**
     * Remove uma conta da lista de contas do banco.
     * @param numeroConta
     * @return true se conseguir remover, false em caso contrário.
     */
    public boolean removerConta(int numeroConta){
        for(int i=0; i<contas.size();i++){
            if((contas.get(i).getNumConta()) == numeroConta){
                contas.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Busca todas as contas especiais, guardando os dados dessas contas em uma String
     * e então retorna o resultado da busca.
     * @return contasEspeciais String
     */
    public String buscarContasEspeciais(){
        String contasEspeciais = "";

        for(int i=0; i<contas.size(); i++){
            if(contas.get(i) instanceof ContaEspecial){
                contasEspeciais += contas.get(i).toString() + "\n";
            }
        }
        if(contasEspeciais.equals(""))
            contasEspeciais = "Nenhuma Conta Especial encontrada.\n";
        return contasEspeciais;
    }

    /**
     * Busca todos os clientes de conta corrente que estejam utilizando o limite,
     * Guarda os dados dessas contas em uma String, e então retorna o resultado da busca.
     * @return clientesUsandoLimite String
     */
    public String buscarClientesUsandoLimite(){
        String clientesUsandoLimite = "";

        for(int i=0; i<contas.size(); i++){
            if(contas.get(i) instanceof ContaCorrente){
                ContaCorrente c = (ContaCorrente) contas.get(i);
                if(c.usandoLimite())
                    clientesUsandoLimite += contas.get(i).toString() + "\n";
            }
        }
        if(clientesUsandoLimite.equals(""))
            clientesUsandoLimite = "Nenhum Cliente Usando Limite no momento.\n";
        return clientesUsandoLimite;
    }

    /**
     * Busca uma conta pelo seu número, e a retorna se encontrar.
     * Caso a conta não exista, deve retornar null.
     * @param numeroConta int
     * @return A conta se encontrar, null em caso contrário.
     */
    public Conta buscarConta(int numeroConta){
        for(int i=0; i<contas.size(); i++){
            if(contas.get(i).getNumConta() == numeroConta)
                return contas.get(i);
        }
        return null;
    }

    /**
     * Deve buscar contaFonte e contaDestino,
     * Se encontrá-las, saca de contaFonte e deposita em contaDestino.
     * @param numeroContaFonte int
     * @param numeroContaDestino int
     * @param valor double
     * @return true se conseguir transferir, false em caso contrário.
     */
    public boolean transferirValor(int numeroContaFonte, int numeroContaDestino, double valor){
        Conta fonte = buscarConta(numeroContaFonte);
        Conta destino = buscarConta(numeroContaDestino);
        if(fonte != null && destino != null){
            if(fonte.sacar(valor) && destino.depositar(valor))
                return true;
        }
        //System.out.println("A conta fonte não possui saldo suficiente para fazer a transferência.\n");
        //ou
        //System.out.println("Informe um valor positivo para depósito.\n");
        return false;
    }

    /**
     * Encontra a conta passada por parâmetro na lista,
     * Se encontrar, efetua o saque do valor passado por parâmetro, se possível.
     * @param numeroConta int
     * @param valorSacado double
     * @return true se conseguir sacar, false em caso contrário.
     */
    public boolean sacar(int numeroConta, double valorSacado){
        for(int i=0; i<contas.size(); i++){
            if(contas.get(i).getNumConta() == numeroConta){
                if(contas.get(i).sacar(valorSacado))
                    return true;
            }
        }
        return false;
    }

    /**
     * Encontra a conta passada por parâmetro na lista,
     * Se encontrar, efetua o depósito do valor passado por parâmetro, se possível.
     * @param numeroConta int
     * @param valorDepositado double
     * @return true se conseguir depositar, false em caso contrário.
     */
    public boolean depositar(int numeroConta, double valorDepositado){
        for(int i=0; i<contas.size(); i++){
            if(contas.get(i).getNumConta() == numeroConta){
                if(contas.get(i).depositar(valorDepositado))
                    return true;
            }
        }
        return false;
    }

    /**
     * Retorna uma String com os dados de todas as contas.
     * @return dados String
     */
    public String listarContas(){
        String dados = "";
        for(int i=0; i<contas.size(); i++){
            dados += contas.get(i).toString() + "\n";
        }
        if(dados.equals(""))
            dados = "Nenhuma Conta encontrada.\n";
        return dados;
    }
}
