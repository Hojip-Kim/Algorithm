import sys
from collections import deque
import copy

N, M = map(int,sys.stdin.readline().split())

givenList = [list(map(int,sys.stdin.readline().split()))for _ in range(N)]



d = [[0,1], [1,0], [0,-1], [-1,0]]

result = 0

def createWall(wall_cnt) :
    if wall_cnt == 3 :
        bfs()
        return
    
    for y in range(N) :
        for x in range(M) :
            if givenList[y][x] == 0 :
                givenList[y][x] = 1
                createWall(wall_cnt + 1)
                givenList[y][x] = 0

def bfs() :
    
    copyList = copy.deepcopy(givenList)
    
    global result
    
    q = deque()
    
    for i in range(N) :
        for j in range(M) :
            if givenList[i][j] == 2 :
                q.append([i,j])
    
    while q :
        y, x = q.popleft()
        copyList[y][x] = 2
        for dy,dx in d :
            ny = y+dy
            nx = x+dx
            if 0 <= ny < N and 0 <= nx < M and copyList[ny][nx] == 0 :
                q.append([ny, nx])
    
    cnt = 0
    
    for line in copyList :
        cnt += line.count(0)
        
    result = max(result, cnt)

createWall(0)

print(result)