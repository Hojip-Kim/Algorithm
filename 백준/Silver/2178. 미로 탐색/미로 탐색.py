import sys
from collections import deque

N, M = map(int,sys.stdin.readline().split())

givenList = [[] for _ in range(N)]

for i in range(N) :
    str = sys.stdin.readline().strip()
    for j in str :
        givenList[i].append(int(j))

d = [[0, 1], [1, 0], [0, -1], [-1, 0]]
def BFS(y, x) :
    queue = deque()
    queue.append((y, x))
    
    while queue :
        y1, x1 = queue.popleft()
        for dx, dy in d :
            if 0<=dy+y1<N and 0<=dx+x1<M :
                if givenList[dy+y1][dx+x1] == 1 :
                    givenList[dy+y1][dx+x1] = givenList[y1][x1] + 1
                    queue.append((dy+y1,dx+x1))
                    
                    
BFS(0,0)
print(givenList[N-1][M-1])