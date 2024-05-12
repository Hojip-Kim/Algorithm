import sys
sys.setrecursionlimit(10**6)

d = [[0,1], [1,0], [0,-1], [-1,0]]
ans = 0
def dfs(x,y, lenx, leny, isVisited, maps) :
    isVisited[y][x] = True
    global ans
    ans += int(maps[y][x])
    for dx, dy in d :
        nx = x+dx
        ny = y+dy
        if 0<=nx<lenx and 0<=ny<leny :
            if isVisited[ny][nx] == False and maps[ny][nx] != 'X' :
                dfs(nx, ny, lenx, leny, isVisited, maps)
    

def solution(maps):
    answer = []
    global ans
    lenx = len(maps[0])
    leny = len(maps)
    isVisited = [[False]*len(maps[0]) for _ in range(len(maps))]
    
    for i in range(leny) :
        for j in range(lenx) :
            if isVisited[i][j] == False and maps[i][j] != 'X' :
                dfs(j, i, lenx, leny, isVisited, maps)
                answer.append(ans)
                ans = 0
    
    
    
    if len(answer) != 0 : 
        answer.sort()
        return answer
    else :
        return [-1]