import sys

N, K = map(int,sys.stdin.readline().split())

moneyList = []

for i in range(N) :
    moneyList.append(int(sys.stdin.readline()))

i = -1
tmpResult = K
cnt = 0
while tmpResult != 0 :    
    if tmpResult < moneyList[i] :
        i -= 1
    else :
        cnt += tmpResult // moneyList[i]
        tmpResult %= moneyList[i]
print(cnt)