import java.io.*;
import java.nio.charset.*;

public class CiframentoCesar
{
	public static void main(String[] args) {
	    
		MyIO.setCharset("UTF-8");
		String palavra;
		boolean repetir = true;
		
		do {

			palavra = MyIO.readLine(); // leitura para string
			char[] vet = palavra.toCharArray(); // transforma string em array

			if (vet.length >= 3 && palavra.equalsIgnoreCase("FIM")) { // funC'C#o para interromper caso a palavra seja 'FIM'
				repetir = false;
				break;
			}

			for(int i = 0; i < vet.length; i++) {

                if((vet[i] >= ' ' && vet[i] <= '~')){ // MACETE PARA �
				vet[i] = (char) (vet[i] + 3);  // passa o valor do caractere 3 casas a diante
                }
			}

			String resultado = new String(vet); // transforma o vetor em string
			System.out.println(resultado);

		} while(repetir);
	}
}
