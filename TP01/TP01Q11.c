#include <string.h>
#include <stdio.h>
#include <stdbool.h>
#include <ctype.h>


bool verificarRecursivo(int inicio, int fim, char palindromo[]);

int main() {
    char palindromo[100];

    do {
       
        fgets(palindromo, sizeof(palindromo), stdin);

        
        palindromo[strcspn(palindromo, "\n")] = '\0';

        
        if (strcmp(palindromo, "FIM") == 0) {
            break; 
        }

        int tamanho = strlen(palindromo);
        
      
        bool resposta = verificarRecursivo(0, tamanho - 1, palindromo);

        
        if (resposta) {
            printf("SIM\n");
        } else {
            printf("NAO\n");
        }

    } while (true);

    return 0;
}


bool verificarRecursivo(int inicio, int fim, char palindromo[]) {
    
    if (inicio >= fim) {
        return true;
    }

    
    if (palindromo[inicio] != palindromo[fim]) {
        return false;
    }

    // Chama a função recursivamente para a substring
    return verificarRecursivo(inicio + 1, fim - 1, palindromo);
}
