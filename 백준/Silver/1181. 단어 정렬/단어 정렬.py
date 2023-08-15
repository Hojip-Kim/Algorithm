import sys

N = int(sys.stdin.readline())

StrList = [[] for _ in range(51)]
for i in range(N) :
    tmp = str(sys.stdin.readline().strip())
    length = len(tmp)
    if tmp not in StrList[length] :
        StrList[length].append(tmp)

for i in range(1, 51) :
    if len(StrList[i]) != 0 :
        StrList[i].sort()
        for j in StrList[i] :
            print(j)
