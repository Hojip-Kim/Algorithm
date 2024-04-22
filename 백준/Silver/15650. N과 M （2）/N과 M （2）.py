import sys

N, M = map(int,sys.stdin.readline().split())

tmpList = list()

def dfs(start) :
    if len(tmpList) == M :
        for i in tmpList :
            print(i, end=' ')
        print()
    
    for i in range(start, N+1) :
        if i not in tmpList :
            tmpList.append(i)
            dfs(i+1)
            tmpList.pop()
            
dfs(1)