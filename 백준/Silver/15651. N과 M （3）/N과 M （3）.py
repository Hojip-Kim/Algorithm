import sys

N, M = map(int,sys.stdin.readline().split())

tmpList = list()

def dfs() :
    if len(tmpList) == M :
        for i in tmpList :
            print(i, end=' ')
        print()
        return
    
    for i in range(1, N+1) :
        tmpList.append(i)
        dfs()
        tmpList.pop()
        
dfs()