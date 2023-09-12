import sys
sys.setrecursionlimit(10**6)

N, M, R = map(int,sys.stdin.readline().split())

givenList = [[] for _ in range(N+1)]

cnt = 0


for i in range(M) :
    A, B = map(int,sys.stdin.readline().split())
    givenList[A].append(B)
    givenList[B].append(A)

for j in range(1, len(givenList)) :
    givenList[j].sort()

visited = [0] * (N+1)

cnt = 0
def dfs(R) :
    global cnt
    cnt += 1
    visited[R] = cnt # visited[3] = 4

    
    for i in givenList[R] :
        if visited[i] == 0 :
            dfs(i)

dfs(R)

for i in visited[1:] :
    print(i)