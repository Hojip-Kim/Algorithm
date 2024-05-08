import sys
sys.setrecursionlimit(10**6)
N = int(sys.stdin.readline())

_givenList = [list(map(str,sys.stdin.readline().strip())) for _ in range(N)] 
abnormal_visited = [[False] * N for _ in range(N)]
normal_visited = [[False] * N for _ in range(N)]

d = [[0, 1], [1, 0], [0, -1], [-1, 0]]
def normalDFS(x, y, color) :
    normal_visited[x][y] = True
    
    for dx, dy in d :
        nx = x+dx
        ny = y+dy
        if 0 <= nx < N and 0 <= ny < N :
            if normal_visited[nx][ny] == False and _givenList[nx][ny] == color :
                normalDFS(nx, ny, color)

normalCnt = 0
colorList = ['R', 'G', 'B']
for color in colorList :
    for i in range(N) :
        for j in range(N) :
            if normal_visited[i][j] == False and _givenList[i][j] == color :
                normalDFS(i, j, color)
                normalCnt += 1


for i in range(N) :
    for j in range(N) :
        if _givenList[i][j] == 'G' :
            _givenList[i][j] = 'R'
            
def abnormalDFS(x, y, color) :
    abnormal_visited[x][y] = True
    
    for dx, dy in d :
        nx = x+dx
        ny = y+dy
        if 0 <= nx < N and 0 <= ny < N :
            if abnormal_visited[nx][ny] == False and _givenList[nx][ny] == color :
                abnormalDFS(nx, ny, color)

abnormalCnt = 0
abnormalColorList = ['R', 'B']
for color in abnormalColorList :
    for i in range(N) :
        for j in range(N) :
            if abnormal_visited[i][j] == False and _givenList[i][j] == color :
                abnormalDFS(i, j, color)
                abnormalCnt += 1

print(normalCnt, abnormalCnt)