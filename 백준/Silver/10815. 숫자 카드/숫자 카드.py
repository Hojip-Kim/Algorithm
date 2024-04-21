import sys

N = int(sys.stdin.readline())

givenList = list(map(int,sys.stdin.readline().split()))

M = int(sys.stdin.readline())

findList = list(map(int,sys.stdin.readline().split()))

setDict = {}

for i in givenList :
    setDict[i] = 1

answer = list()

for j in findList :
    if setDict.get(j) :
        answer.append(1)
    else :
        answer.append(0)

for i in answer :
    print(i, end=' ')