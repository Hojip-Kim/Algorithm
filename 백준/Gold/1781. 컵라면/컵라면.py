import sys
import heapq

N = int(sys.stdin.readline())

givenQuestion = []

for i in range(N) :
    deadLine, cup = map(int,sys.stdin.readline().split())
    givenQuestion.append((deadLine,cup))
    
givenQuestion.sort()

queue = []

for i in givenQuestion :
    heapq.heappush(queue, i[1])
    if i[0] < len(queue) :
        heapq.heappop(queue)
        
print(sum(queue))