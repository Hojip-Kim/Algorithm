import sys

N = int(sys.stdin.readline())

n = N // 5

haveAnswer = bool()

# N = 27이라고 치면
while True :
    if n < 0 :
        answer = False
        break

    if ( N - (n*5) ) % 3 == 0:
        answer = True
        break
    else :
        n -= 1

tmp = N - n*5
m = tmp // 3
if answer :
    print(n+m)
else :
    print(-1)