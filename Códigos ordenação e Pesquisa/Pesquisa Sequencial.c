#include <stdbool.h>
#include <stdio.h>

int main()
{
  int vet[] = {1,5,66,8,67,53,23,48,523,4,754,24,6,4444,3,6789990}; //vetor
  int tam = sizeof(vet)/sizeof(vet[0]); //tamanho do vetor
  int n = 483; // numero que procura
  bool resp = false;
    
    
    for(int i = 0; i < tam; i++){ // for de 0 até o tamanho do vetor
        
        if(vet[i] == n){ //se vetor na pos i é igual a n, achamos o numero desejado
            resp = true;
            i = tam;
        }
        
    }
    
    
    if(resp){
        printf("o numero pertence ao vetor");
    }else{
        printf("o numero não pertence ao vetor");
    }
    
    return 0;
}