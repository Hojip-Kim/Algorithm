import sys
sys.setrecursionlimit(10**6)

d = [[0, 1], [1, 0], [0, -1], [-1, 0], [1, 1], [-1, -1], [1, -1], [-1, 1]]

def dfs(x, y) :
    isVisited[x][y] = True
    
    for dx, dy in d :
        nx = x + dx
        ny = y + dy
        
        if 0 <= nx < h and 0 <= ny < w  :
            if isVisited[nx][ny] == False and _list[nx][ny] == 1 :
                dfs(nx, ny)

answerList = list()
while True :
    w, h = map(int,sys.stdin.readline().split())
    
    if w == 0 and h == 0 :
        break
    
    _list = [list(map(int,sys.stdin.readline().split()))for _ in range(h)]
    
    isVisited = [[False] * w for _ in range(h)]
    
    cnt = 0
    
    for i in range(h) :
        for j in range(w) :
            if isVisited[i][j] == False and _list[i][j] == 1 :
                dfs(i, j)
                cnt += 1
    
    answerList.append(cnt)
    

for i in answerList :
    print(i)