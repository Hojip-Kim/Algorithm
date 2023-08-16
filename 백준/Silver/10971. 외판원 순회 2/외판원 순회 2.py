import sys
import itertools
import math

N = int(sys.stdin.readline())

givenList = list()

for i in range(N) :
    givenList.append(list(map(int,sys.stdin.readline().split())))
    
List = [i for i in range(N)]

Ans = math.inf

for i in itertools.permutations(List, N) :
    tmp = list(i)
    tmp.append(i[0])
    tmpValue = int()
    for j in range(len(tmp)-1) :
        if givenList[tmp[j]][tmp[j+1]] == 0 :
            tmpValue = 0
            break 
        tmpValue += givenList[tmp[j]][tmp[j+1]]
    if tmpValue != 0 :
        Ans = min(Ans, tmpValue)
    
print(Ans)