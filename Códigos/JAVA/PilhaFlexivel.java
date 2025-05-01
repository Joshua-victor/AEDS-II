class Celula {
	public int elemento; // Elemento inserido na Celula.
	public Celula prox; // Aponta a Celula prox.

   //Construtor da classe.
	public Celula() {
		this(0);
	}

	// Construtor da classe, para elemento int inserido na Celula.
	public Celula(int elemento) {
      this.elemento = elemento;
      this.prox = null;
	}
}

class Pilha {
    
    private Celula topo;
    
    public Pilha(){
        
        topo = null;
    }
    
    
    //metodo para inserir elemento na pilha 
    public void inserir(int x){
        
       Celula tmp = new Celula(x); // cria uma nova "caixinha" tmp
       tmp.prox = topo; // conecta a nova celula prox  ao topo
       topo = tmp; // ponteiro topo aponta para tmp
       tmp = null; // "joga fora" a celula tmp 
        
    }
    
    
    public int remover(){
        
      if(topo == null){ // caso a pilha esteja vazia entra no if
          throw new Exception("erro"); // printa erro e encerra o programa 
      }  
        
      int removido = topo.elemento; // pega o elemento que ira ser removido 
      Celula tmp = topo; // cria um ponteiro apontando para topo
      topo = topo.prox; // topo aponta para o proximo elemento 
      tmp = tmp.prox = null; // coloca como nulo o ponteiro e a conexão 
      
      return removido; // retorna o elemento removido
     
    }
    
    
    public void mostrar(){
        
        
        System.out.print("[");
        
        for(celula i = topo; i != null; i = i.prox){ // enquanto o prox não for nulo
            
            System.out.print(i.elemento + " "); // printa o elemento
            
        }
        
        System.out.print("]");
        
    }
    
}







