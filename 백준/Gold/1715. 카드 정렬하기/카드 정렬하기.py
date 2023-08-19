import sys
import heapq

givenNum = int(sys.stdin.readline())

givenList = []
for i in range(givenNum):
    heapq.heappush(givenList, int(sys.stdin.readline()))

result = 0
while len(givenList) > 1:
    # 가장 작은 두 카드 묶음을 합침
    smallest = heapq.heappop(givenList)
    second_smallest = heapq.heappop(givenList)
    total = smallest + second_smallest
    result += total
    heapq.heappush(givenList, total)

print(result)