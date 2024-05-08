import sys
sys.setrecursionlimit(100000)

N = int(sys.stdin.readline())

_givenList = [list(map(int,sys.stdin.readline().split()))for _ in range(N)] 

d = [[0, 1], [1, 0], [0, -1], [-1, 0]]

def dfs(x, y, height) :
    _visited[x][y] = True
    
    for dx, dy in d :
        nx = x+dx
        ny = y+dy
        if 0 <= nx < N and 0 <= ny < N :
            if _visited[nx][ny] == False and _givenList[nx][ny] >= height :
                dfs(nx, ny, height)
                
max_num = -1



for height in range(1, 101) :
    _visited = [[False]*N for _ in range(N)]
    cnt = 0
    for i in range(N) :
        for j in range(N) :
            if _visited[i][j] == False and _givenList[i][j] >= height :
                dfs(i, j, height)
                cnt += 1
    max_num = max(max_num, cnt)

print(max_num)