import sys

N, M = map(int,sys.stdin.readline().split())

givenList = [['s' for _ in range(M)] for _ in range(N)]

for i in range(N) :
    givenStr = sys.stdin.readline().strip()
    for j in range(M) :
        givenList[i][j] = givenStr[j]

def isBWB(list) :
    cnt = int()
    
    for i in range(8) :
        if i % 2 == 0 :
            if list[i] == 'B' :
                continue
            else :
                cnt += 1
        elif i % 2 == 1 :
            if list[i] == 'W' :
                continue
            else :
                cnt += 1

    return cnt

def isWBW(list) :
    cnt = int()

    for i in range(8) :
        if i % 2 == 0 :
            if list[i] == 'W' :
                continue
            else :
                cnt += 1
        elif i % 2 == 1 :
            if list[i] == 'B' :
                continue
            else :
                cnt += 1

    return cnt

def calcMinChange(doublyList) :
    calcNum1 = int()
    calcNum2 = int()
    for i in range(8) :
        if i % 2 == 0 :
            calcNum1 += isBWB(doublyList[i])
        elif i % 2 == 1 :
            calcNum1 += isWBW(doublyList[i])

    for i in range(8) :
        if i % 2 == 0 :
            calcNum2 += isWBW(doublyList[i])
        elif i % 2 == 1 :
            calcNum2 += isBWB(doublyList[i])
    
    return min(calcNum1, calcNum2)

minNum = 2501

makeList = [['s' for _ in range(8)] for _ in range(8)]

for i in range(N - 7) :
    for j in range(M - 7) :
        
        for k in range(i, i+8) :
            for l in range(j, j+8) :
                makeList[k-i][l-j] = givenList[k][l]
        
        # print(makeList)
        cnt = calcMinChange(makeList)

        minNum = min(cnt, minNum)

print(minNum)