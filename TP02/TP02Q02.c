#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>
#include <ctype.h>
#include <stdbool.h>

bool toBool(char *input)
{
    return strcmp(input, "VERDADEIRO") == 0;
}

typedef struct Date
{
    int dia, mes, ano;
} Date;

typedef struct Types
{
    int n;
    char type1[20];
    char type2[20];

}Types;

typedef struct Pokemon
{
    int id;
    int generation;
    char name[20];
    char description[40];
    char types[100];
    char abilities[60];
    double weight;
    double height;
    int captureRate;
    char legendary[80];
    char captureDate[100];
} Pokemon;

Pokemon pokemons[1000];

void printPokemon(Pokemon pokemons[], int pos) {
    printf("[#%d -> %s: %s - [%s] - [%s] - %.1fkg - %.1fm - %d%% - %s - %d gen] - %s\n", pokemons[pos].id, pokemons[pos].name, pokemons[pos].description, pokemons[pos].types, pokemons[pos].abilities, pokemons[pos].weight, pokemons[pos].height, pokemons[pos].captureRate, pokemons[pos].legendary, pokemons[pos].generation, pokemons[pos].captureDate);
}


void freeSplit(char **array)
{
    int i;
    for (i = 0; strcmp(array[i], "cFIM"); i++)
    {
        free(array[i]);
    }

    free(array[i]);

    free(array);
}



char **split(char *regex, char *string)
{
    int len = strlen(string);
    int n = 1;

    for (int i = 0; i < len; i++)
    {
        if (string[i] == regex[0])
            n++;
    }

    char **array = (char **)malloc((n + 1) * sizeof(char *));

    for (int i = 0; i < n + 1; i++)
    {
        array[i] = calloc(200, sizeof(char *));
    }

    strcpy(array[n], "cFIM");

    for (int i = 0; i < n; i++)
    {
        char *temp = strsep(&string, regex);
        strcpy(array[i], temp);
    }

    return array;
}

char* tratarAbilities(char *array)
{
    int tam = strlen(array);
    char* newLine = malloc((tam-3) * sizeof(char));
    int pos = 0;
    for(int i = 0; i < tam; i++)
    {
        if (array[i] != '"' && array[i] != '[' && array[i] != ']') {
                    newLine[pos] = array[i];
                    pos++;
                }
    }

    return newLine;
}


Pokemon ler(char *string)
{

    char **array = split(";", string);

    static int pos = 0;
    Pokemon x;


    pokemons[pos].id = atoi(array[0]);              
    pokemons[pos].generation = atoi(array[1]);
    strcpy(pokemons[pos].name, array[2]);             
    strcpy(pokemons[pos].description, array[3]);    
    strcpy(pokemons[pos].types, "'");
    strcat(pokemons[pos].types, array[4]);
    strcat(pokemons[pos].types, "'");
    if (array[5][0] != 0) 
    {
        strcat(pokemons[pos].types, ", '");
        strcat(pokemons[pos].types, array[5]);
        strcat(pokemons[pos].types, "'");
    }

    strcpy(pokemons[pos].abilities, array[6]);        
    pokemons[pos].weight = atof(array[7]);            
    pokemons[pos].height = atof(array[8]);           
    pokemons[pos].captureRate = atoi(array[9]);       
    array[10][0] == '1' ? strcpy(pokemons[pos].legendary, "true") : strcpy(pokemons[pos].legendary, "false");
    strcpy(pokemons[pos].captureDate, array[11]);    

    pos++;

    freeSplit(array);

    return x;
}

char* handleLine(char* line){
    int leng = strlen(line);
    char* formatted = malloc(leng * sizeof(char));
    bool control = true;
    int j = 0;
    for(int i=0; i<leng; i++){
        if(line[i] == '"') control = !control;
        else if(line[i] == ',' && control) formatted[j++] = ';';
        else if(line[i] != '[' && line[i] != ']') formatted[j++] = line[i];
    }
    formatted[j] = 0;
    return formatted;
}

void importDB(char *fileName)
{
    FILE *arq = fopen(fileName, "r");


    char line[2000];

    fgets(line, 2000, arq);

    for (int i = 0; fgets(line, 2000, arq); i++)
    {
        int pos = (int)strcspn(line, "\n\r");
        line[pos] = '\0';

        char* formatted = handleLine(line);

        
        ler(formatted);

    }


    fclose(arq);
}

int main()
{

    importDB("/tmp/pokemon.csv");

    char input[80];
    scanf(" %s", input);
    while(strcmp(input, "FIM"))
    {
        printPokemon(pokemons, atoi(input) - 1);
        scanf(" %s", input);
    }
}