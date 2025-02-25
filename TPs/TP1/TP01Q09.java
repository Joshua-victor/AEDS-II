public class TP01Q09
{
	public static void main(String[] args) {

		boolean isfim = false;
		do {

			String palavra1 = MyIO.readString();

			if(palavra1.equalsIgnoreCase("FIM")) {
				isfim = true;
				break;
			}
			
			String ifem = MyIO.readString();
			String palavra2 = MyIO.readString();
			boolean resp = false;

			palavra1 = palavra1.toUpperCase(); // função para deixar a palavra completamente maiuscula
			palavra2 = palavra2.toUpperCase();  // função para deixar a palavra completamente maiuscula

			char[] Palavra1 = palavra1.toCharArray();  // função para transformar a string em vetor
			char[] Palavra2 = palavra2.toCharArray();  // função para transformar a string em vetor
			int tamanho = Palavra2.length;

			if(Palavra2.length != Palavra1.length) {
				resp = false;
			}

			for(int i = 0; i < tamanho; i++) {

				for(int j = 0; j < tamanho; j++) {

					if(Palavra1[j] == Palavra2[i]) {
						resp = true;
						j = tamanho;

					} else {
						resp = false;
					}
				}
			}

			if(resp == true) {
				MyIO.println("SIM");
			} else {
				MyIO.println("NAO");
			}

		} while(isfim != true);

	}
}



