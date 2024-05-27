from collections import deque

q = deque()

d = [[0,1], [1,0], [0,-1], [-1,0]]

isVisited = [[False for _ in range(500)] for _ in range(500)]

def bfs(x, y, land, m, n, ans_list) :
    cnt = 1
    q.append([x, y])
    isVisited[y][x] = True
    visited_x = [x]
    while q :
        x, y = q.popleft()
        for dx,dy in d :
            nx = x+dx
            ny = y+dy
            if 0<= nx < m and 0<= ny < n :
                if land[ny][nx] == 1 and isVisited[ny][nx] == False:
                    q.append([nx, ny])
                    isVisited[ny][nx] = True
                    if nx not in visited_x :
                        visited_x.append(nx)
                    cnt += 1
    for connected_x in visited_x :
        ans_list[connected_x] += cnt

def solution(land):
    answer = 0
    m = len(land[0])
    n = len(land)
    ans_list = [0 for _ in range(m)]
    
    for x in range(m) :
        for y in range(n) :
            if land[y][x] == 1 and isVisited[y][x] == False  :
                isVisited[y][x] = True
                bfs(x, y, land, m, n, ans_list)

    answer = max(ans_list)
    return answer

