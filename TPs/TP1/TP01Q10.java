public class TP01Q10
{
	public static void main(String[] args) {
	    
	    boolean isfim = false;
	    do{
	    
	    String palavra = MyIO.readLine();
	    char[] vet = palavra.toCharArray();
	    int contagem = 1;
	    int tamanho = vet.length;
	    
	    if(palavra.equalsIgnoreCase("FIM")){ // Função para caso a palavra lida for igual a FIM
	        isfim = true;
	        break;
	    }
	    
	    for(int i = 0; i < tamanho; i++){
	        
	        if(vet[i] == ' '){
	            contagem++;
	        }
	    }
	     
	    MyIO.print(contagem);
	    MyIO.println(" ");
	    
	    }while(isfim != true);
		
	}
}



