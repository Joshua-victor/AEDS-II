import java.util.Random;
public class TP01Q04
{
	public static void main(String[] args) {


        String Palavra ;
        boolean isfim = false;
        do{
            Palavra = MyIO.readLine();
		Random gerador = new Random();
		gerador.setSeed(4);
		char letraAleatoria1 = (char) ('a' + (Math.abs(gerador.nextInt()) % 26));
		char letraAleatoria2 = (char) ('a' + (Math.abs(gerador.nextInt()) % 26));


        if (Palavra.equalsIgnoreCase("FIM")) {//equalsIgnoreCase serve para identificar se a palavra é igual a FIM
				isfim = true;
				break;
				
			}

		char[] frase = Palavra.toCharArray();

		int tamanho = Palavra.length();

		for(int i = 0; i < tamanho; i++) {

			if(frase[i] == letraAleatoria1) {

				frase[i] = letraAleatoria2;
			}

		}

		for (char c : frase) {  // for para printar o vetor
			MyIO.print(c);
		
		}
            	MyIO.println("");

        }while(isfim != true);
	}
}
