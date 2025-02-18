import java.util.Scanner;

public class TP01Q01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		boolean isfim = false;

		do {
			String palavra = scanner.nextLine();
			boolean resp = false;
			char[] vetor = palavra.toCharArray();
			char[] palindromo = new char[vetor.length];

			if (!palavra.equalsIgnoreCase("FIM")) {

				isfim = true;
			}


			for (int i = 0; i < vetor.length; i++) {
				palindromo[i] = vetor[vetor.length - 1 - i];
			}


			for(int i = 0; i < vetor.length; i++) {

				if(palindromo[i] == vetor[i]) {
					resp = true;

				} else {
					resp = false;
					i = vetor.length;
				}
			}

			if(resp) {
				System.out.println("SIM");
			} else {
				System.out.println("NÃO");
			}

		} while(isfim);

		scanner.close();
	}
}
