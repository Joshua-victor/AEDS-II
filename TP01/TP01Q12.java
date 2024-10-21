import java.io.*;
import java.nio.charset.*;

public class CiframentoCesarRecursivo {
    
    public static void main(String[] args) {
        MyIO.setCharset("UTF-8");
        processarEntrada(); // Inicia o processo recursivo de leitura e ciframento
    }

    public static void processarEntrada() {
        String palavra = MyIO.readLine(); // Leitura da string de entrada

        if (palavra.length() >= 3 && palavra.equalsIgnoreCase("FIM")) { // Condição de parada
            return;
        }

        String resultado = cifrarPalavra(palavra, 0); // Cifra a palavra
        System.out.println(resultado);
        processarEntrada(); // Chamada recursiva para continuar o processo
    }

    public static String cifrarPalavra(String palavra, int indice) {
        if (indice >= palavra.length()) { // Caso base: se o índice for maior ou igual ao comprimento da palavra, retorna a palavra cifrada
            return palavra;
        }

        char caractereAtual = palavra.charAt(indice);

        if (caractereAtual >= ' ' && caractereAtual <= '~') { // Verifica se o caractere está no intervalo válido
            caractereAtual = (char) (caractereAtual + 3); // Desloca o caractere 3 posições
        }

        // Reconstrói a palavra cifrada até o índice atual
        return cifrarPalavra(palavra.substring(0, indice) + caractereAtual + palavra.substring(indice + 1), indice + 1);
    }
}
