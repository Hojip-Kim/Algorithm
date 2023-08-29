#include <stdio.h>

int main(void)
{
    int arr[9];
    int max = 0;
    int result;
    for(int i = 0; i < 9; i++){
        int num;
        scanf("%d", &num);
        arr[i] = num;
        if(num >= max){
            max = num;
        }
    }

    for(int i = 0; i < 9; i++){
        if(arr[i] == max){
            printf("%d\n%d\n", max, i+1);
            break;
        }
    }


    return 0;
}