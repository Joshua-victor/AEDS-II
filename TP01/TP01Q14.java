import java.io.*;
import java.nio.charset.*;

public class Main {

    public static void main(String[] args) {
        processarEntrada(); 
    }

    public static void processarEntrada() {
        String palavra = MyIO.readLine();
        if (palavra.length() >= 3 && palavra.equalsIgnoreCase("FIM")) { 
            return;
        }

        boolean vogais = verificarVogais(palavra, 0);
        boolean consoante = verificarConsoantes(palavra, 0);
        boolean inteiro = verificarInteiros(palavra, 0);
        boolean real = verificarReal(palavra, 0);

        String vogaisResposta = vogais ? "SIM" : "NAO";
        String consoanteResposta = consoante ? "SIM" : "NAO";
        String inteiroResposta = inteiro ? "SIM" : "NAO";
        String realResposta = real ? "SIM" : "NAO";

        System.out.printf("%s %s %s %s%n", vogaisResposta, consoanteResposta, inteiroResposta, realResposta);

        processarEntrada(); 
    }

    public static boolean verificarVogais(String palavra, int indice) {
        if (indice >= palavra.length()) {
            return true; 
        }

        char c = palavra.charAt(indice);
        if ("AEIOUaeiou".indexOf(c) == -1) {
            return false; 
        }

        return verificarVogais(palavra, indice + 1);
    }

    public static boolean verificarConsoantes(String palavra, int indice) {
        if (indice >= palavra.length()) {
            return true; 
        }

        char c = palavra.charAt(indice);
        if (!Character.isLetter(c) || "AEIOUaeiou".indexOf(c) != -1) {
            return false; 
        }

        return verificarConsoantes(palavra, indice + 1);
    }

    public static boolean verificarInteiros(String palavra, int indice) {
        if (indice >= palavra.length()) {
            return true; 
        }

        if (!Character.isDigit(palavra.charAt(indice))) {
            return false; 
        }

        return verificarInteiros(palavra, indice + 1); 
    }

    public static boolean verificarReal(String palavra, int indice) {
        if (indice >= palavra.length()) {
            return false; 
        }

        if (palavra.charAt(indice) == '.') {
            return verificarInteiros(palavra.substring(indice + 1), 0); 
        }

        return verificarReal(palavra, indice + 1); 
    }
}
