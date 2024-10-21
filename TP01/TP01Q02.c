#include <string.h>
#include <stdio.h>
#include <stdbool.h>
#include <ctype.h>

int main() {
    char palindromo[100];

    do {
       
        fgets(palindromo, sizeof(palindromo), stdin);


        
        if (strcmp(palindromo, "FIM\n") == 0) {
            break; 
        }

        int tamanho = strlen(palindromo);
        bool resposta = true;

        
        for (int i = 0; i < (tamanho - 1) / 2; i++) { 
            if (palindromo[i] != palindromo[tamanho - 2 - i]) { 
                resposta = false;
                break;
            }
        }

        if (resposta) {
            printf("SIM\n");
        } else {
            printf("NAO\n");
        }

    } while (true);

    return 0;
}
