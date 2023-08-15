import sys
import math

N, B = map(int,sys.stdin.readline().split())

procession = [list(map(int,sys.stdin.readline().split())) for _ in range(N)]

def multiPro(resultPro, List2) :
    resultList = [[0]*N for _ in range(N)]

    for i in range(N) :
        for j in range(N) :
            for k in range(N) :
                resultList[i][j] += resultPro[i][k]*List2[k][j]
                resultList[i][j] %= 1000
    return resultList

def multiRecur(tmpResultList, dep) :
    if dep == 1 :
        for i in range(len(tmpResultList)) :
            for j in range(len(tmpResultList)) :
                tmpResultList[i][j] %= 1000
        return tmpResultList
    
    half = multiRecur(tmpResultList, dep//2)
    if dep % 2 == 0 :
        return multiPro(half, half)
    else :
        return multiPro(multiPro(half, half), procession)

for i in multiRecur(procession, B) :
    print(*i)