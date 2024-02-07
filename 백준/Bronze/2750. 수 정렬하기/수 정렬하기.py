import sys

N = int(sys.stdin.readline())

givenList = []

for i in range(N) :
    givenList.append(int(sys.stdin.readline()))

for i in range(len(givenList)-1) :
    for j in range(i+1 , len(givenList)) :
        if givenList[j] < givenList[i] :
            tmp = givenList[i]
            givenList[i] = givenList[j]
            givenList[j] = tmp

for i in range(len(givenList)) :
    print(givenList[i])