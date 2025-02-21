#include <stdio.h>
#include <string.h>
#include <stdbool.h>

int main()
{

	bool isfim = true;
	do{
	bool resp = true;  // variavel para falar se C) palindromo ou nC#o
	char palavra[100];
	fgets(palavra, sizeof(palavra), stdin); // usa-se fgets para ler palavras com espaC'o
	palavra[strcspn(palavra, "\n")] = '\0';
	
if (strcmp(palavra, "FIM") == 0) {
            break;
        }
        
        
	char palindromo[100];
	int tamanho = strlen(palavra) - 1;
	memcpy(palindromo, palavra, tamanho); // memcpy serve para fazer a copia de vetores

	int j = 0;
	for (int i = 0; palavra[i] != '\0'; i++) { // for para tirar os espaços da palavra
		if (palavra[i] != ' ') {
			palavra[j++] = palavra[i];
		}
	}

	for (int i = 0; i < tamanho; i++) { // for para inverter a palavra
		palindromo[i] = palavra[tamanho - 1 - i];
	}


	for(int i = 0; i < tamanho; i++) { // for para comparar se sC#o iguais

	 if (strcmp(palavra, palindromo) == 0) {
        
        resp = true;
        
    } else {
        resp = false;
        i = tamanho;
    }


	}


	if(resp == true) {
		printf("SIM\n");
	} else {
		printf("NAO\n");
	}
	
	}while(1);

}

