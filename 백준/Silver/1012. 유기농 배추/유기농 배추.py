import sys
sys.setrecursionlimit(10000)

T = int(sys.stdin.readline())

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

def dfs(x, y) :
    _visited[x][y] = True
    for i in range(4) :
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < N and 0 <= ny < M :
            if _visited[nx][ny] == False and _graph[nx][ny] == 1 :
                dfs(nx, ny)

ansList = []

for _ in range(T) :
    M,N,K = map(int,sys.stdin.readline().split())
    _graph = [[0] * M for _ in range(N)]
    _visited = [[False] * M for _ in range(N)]
    for _ in range(K) :
        i, j = map(int,sys.stdin.readline().split())
        _graph[j][i] = 1
    answer= 0
    for i in range(N) :
        for j in range(M) :
            if _graph[i][j] == 1 and _visited[i][j] == False :
                dfs(i, j)
                answer += 1
    ansList.append(answer)

for i in ansList :
    print(i)