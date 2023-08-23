import sys
from collections import deque

givenNum = int(sys.stdin.readline())

givenTF = sys.stdin.readline().strip()
isZero = []
isZero.append('0')
for i in range(len(givenTF)) :
    isZero.append(givenTF[i])


graph = [[] for _ in range(givenNum+1)]
for _ in range(givenNum-1) :
    A, B = map(int,sys.stdin.readline().split())
    graph[A].append(B)
    graph[B].append(A)

cnt = 0

def BFS(start) :
    global cnt
    q = deque([start])
    if isZero[start] == '0' :
        return
    else :
        visit[start] = True
        while q :
            tmp = q.popleft()
            for i in graph[tmp] :
                if visit[i] == False :
                    if isZero[i] == '1' :
                        cnt += 1
                    elif isZero[i] == '0' :
                        visit[i] = True
                        q.append(i)
            



for i in range(1, givenNum+1) :
    visit = [False] * (givenNum + 1)
    BFS(i)
print(cnt)
