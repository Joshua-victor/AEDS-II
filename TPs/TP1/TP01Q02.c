#include <ctype.h>
#include <stdio.h>
#include <string.h>
#include <stdbool.h>

int main()
{
    do{
	char palavra[100];
	fgets(palavra,sizeof(palavra), stdin); // ler a palavra 
	palavra[strcspn(palavra, "\n")] = '\0'; 
	int tamanho = strlen(palavra);
	
	if(strcmp(palavra, "FIM") == 0){
	    break;
	}

	bool maiuscula = false;
	bool minuscula = false;
	bool especial = false;
	bool numero = false;
	bool check1 = false;
	bool check2 = false;
	bool check3 = false;
	bool check4 = false;
	int i = 0;
	
	if(tamanho < 8){
	   i = tamanho;
	}

	for(i;  i < tamanho; i++) {

		if(isupper(palavra[i]) && check1 == false) { // isupper verifica se o vetor e Maiusculo

			maiuscula = true;
			check1 = true;

		} else if(islower(palavra[i]) && check2 == false ) { // islower verifica se o vetor é minusculo

			minuscula = true;
			check2 = true;
			
		} else if(ispunct(palavra[i]) && check3 == false ) { // ispunct verifica se o vetor é especial

			especial = true;
			check3 = true;

		} else if(isdigit(palavra[i]) && check4 == false ) { // isdigit verifica se o vetor é numero

			numero = true;
			check4 = true;
		} 
		
	}

/* verificação caso alguma não estava funcionando
	if(check1) {
		printf("SIM para maiuscula \n ");
	} else {
		printf("NÃO para maiuscula \n");
	}

	if(check2) {
		printf("SIM para minuscula \n ");
	} else {
		printf("NÃO para minuscula \n");
	}

	if(check3) {
		printf("SIM para especial \n");
	} else {
		printf("NÃO para especial \n");
	}


	if(check4) {
		printf("SIM para numero  \n");
	} else {
		printf("NÃO para numero \n");
	}*/


	if(check1 && check2 && check3 && check4){
	   printf("SIM\n");
	}else{
	   printf("NÃO\n");
	}
	
    }while(1);
	return 0;
}
