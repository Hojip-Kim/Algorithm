#include <stdio.h>

int main(void)
{
    int x, y, w, h, min;

    scanf("%d %d %d %d", &x, &y, &w, &h);

    //x, y랑 w-x, h-y중 가장 작은값.
    min = x;

    if(min > w-x){
        min = w-x;
    }
    if(min > y){
        min = y;
    }
    if(min > h-y){
        min = h-y;
    }
    printf("%d", min);

    return 0;
}