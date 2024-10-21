import java.util.Random;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) throws IOException {
        // Cria um objeto Random para gerar números aleatórios
        Random gerador = new Random();
        // Define uma semente fixa para o gerador de números aleatórios (garante que a sequência de números seja a mesma em cada execução)
        gerador.setSeed(4);

        // Variável de controle para o loop
        boolean repetir = true;

        // Cria um BufferedReader para ler a entrada padrão (teclado) com codificação UTF-8
        BufferedReader Leitura = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        // Inicia um loop que continua até que 'repetir' seja falso
        do {
            // Lê uma linha da entrada padrão
            String linha = Leitura.readLine();
            // Se a linha lida for nula (EOF), sai do loop
            if (linha == null) {
                break;
            }

            // Obtém o tamanho da linha lida
            int tamanho = linha.length();

            // Se a linha tem 3 ou mais caracteres e é "FIM" (ignora maiúsculas/minúsculas), sai do loop
            if (tamanho >= 3 && linha.equalsIgnoreCase("FIM")) {
                break;
            }

            // Gera dois caracteres aleatórios entre 'a' e 'z'
            char letra1 = (char) ('a' + (Math.abs(gerador.nextInt()) % 26));
            char letra2 = (char) ('a' + (Math.abs(gerador.nextInt()) % 26));

            // Substitui todas as ocorrências de letra1 por letra2 na linha
            String resultado = linha.replace(letra1, letra2);

            // Imprime o resultado modificado
            System.out.println(resultado);

        // Continua o loop enquanto 'repetir' for verdadeiro
        } while (repetir);
    }
}
