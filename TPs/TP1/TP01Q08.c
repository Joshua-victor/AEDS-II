#include <string.h>
#include <stdio.h>
#include <ctype.h>
#include <stdbool.h>

int ContarNumeros(char numero[], int tamanho, int i) {

	if( i >= tamanho) { // enquanto i nC#o tiver o mesmo tamanho de "tamanho"
		return 0;
	}

	/* encontrei essa funC'C#o da biblioteca ctype que vC* se o numero que estC!
	no array C) um digito ou nC#o, caso sim ele soma o numero, e caso nC#o
	seja um digito ele soma 0*/

	int soma = isdigit(numero[i]) ? numero[i] - '0' : 0;

	return soma + ContarNumeros(numero,tamanho, i + 1);  // funC'C#o volta recursivamente
}


int main()
{
	char numero[50];
	do{
	scanf("%s", numero);
    
    if(strcmp(numero, "FIM" ) == 0){
        break;
    }

	int tamanho = strlen(numero);
	int soma = ContarNumeros(numero, tamanho, 0);

	printf("%d", soma);
	}while(1);
}