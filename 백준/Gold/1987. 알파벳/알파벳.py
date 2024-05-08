import sys

R, C = map(int,sys.stdin.readline().split())

givenList = [list(map(str,sys.stdin.readline().strip()))for _ in range(R)]

d = [[-1, 0],[1, 0],[0, -1], [0, 1]]

cnt = 0

footPrint = set()

def dfs(x, y, count) :
    global cnt
    
    cnt = max(cnt, count)
    for dx,dy in d :
        nx = x+dx
        ny = y+dy
        if 0<=nx<R and 0<=ny<C and givenList[nx][ny] not in footPrint :
                footPrint.add(givenList[nx][ny])
                dfs(nx, ny, count+1)
                footPrint.remove(givenList[nx][ny])

footPrint.add(givenList[0][0])
dfs(0, 0, 1)
print(cnt)