import sys

N = int(sys.stdin.readline())

givenList = list()
numList = [0]*10001 # 1보다 같거나 크고, 1만보다 같거나 작은 값이 들어와야하기때문에 0 ~ 10000까지 값이 들어올 수 있는 리스트를 하나 만들어놓음.

for i in range(N) :
    numList[int(sys.stdin.readline())] += 1

for i in range(10001) :
    if numList[i] != 0 :
        for j in range(numList[i]) :
            print(i)


