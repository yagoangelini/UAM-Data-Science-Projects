public class DynamicQueue {
    private Client first;
    private Client last;
    private int queue_occupancy;
    private int max_size;

    /**
     * Inicializa a fila com nenhum elemento e tamanho máximo definido por parâmetro.
     */
    public DynamicQueue(int max_size){
        this.last = null;
        this.first = null;
        this.queue_occupancy = 0;
        this.max_size = max_size;
    }

    /**
     * Insere elementos na fila.
     * @param client Client
     * @return true se sucesso, false caso contrário.
     */
    public boolean enqueue(Client client){
        if((queue_occupancy + 1) > max_size) //Se for estourar o tamanho da fila
            return false;

        if(queue_occupancy == 0){
            this.last = client;
            this.first = last;
        }
        else{
            this.last.setProx(client);
            this.last = client;
        }
        this.queue_occupancy++;
        return true;
    }

    /**
     * Remove elementos da fila (sempre remove o primeiro elemento da fila).
     * @return true se sucesso, false caso contrário.
     */
    public boolean dequeue(){
        Client proximo = first.getProx();

        this.first.setProx(null);
        this.first = proximo;
        this.queue_occupancy--;
        return true;
    }

    /**
     * Retorna o primeiro elemento da fila.
     */
    public Client peek(){
        return this.first;
    }

    /**
     * Retorna a ocupação atual da fila.
     */
    public int getOccupancy(){
        return this.queue_occupancy;
    }

    /**
     * Retorna string contendo os integrantes da fila.
     */
    public String data(){
        Client client = this.first;
        String string = "";

        while(client != null){
            string += client.getName() + ":" + client.getAge();
            client = client.getProx();
            
            if(client != null)
                string += "-";
        }

        return (string.equals(""))? "vazia" : string;
    }
}
