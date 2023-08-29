#include <stdio.h>

int main(void)
{
    int N, X;
    scanf("%d %d", &N, &X);

    int arr[N];
    int count = 0;

    for(int i = 0; i < N; i++){
        int num;
        scanf("%d", &num);
        if(num < X){
            arr[count++] = num;
        }
    }

    for(int i = 0; i<count; i++){
        if(arr[i] != 0){
            printf("%d ", arr[i]);
        }
    }

    return 0;
}