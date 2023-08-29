#include <stdio.h>

int main(void)
{
    int A, B;
    scanf("%d %d", &A, &B); // A와 B 변수의 주소에 값을 할당함.

    printf("%d\n", A+B);
    printf("%d\n", A-B);
    printf("%d\n", A*B);   
    printf("%d\n", A/B);
    printf("%d\n", A%B);

    return 0;
}