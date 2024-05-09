import sys
sys.setrecursionlimit(10**6)


M, N, K = map(int,sys.stdin.readline().split())

_list = [[0]*N for _ in range(M)]
isVisited = [[False]*N for _ in range(M)]
for _ in range(K) :
    x0, y0, x1, y1 = map(int,sys.stdin.readline().split()) 
    
    for i in range(y0, y1) :
        for j in range(x0, x1) :
            _list[i][j] = 1
            isVisited[i][j] = True

d = [[0, 1], [1,0], [0, -1], [-1, 0]]

def dfs(x, y) :
    isVisited[x][y] = True
    global cnt
    cnt += 1
    for dx, dy in d :
        nx = x+dx
        ny = y+dy
        if 0<=nx<M and 0<=ny<N :
            if isVisited[nx][ny] == False and _list[nx][ny] == 0 :
                dfs(nx, ny)
cnt = 0

answer = []
for i in range(M) :
    for j in range(N) :
        if isVisited[i][j] == False and _list[i][j] == 0 :
            dfs(i, j)
            answer.append(cnt)
        cnt = 0

answer.sort()

print(len(answer))
for ans in answer :
    print(ans,end=' ')