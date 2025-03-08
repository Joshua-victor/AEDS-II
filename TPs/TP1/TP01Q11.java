import java.util.Scanner;
public class TP01Q11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        boolean isFim = false;
        do {
            String palavra = scanner.nextLine(); // Lê a entrada
            if (palavra.equalsIgnoreCase("FIM")) {
                isFim = true;
                break;
            }

            int[] frequencia = new int[256]; // Array para contar ocorrências dos caracteres
            int repetidos = 0;

            for (char c : palavra.toCharArray()) {
                frequencia[c]++;
            }

            for (int freq : frequencia) {
                if (freq > 1) {
                    repetidos++;
                }
            }

            MyIO.println(repetidos); 
            

        } while (!isFim);
        scanner.close();
    }
}
