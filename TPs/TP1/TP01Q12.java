public class TP01Q12
{
	public static void main(String[] args) {

		boolean isfim = false;
		do {

			String palavra = MyIO.readString();
			char [] senha = palavra.toCharArray();
			int tamanho = senha.length;
			boolean maiuscula = false;
			boolean minuscula = false;
			boolean especial = false;
			boolean numero = false;
			boolean check1 = false;
			boolean check2 = false;
			boolean check3 = false;
			boolean check4 = false;
			int i = 0;
			
			if(palavra.equalsIgnoreCase("FIM")){
			    isfim = true;
			    break;
			}

			if(tamanho < 8) {
				i = tamanho;
			}


			for( i = 0 ;  i < tamanho; i++) {

				if(Character.isUpperCase(senha[i]) && check1 == false) { // isupper verifica se o vetor e Maiusculo

					maiuscula = true;
					check1 = true;

				} else if(Character.isLowerCase(senha[i]) && check2 == false ) { // islower verifica se o vetor C) minusculo

					minuscula = true;
					check2 = true;

				} else if(Character.isLetterOrDigit(senha[i]) && check3 == false ) { // ispunct verifica se o vetor C) especial

					especial = true;
					check3 = true;

				} else if(Character.isDigit(senha[i]) && check4 == false ) { // isdigit verifica se o vetor C) numero

					numero = true;
					check4 = true;
				}

			}


			if(check1 && check2 && check3 && check4) {
				MyIO.println("SIM");
			} else {
				MyIO.println("NAO");
			}

		} while(isfim != true);

	}
}



