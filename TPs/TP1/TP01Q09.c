#include <string.h>
#include <stdio.h>
#include <stdbool.h>
#include <ctype.h> 

int main()
{
   
   
   
   char palavra2[100];
   char palavra1[100];
   bool resp =true;
   
   scanf("%s %s" , palavra1, palavra2 ); 
   int tamanho = strlen(palavra1);
   
   if(strlen(palavra1) != strlen(palavra2)){ 
       resp = false; 
   }
   
   for(int i = 0; i < tamanho; i++){ 
       
       for(int j = 0; j < tamanho; j++){
           
           if(palavra1[j] == palavra2[i]){
              resp = true;
              j = tamanho;
             
           } else{
               resp = false;
           }
       }
   }
   
   
   if(resp == true){
       printf("SIM");
   }else{
       printf("não");
   }
   


    return 0;
}