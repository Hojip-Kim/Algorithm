import sys
from collections import deque

N, M, V = map(int,sys.stdin.readline().split())

_graph = [[]for _ in range(N+1)]
_visited = [False] * (N+1)
_visited2 = [False] * (N+1)

for i in range(M) :
    A, B = map(int,sys.stdin.readline().split())
    _graph[A].append(B)
    _graph[B].append(A)


for i in range(len(_graph)) :
    _graph[i] = sorted(_graph[i])

answer = []
answer2 = []

def dfs(x) :
    _visited[x] = True
    answer.append(x)
    print(x, end=' ')
    
    for i in _graph[x] :
        if _visited[i] == False :
            dfs(i)

def bfs(x) :
    queue = deque([x])
    _visited2[x] = True
    while queue :
        x = queue.popleft()
        print(x, end=' ')
        answer2.append(x)
        for i in _graph[x] :
            if _visited2[i] == False :
                queue.append(i)
                _visited2[i] = True
    

dfs(V)
print()
bfs(V)
