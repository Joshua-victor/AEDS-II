#include <stdio.h>
#include <string.h>
#include <stdbool.h>

int main() {
    char palavra1[100], palavra2[100];

    while (true) {

        if (fgets(palavra1, sizeof(palavra1), stdin) == NULL || palavra1[0] == '\n') {
            break;
        }
        if (fgets(palavra2, sizeof(palavra2), stdin) == NULL || palavra2[0] == '\n') {
            break;
        }


        palavra1[strcspn(palavra1, "\n")] = '\0';
        palavra2[strcspn(palavra2, "\n")] = '\0';

        int tamanho1 = strlen(palavra1);
        int tamanho2 = strlen(palavra2);

        char combinatoria[tamanho1 + tamanho2 + 1];
        int i = 0, k = 0;

        for (i = 0; i < tamanho1 + tamanho2; i++) {
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
