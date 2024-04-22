import sys

N, M = map(int,sys.stdin.readline().split())

tmpList = list()

def dfs(start) :
    if len(tmpList) == M :
        for i in tmpList :
            print(i, end=' ')
        print()
        return
    
    for i in range(start, N+1) :
        tmpList.append(i)
        dfs(i)
        tmpList.pop()
        
dfs(1)