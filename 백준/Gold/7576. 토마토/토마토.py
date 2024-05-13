import sys
import collections

M, N = map(int,sys.stdin.readline().split())

givenList = [list(map(int,sys.stdin.readline().split()))for _ in range(N)]

q = collections.deque()

isVisited = [[False] * M for _ in range(N)]

d = [[0,1], [1,0], [0,-1], [-1,0]]

for i in range(N) :
    for j in range(M) :
        if givenList[i][j] == 1 :
            q.append([i,j])

def bfs() :
    while q :
        y,x = q.popleft()
        for dx,dy in d :
            ny = y+dy
            nx = x+dx
            
            if 0 <= nx < M and 0 <= ny < N and givenList[ny][nx] == 0 :
                    givenList[ny][nx] = givenList[y][x] + 1
                    q.append([ny,nx])

bfs()

ans = 0

for i in givenList :
    for j in i :
        if j == 0 :
            print(-1)
            exit()


for i in givenList :
    ans = max(ans, max(i))

print(ans-1)