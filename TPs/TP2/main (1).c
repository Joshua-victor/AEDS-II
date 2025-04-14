#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <ctype.h>


#define strmax 100

typedef struct Data{
    
    int dia;
    int mes;
    int ano;
    
}Data;

typedef struct Show{
    
    char Show_id[strmax];
    char Type[strmax];
    char Title[strmax];
    char Director[strmax];
    char Cast[strmax];
    char Country[strmax];
    Data Date_Added;
    int Release_Year;
    char Rating[strmax];
    char Duration[strmax];
    char Listed_In[strmax];

}Show;

Show construtor(){
    
    Show show;
    
    strcpy(show.Show_id, "NaN");
    strcpy(show.Type, "NaN");
    strcpy(show.Title, "NaN");
    strcpy(show.Director, "NaN");
    strcpy(show.Cast, "NaN");
    strcpy(show.Country, "NaN");
    show.Date_Added.dia = 0;
    show.Date_Added.mes = 0;
    show.Date_Added.ano = 0;
    show.Release_Year = 0;
    strcpy(show.Rating, "NaN");
    strcpy(show.Duration, "NaN");
    strcpy(show.Listed_In, "NaN");
    
    return show;

}


Show Clone( Show show){
    
    Show clone = show;
    return clone;
    
}


void imprimir(Show show){
    
    
    printf("=> %s ## %s ## %s ## %s ## [%s] ## %s ## %02d, %02d %04d ## %d ## %s ## %s ## [%s]\n",
    show.Show_id,
    show.Type,
    show.Title,
    show.Director,
    show.Cast,
    show.Country,
    show.Date_Added.dia,
    show.Date_Added.mes,
    show.Date_Added.ano,
    show.Release_Year,
    show.Rating,
    show.Duration,
    show.Listed_In );

}

void trim(char *entrada){ // função para retirar espaços no inicio e fim de uma sting
    
    
    
    
}

 void lerCSV(){
     
     FILE *disneyplus = fopen("disneyplus.csv", "r");
     
     if(!disneyplus){
         printf("arquivo não encontrado");
         exit(1);
     }
     
     char linhaCSV[1024]; // Tamanho maximo da linha do csv
     fgets(line, 1024, disneyplus);// descarta o cabeçalho do arquivo
     
       while (fgets(line, MAX_LINE_SIZE, fp)) {
        line[strcspn(line, "\r\n")] = 0; // Remove quebra de linha
        shows[showsLength++] = readShow(line); // Lê e armazena
        if (showsLength >= MAX_SHOWS) break;
    }
    
    fclose(disneyplus);
     
     
     
 }



int main()
{
    
    lerCSV();
    
    char entrada[100];
    fgets(entrada, 100, stdin); //
    entrada[strcspn(entrada, "\r\n")] = 0;  // procura a primeira aparição de \r ou \n e substitui por 0
    trim(entrada);
    
    
    
    
    
    
    
    
    
    
    
    
    

    return 0;
}