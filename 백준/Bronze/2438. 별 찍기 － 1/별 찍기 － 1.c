#include <stdio.h>

int main(void)
{
    int T;
    scanf("%d", &T);
    for(int i = 1; i <= T; i++){
        for(int j = 0; j < i; j++){
            printf("*");
        }
        printf("\n");
    }

    return 0;
}