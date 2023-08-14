import sys

N = int(sys.stdin.readline())

givenList = list()

for i in range(N) :
    givenList.append(int(sys.stdin.readline()))

givenList.sort()

for i in givenList :
    print(i)

