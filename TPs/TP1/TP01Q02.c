#include <stdio.h>
#include <string.h>
#include <stdbool.h>

int main()
{
    
    char palavra[100];
    do{
    bool isfim = true;
	bool resp = true;  // variavel para falar se é palindromo ou não
	char palavra[100];
	fgets(palavra, sizeof(palavra), stdin); // usa-se fgets para ler palavras com espaço
	palavra[strcspn(palavra, "\n")] = '\0';
	
    int tamanho = strlen(palavra); // estipula o tamanho da string
	
	if (strcmp(palavra, "FIM") == 0) {
            break;
        }
	
	int j = 0;
	for (int i = 0; palavra[i] != '\0'; i++) { // for para retirar espaços da string
        if (palavra[i] != ' ') {
            palavra[j++] = palavra[i];
        }
    }
    palavra[j] = '\0'; 
    
     tamanho = strlen(palavra); //redefinindo o tamanho da palavra sem espaços

	for (int i = 0; i < tamanho / 2; i++) {
		if (palavra[i] != palavra[tamanho - 1 - i]) {
			resp = false;
			i = tamanho;
		}
	}   

	if(resp) {
		printf("SIM \n");
	} else {
		printf("NÃO \n");
	}

    }while(1);
	return 0;
}
