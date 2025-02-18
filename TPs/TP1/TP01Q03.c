#include <stdbool.h>
#include <string.h>
#include <stdio.h>

int main()
{
    char palavra[100];
    do{
   bool resp = true;
   int deslocamento = 3;
   
    fgets(palavra, sizeof(palavra), stdin);
    palavra[strcspn(palavra, "\n")] = '\0';

    if(strcmp(palavra, "FIM") == 0){
        break;
    }
   
   
   for(int i = 0; i < strlen(palavra); i++){
       
       palavra[i] = palavra[i] + 3;
       
   }
   
   
   printf("%s\n", palavra);
   
    }while(1);

    return 0;
}