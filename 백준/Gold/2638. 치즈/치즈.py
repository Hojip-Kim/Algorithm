import sys
from collections import deque
import copy

# 20 20
# 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
# 0 0 0 1 1 1 0 0 0 0 0 0 1 1 1 0 0 0 0 0 
# 0 0 0 1 0 0 1 1 0 0 0 0 1 0 0 1 1 0 0 0
# 0 0 1 1 1 1 1 1 0 0 0 1 1 1 1 1 1 0 0 0
# 0 0 1 1 1 1 1 0 0 0 0 1 1 1 1 1 0 0 0 0
# 0 0 1 1 0 1 1 0 0 0 0 1 1 0 1 1 0 0 0 0
# 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
# 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
# 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
# 0 0 0 1 1 1 0 0 0 0 0 0 1 1 1 0 0 0 0 0 
# 0 0 0 1 0 0 1 1 0 0 0 0 1 0 0 1 1 0 0 0
# 0 0 1 1 1 1 1 1 0 0 0 1 1 1 1 1 1 0 0 0
# 0 0 1 1 1 1 1 0 0 0 0 1 1 1 1 1 0 0 0 0
# 0 0 1 1 0 1 1 0 0 0 0 1 1 0 1 1 0 0 0 0
# 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
# 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
# 0 0 1 1 1 1 1 0 0 0 0 1 1 1 1 1 0 0 0 0
# 0 0 1 1 1 1 1 0 0 0 0 1 1 1 1 1 0 0 0 0
# 0 0 1 1 1 1 1 0 0 0 0 1 1 1 1 1 0 0 0 0
# 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0

N, M = map(int,sys.stdin.readline().split())

_graph = [list(map(int,sys.stdin.readline().split())) for _ in range(N)]


#한번 for문이 돌 때 마다 외부에서 bfs를 해주어 0으로되어있는걸 -1과같은녀석으로 바꿔준다. 

d = [[0,1], [1, 0], [0,-1], [-1,0]]
deq = deque()
ans = 0


def bfsForOuter() :
    deq.append([0, 0])
    
    while deq :
        x, y = deq.popleft()
        
        for dx, dy in d :
            nx = x+dx
            ny = y+dy
            if 0 <= nx < M and 0 <= ny < N :
                if _graph[ny][nx] != 1 and _graph[ny][nx] != -1 :
                    deq.append([nx,ny])
                    _graph[ny][nx] = -1

def makeZero(x,y) :
    minusCount = 0
    global total_num
    if _graph[y][x] == 1 :
        total_num += 1
        for dx, dy in d :
            nx = x+dx
            ny = y+dy
            if _tmpGraph[ny][nx] == -1 :
                minusCount += 1
    
    return minusCount

total_num = 0

while True :
    bfsForOuter()
    _tmpGraph = copy.deepcopy(_graph)

    
    for i in range(N) :
        for j in range(M) :
            if makeZero(j,i) > 1 :
                _tmpGraph[i][j] = 0
                
    for i in range(N) :
        for j in range(M) :
            if _tmpGraph[i][j] == 0 :
                _graph[i][j] = -1
    
    for i in range(N) :
        for j in range(M) :
            if _graph[i][j] == -1 :
                _graph[i][j] = 0
    if total_num == 0 :
        break
    ans += 1
    total_num = 0


print(ans)