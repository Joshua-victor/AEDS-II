#include <string.h>
#include <stdio.h>

int main()
{
    char palavra[100];
    fgets(palavra, sizeof(palavra), stdin);
    palavra[strcspn(palavra, "\n")] = '\0';
    
    char transversa[100];
    int tamanho = strlen(palavra) -1;
    
    for(int i = 0; i < strlen(palavra); i++){
        
        transversa[i] = palavra[tamanho];
        tamanho--;
        
    }
    printf("%s\n" , palavra);
    printf("%s\n" , transversa);

    return 0;
}