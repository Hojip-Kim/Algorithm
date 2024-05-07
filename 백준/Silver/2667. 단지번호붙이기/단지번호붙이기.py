import sys

N = int(sys.stdin.readline())

_list = [list(map(int,sys.stdin.readline().strip())) for _ in range(N)]
_visited = [[False]*N for _ in range(N)]

dx = [0, 0, 1, -1]
dy = [1, -1, 0 , 0]

def dfs(x, y) :
    global cnt
    _visited[x][y] = True
    if _list[x][y] == 1 :
        cnt += 1
    for i in range(4) :
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < N and 0 <= ny < N :
            if _visited[nx][ny] == False and _list[nx][ny] == 1 :
                dfs(nx, ny)
                
cnt = 0
housing = []

for i in range(N) :
    for j in range(N) :
        if _list[i][j] == 1 and _visited[i][j] == False :
            dfs(i, j)
            housing.append(cnt)
            cnt = 0

print(len(housing))
housing.sort()
for i in housing :
    print(i)