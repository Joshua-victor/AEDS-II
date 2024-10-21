import java.io.*;
import java.nio.charset.*;

public class Main
{
	public static void main(String[] args) {

        boolean repetir = true;

        do{
		String palavra;
		String vogaisResposta;
		 String consoanteResposta;
		 String inteiroResposta;
		 String realResposta = "NAO";
		palavra = MyIO.readLine();
		char[] vet = palavra.toCharArray();
		int tamanho = vet.length;
		boolean vogais = true, consoante = true, inteiro = true, real = false;
		
		
		if (tamanho >= 3 && palavra.equalsIgnoreCase("FIM")) {
				repetir = false;
				break;
			}
        

		for(int i = 0; i < tamanho; i++) {

			if(vet[i] != 'a' && vet[i] != 'A' && vet[i] != 'e' && vet[i] != 'E' &&  vet[i] != 'i' && vet[i] != 'I' && vet[i] != 'o' && vet[i] != 'O' &&vet[i] != 'u' && vet[i] != 'U') {

				vogais = false;
			} else{
			    consoante = false;
			}

            if (!Character.isDigit(vet[i])){
                inteiro = false;
            }
        
           
        
}


             if(vogais){
                 vogaisResposta = "SIM";
            }else{
                vogaisResposta = "NAO";
            }
            
            if(consoante){
                 consoanteResposta = "SIM";
            }else{
                consoanteResposta = "NAO";
            }
            
            if(inteiro){
               inteiroResposta = "SIM";
            }else{
                inteiroResposta = "NAO";
            }
        

         System.out.printf("%s %s %s %s%n", vogaisResposta, consoanteResposta, inteiroResposta, realResposta);


		}while(repetir);

		}
        


	}