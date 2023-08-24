import sys

givenNum = int(sys.stdin.readline())

Fibo = []
num = 0
for i in range(givenNum + 1) :
    if i == 0 :
        num = 0
    elif i == 1 :
        num = 1
    else :
        num = Fibo[-2] + Fibo[-1]
    Fibo.append(num)
print(Fibo[-1])