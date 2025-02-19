#include <ctype.h>
#include <stdio.h>
#include <string.h>
#include <stdbool.h>

int main()
{
	char palavra[100];
	fgets(palavra,sizeof(palavra), stdin);
	palavra[strcspn(palavra, "\n")] = '\0';
	int tamanho = strlen(palavra);

	bool maiuscula;
	bool minuscula;
	bool especial;
	bool numero;
	bool check1 = false;
	bool check2 = false;
	bool check3 = false;
	bool check4 = false;

	for(int i =0 ; i < tamanho; i++) {

		if(palavra[i] < 'A' || palavra[i] > 'Z' && check1 == false  ) {

			maiuscula = true;
			check1 = true;

		} else if(palavra[i] < 'a' || palavra[i] > 'z' && check2 == false ) {

			minuscula = true;
			check2 = true;
		} else if(ispunct(palavra[i]) && check3 == false ) {

			especial = true;
			check3 = true;

		} else if(palavra[i] >= '0' && palavra[i] <= '9' && check4 == false ) {

			numero = true;
			check4 = true;
		}


	}

	if(check1) {
		printf("SIM para maiuscula \n ");
	} else {
		printf("NCO para maiuscula \n");
	}

	if(check2) {
		printf("SIM para minuscula \n ");
	} else {
		printf("NCO para minuscula \n");
	}

	if(check3) {
		printf("SIM para especial \n");
	} else {
		printf("NCO para especial \n");
	}


	if(check4) {
		printf("SIM para numero  \n");
	} else {
		printf("NCO para numero \n");
	}


	/*
	if(check1 && check2 && check3 && check4){
	   printf("SIM");
	}else{
	   printf("NCO");
	}

	*/



	return 0;
}