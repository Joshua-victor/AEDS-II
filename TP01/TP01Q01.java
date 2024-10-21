import java.util.Scanner;



public class Main
{
	public static void main(String[] args) {
	    Scanner Scanner = new Scanner(System.in);
		
		String palindromo;
		do{
		
		boolean resposta = true;
		palindromo =  Scanner.nextLine();
		int tamanho = palindromo.length();
		   if (tamanho >= 3 && palindromo.equalsIgnoreCase("FIM")) {
                break;
            }
		
		palindromo = palindromo.toUpperCase();
		char[] palindromoVet = palindromo.toCharArray();
	
		
		for(int i = 0; i < tamanho/2; i++){
		    
		  if (palindromoVet[i] != palindromoVet[tamanho - 1 - i]){  
		    resposta = false;
		    break;
		    
		}
		}
		
		if( resposta == true){
		    System.out.println("SIM");
		}else{
		    System.out.println("NAO");
		}
		
		}while(true );
		
	}
}
