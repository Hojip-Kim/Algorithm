import sys
from collections import deque

A, B = map(int,sys.stdin.readline().split())
tmp = B
List = list() 
for i in range(1, A+1) : 
    List.append(i)

resultList = list()
while True :
    if B == 0 :
        B = len(List)-1
    else :
        B = B-1
    resultList.append(List.pop(B)) # 4 / 3 6 2 7 5 1 4 / len 0
    B += tmp # 3
    if len(List) == 0 :
        break
    B = B % len(List) # 0
    
    
print("<" + ", ".join(map(str, resultList)) + ">")