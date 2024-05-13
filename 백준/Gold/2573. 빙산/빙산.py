import sys
import collections

N, M = map(int,sys.stdin.readline().split())

givenList = [list(map(int,sys.stdin.readline().split()))for _ in range(N)]



d = [[0, 1], [1, 0], [0,-1], [-1,0]]

deq = collections.deque()
day = 0


def bfs(y,x) :
    deq.append([y,x])
    isVisited[y][x] = True
    
    while deq :
        y, x = deq.popleft()
        for dx,dy in d :
            nx = x+dx
            ny = y+dy
            
            if 0<=ny<N and 0<=nx<M :
                if givenList[ny][nx] != 0 and isVisited[ny][nx] == False :
                    isVisited[ny][nx] = True
                    deq.append([ny,nx])
                elif givenList[ny][nx] == 0 :
                    count[y][x] += 1
    return 1

isAnswerHave = False

while True :
    isVisited = [[False]*M for _ in range(N)]
    count = [[0]*M for _ in range(N)]
    result = []
    
    for i in range(N) :
        for j in range(M) :
            if isVisited[i][j] == False and givenList[i][j] != 0 :
                result.append(bfs(i,j))
    # 빙산이 아예 없다면 루프가 끝날때까지 쪼개지지않은것임.
    if len(result) == 0 :
        break
    if len(result) > 1 :
        isAnswerHave = True
        break
    
    for i in range(N) :
        for j in range(M) :
            givenList[i][j] -= count[i][j]
            if givenList[i][j] < 0 :
                givenList[i][j] = 0
    
    day += 1


if isAnswerHave :
    print(day)
else :
    print(0)