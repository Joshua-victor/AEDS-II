import java.util.Scanner;


class Ponteiro {
	int n;
}

public class Main
{

	public static void pesquisar(int numero, int[] lista, Ponteiro quantidade) {

		boolean achou = false;
		for (int i = 0; i < quantidade.n; i++) {
			
			if(lista[i] == numero){
			    System.out.println("Numero encontrado na pos: " + i);
			    i = quantidade.n;
			    achou = true;
			}
			
			
		}
		if(achou != true){
			    System.out.println("Numero não encontrado!");
			    
			}
		
	}



	public static void mostrar(int[] lista, Ponteiro quantidade) {

		System.out.print("[");
		for (int i = 0; i < quantidade.n; i++) {
			System.out.print(lista[i]);
			System.out.print(" ");
		}
		System.out.println("]");
	}

	public static void remover(int pos, int[] lista, Ponteiro quantidade, int tamanho) {

		try {
			if( pos < 0 || pos > quantidade.n) { // verifica se  tem espaC'o, se pos nC#o e negativo, se pos nC#o C) maior que a lista

			}
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Lista cheia ou pos invC!lida!");
		}


		quantidade.n--;

		for(int i = pos; i < quantidade.n; i++) {


			lista[i] = lista[i+1];
		}




	}



	public static int removerFim(int[] lista, Ponteiro quantidade, int tamanho) {

		try {
			if(quantidade.n  == 0  ) { // verifica se a lista nC#o esta vazia

			}
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Lista cheia ou pos invC!lida!");
		}

		int removido = lista[quantidade.n];
		quantidade.n--;


		return removido;


	}



	public static int removerInicio(int[] lista, Ponteiro quantidade, int tamanho) {

		try {
			if(quantidade.n  == 0  ) { // verifica se a lista nC#o esta vazia

			}
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Lista cheia ou pos invC!lida!");
		}

		int removido = lista[0];
		quantidade.n--;


		for(int i = 0; i < quantidade.n; i++) {


			lista[i] = lista[i+ 1];
		}

		return removido;


	}


	public static void inserir(int pos, int numero, int[] lista, Ponteiro quantidade, int tamanho) {

		try {
			if(quantidade.n  >= tamanho || pos < 0 || pos > quantidade.n) { // verifica se  tem espaC'o, se pos nC#o e negativo, se pos nC#o C) maior que a lista

			}
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Lista cheia ou pos invC!lida!");
		}


		for(int i = quantidade.n; i > pos; i--) {


			lista[i] = lista[i-1];
		}

		lista[pos] = numero;
		quantidade.n++;


	}



	public static void inserirFim( int numero, int[] lista, Ponteiro quantidade, int tamanho) {

		try {
			if(quantidade.n  >= tamanho) {

			}
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Lista cheia!");
		}


		lista[quantidade.n] = numero;
		quantidade.n++;


	}

	public static void inserirInicio(int numero, int[] lista, Ponteiro quantidade, int tamanho) {

		try {
			if(quantidade.n >= tamanho) {

			}
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Lista cheia!");
		}

		for(int i = quantidade.n; i > 0; i--) {

			lista[i] = lista[i - 1];
		}

		lista[0] = numero;
		quantidade.n++;
	}


	public static void main(String[] args) {
		Scanner Scanner = new Scanner (System.in);
		boolean isfim = false;
		Ponteiro ponteiro = new Ponteiro();
		ponteiro.n = 0;
		int[] lista = new int[100];

		do {

			System.out.println("---------------------------------------------------------------------");
			System.out.println("\nbem vindo aos exemplos de TAD, aqui temos algumas opC'C5es para treinar \ntemos as opC'C5es:\n a - inserir no inicio\n b - inserir no fim\n c - inserir em alguma posiC'C#o\n d - remover no inicio\n e - remover no fim\n f - remover\n g - mostrar\n h - pesquisar\n FIM - para sair do programa\n ");
			System.out.println("---------------------------------------------------------------------");

			System.out.print("digite a escolha que deseja:");
			String escolha = Scanner.nextLine();


			int numero = 0;
			int pos = 0;

			if(escolha.equalsIgnoreCase("FIM")) {
				isfim = true;
				break;
			}


			switch (escolha) {


			case "a":
				System.out.print("Digite o numero desejado: ");
				numero = Scanner.nextInt();
				Scanner.nextLine();
				inserirInicio(numero, lista, ponteiro, lista.length);
				mostrar(lista, ponteiro);

				break;

			case "b":
				System.out.print("Digite o numero desejado: ");
				numero = Scanner.nextInt();
				Scanner.nextLine();
				inserirFim(numero, lista, ponteiro, lista.length);
				mostrar(lista, ponteiro);

				break;

			case "c":
				System.out.print("Digite o numero desejado: ");
				numero = Scanner.nextInt();
				Scanner.nextLine();
				System.out.print("Digite a posiC'C#o desejada: ");
				pos = Scanner.nextInt();
				Scanner.nextLine();
				inserir(pos, numero, lista, ponteiro, lista.length);
				mostrar(lista, ponteiro);
				break;

			case "d":

				int removido = removerInicio(lista, ponteiro, lista.length);
				System.out.println("elemento removido: " + removido);
				mostrar(lista, ponteiro);
				break;


			case "e":
				removido = removerFim(lista, ponteiro, lista.length);
				mostrar(lista, ponteiro);
				break;


			case "f":

				System.out.print("Digite a posiC'C#o desejada: ");
				pos = Scanner.nextInt();
				Scanner.nextLine();
				remover(pos, lista, ponteiro, lista.length);
				mostrar(lista, ponteiro);
				break;


			case "g":
				mostrar(lista, ponteiro);
				break;

			case "h":
				System.out.print("Digite a o numero desejado: ");
				numero = Scanner.nextInt();
				Scanner.nextLine();
				pesquisar(numero, lista, ponteiro);
				break;

			default:
				System.out.print("Invalido!");

			}


		} while(isfim != true);
		Scanner.close();
	}
}
