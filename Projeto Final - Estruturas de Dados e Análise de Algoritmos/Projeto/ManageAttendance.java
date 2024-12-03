public class ManageAttendance{
  DynamicQueue normal_queue, elderly_queue;
  int count = 0; //conta a quantidade de atendimentos de idosos

  Client next = null; //Armazena qual é o próximo cliente

  /*
   * Inicia novas instâncias de filas com o tamanho máximo definido por parâmetro.
   */
  public ManageAttendance(int size){
    this.normal_queue = new DynamicQueue(size);
    this.elderly_queue = new DynamicQueue(size);
  }

  /*
   * Retorna true quando não há clientes para atendimento, false em caso contrário.
   */
  public boolean isEmpty(){
    return (numClients() + numElderlyClients() == 0)? true : false;
  }

  /*
   * Retorna o número de clientes normais aguardando atendimento.
   */
  public int numClients(){
    return normal_queue.getOccupancy();
  }

  /*
   * Retorna o número de clientes idosos aguardando atendimento.
   */
  public int numElderlyClients(){
    return elderly_queue.getOccupancy();
  }

  /*
   * Insere um novo cliente na fila de atendimento.
   */
  public void addClient(Client cli){
    //Se o nome dele não possuir pelo menos 5 caracteres não brancos
    if( !((cli.getName().length() >= 5) && (!cli.getName().contains(" "))) ){
      System.out.println("\n\nERRO - O nome deve ter no mínimo 5 caracteres não brancos.\n");
      return;
    }
    //Se a idade dele não for de pelo menos 16 anos
    if(!(cli.getAge() >= 16)){
      System.out.println("\n\nERRO - A idade mínima é de 16 anos.\n");
      return;
    }
    
    //Se for idoso , adiciona o cliente na fila de idosos
    if(cli.isElderly()){
      if(!elderly_queue.enqueue(cli))
        System.out.println("\n\nERRO - A fila está cheia.\n");
    }
    else{
      if(!normal_queue.enqueue(cli))
        System.out.println("\n\nERRO - A fila está cheia.\n");
    }
  }

  /*
   * A cada dois atendimentos de idosos, um não idoso poderá ser atendido.
   * No momento que um idoso deveria ser chamado, caso não tenha idoso,
   * um não-idoso deverá ser chamado, e vice-versa.
   * Retorna o próximo cliente a ser atendido, mas NÃO remove o cliente.
   */
  public Client showNext(){
    calculateNext();
    return next;
  }

  /*
   * Retorna o próximo cliente para ser atendido e remove da fila.
   */
  public Client getNext(){
    Client next_aux = null;

    calculateNext();
    
    //Verificação para saber se existe mesmo próximo
    if(next != null){
      //O next_aux armazena o nome e a idade do próximo da fila temporariamente
      next_aux = new Client(next.getName(), next.getAge());
      
      //Se o próximo for idoso, remover o primeiro elemento da fila dos idosos
      if(next.isElderly())
        elderly_queue.dequeue();
      else
        normal_queue.dequeue();
    }
    
    //O próximo agora é nulo
    next = null;
    return next_aux;
  }

  /**
   * Calcula quem é o próximo da fila e atribui à variável next
   */
  public void calculateNext(){
    //Se ainda não se sabe quem é o próximo da fila
    if(next == null){
      //Se a fila não estiver vazia
      if(!isEmpty()){
        count %= 3; //Quando o contador chega a 3, ele volta a 0
        
        //TESTE DE MESA da Primeira entrada
        //Contador inicializa com -1, mas ao incrementar, vai pra 0
        //Os idosos serão atendidos quando o contador for: 0,1
        //Quando o contador for 2, o não-idoso será atendido
        //Quando o contador for 3, ele é resetado para 0 novamente
        
        //Se houverem idosos na fila e o contador for 0 ou 1
        if(numElderlyClients() > 0 && count < 2)
        next = elderly_queue.peek();
        else{
          next = normal_queue.peek();
          //Se não for a vez dos idosos, mas não houverem clientes normais na fila, atender os idosos
          if(!(numClients() > 0))
          next = elderly_queue.peek();
        }
        count++; //A cada atendimento de idoso, o contador é incrementado
      }
    }
  }

  /*
   * Retorna uma string contendo os nomes de todos os clientes que estão
aguardando atendimento.
   */
  public String showQueues(){
    return "idoso: " + elderly_queue.data() + "; normal: " + normal_queue.data();
  }
}