#include <stdio.h>
#include <string.h>
#include <stdbool.h>            

int main() {
    char palavra1[100], palavra2[100];

    while(scanf("%s %s", palavra1, palavra2) != EOF){
    
    int tamanho1 = strlen(palavra1);
    int tamanho2 = strlen(palavra2);
    
    char combinatoria[tamanho1 + tamanho2 + 1]; // +1 por conta do /0 
    
    int i = 0, k = 0;

    
   for (i = 0; i < tamanho1 + tamanho2; i++) { // percorre o tamanho combinado de palavra1 e palavra2
        if (i < tamanho1) {
            combinatoria[k++] = palavra1[i];
        }
        if (i < tamanho2) {
            combinatoria[k++] = palavra2[i];
        }
    }

    combinatoria[k] = '\0'; 

    printf("%s\n", combinatoria);
    
    
}
    return 0;
    
}
