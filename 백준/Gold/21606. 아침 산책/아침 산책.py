
import sys
from collections import deque

givenNum = int(sys.stdin.readline())

givenTF = sys.stdin.readline().strip()
isZero = []
isZero.append('0')
for i in range(len(givenTF)) :
    isZero.append(givenTF[i])

cnt = 0
graph = [[] for _ in range(givenNum+1)]
for _ in range(givenNum-1) :
    A, B = map(int,sys.stdin.readline().split())
    graph[A].append(B)
    graph[B].append(A)
    if isZero[A] == '1' and isZero[B] == '1' :
        cnt += 2

visited_set = []

def BFS(start) :
    tmpCnt = 0
    indoor_visited = set()
    visit = [False] * (givenNum + 1)
    q = deque([start])
    visit[start] = True
    
    while q :
        tmp = q.popleft()
        for i in graph[tmp] :
            if visit[i] == False :
                visit[i] = True
                if isZero[i] == '1' : # 1 : 실내
                    tmpCnt += 1
                    indoor_visited.add(i)
                elif isZero[i] == '0' : # 0 : 실외
                    q.append(i)
                    
    if indoor_visited in visited_set :
        return 0
    visited_set.append(indoor_visited)
    
    if tmpCnt > 1 :
        return tmpCnt * (tmpCnt-1)    
    else :
        return 0


for i in range(1, givenNum+1) :
    if isZero[i] == '0' :
        cnt += BFS(i)
        
print(cnt)
