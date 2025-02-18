#include <string.h>
#include <stdbool.h>
#include <stdio.h>

int main()
{
	char palavra[100];
	fgets(palavra, sizeof(palavra),stdin);
	int contagem = 0;
	int tamanho = strlen(palavra);


	for(int i = 0; i < tamanho; i++) {

		palavra[i] = palavra[i] + 3;

		if(palavra[i] == '#') {
			contagem++;
		}

	}
	contagem++;

	printf("%d", contagem);

	return 0;
}
