import sys
sys.setrecursionlimit(10**6)

n = int(sys.stdin.readline())

_graph = [list(map(int,sys.stdin.readline().split()))for _ in range(n)]

d = [[0,1], [1,0], [0,-1], [-1,0]]

def dfs(x, y) :
    if dp[y][x] != 0 :
        return dp[y][x]
    dp[y][x] = 1 # 방문 체크
    
    for dx, dy in d :
        nx = x+dx
        ny = y+dy
        
        if 0<=nx<n and 0<=ny<n :
            if _graph[ny][nx] > _graph[y][x] :
                dp[y][x] = max(dp[y][x], dfs(nx,ny)+1)
    return dp[y][x]

cnt = 0
dp= [[0]*n for _ in range(n)] # dp table

for y in range(n) :
    for x in range(n) :
        if dp[y][x] == 0 :
            cnt = max(cnt,dfs(x,y))

print(cnt)