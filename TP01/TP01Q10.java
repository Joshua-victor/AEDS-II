import java.io.*;
import java.net.*;

public class Main {
    public static void main(String[] args) {
   
        String palindromo;

        do {
            palindromo = MyIO.readLine();
            int tamanho = palindromo.length();

           
            if (tamanho >= 3 && palindromo.equalsIgnoreCase("FIM")) {
                break;
            }

            palindromo = palindromo.toUpperCase();

            
            if (isPalindromeRecursive(palindromo, 0, tamanho - 1)) {
                System.out.println("SIM");
            } else {
                System.out.println("NAO");
            }

        } while (true);
    }

    
    private static boolean isPalindromeRecursive(String str, int left, int right) {
       
        if (left >= right) {
            return true;
        }
      
        if (str.charAt(left) != str.charAt(right)) {
            return false;
        }
        
        return isPalindromeRecursive(str, left + 1, right - 1);
    }
}
