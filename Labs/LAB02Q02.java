import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String linha = scanner.nextLine().trim();

            if (linha.isEmpty()) { 
                break;
            }

            String[] partes = linha.split(" ");
            if (partes.length < 2) { 
                break;
            }

            int numero1 = Integer.parseInt(partes[0]);
            int numero2 = Integer.parseInt(partes[1]);

            int[] vet = new int[20];
            int valor = 0;

            if (numero1 > numero2) {
                for (int i = numero1; i >= numero2; i--) {
                    vet[valor++] = i;
                }
            } else {
                for (int i = numero1; i <= numero2; i++) {
                    vet[valor++] = i;
                }
            }

            for (int i = 0; i < valor; i++) {
                System.out.print(vet[i]);
            }

            for (int i = valor - 1; i >= 0; i--) {
                int invertido = 0, n = vet[i];

                while (n > 0) {
                    invertido = invertido * 10 + (n % 10);
                    n /= 10;
                }

                System.out.print(invertido);
            }
            System.out.println();
        }
        scanner.close();
    }
}
