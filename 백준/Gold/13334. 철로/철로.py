import sys
import heapq

givenNum = int(sys.stdin.readline())

givenList = []

for _ in range(givenNum):
    A, B = map(int, sys.stdin.readline().split())
    start, end = min(A, B), max(A, B)
    givenList.append((start, end))

# 철로의 길이
Distance = int(sys.stdin.readline())

# 끝나는 지점을 기준으로 정렬
givenList.sort(key=lambda x: x[1])

result = 0
# 시작 지점을 저장할 최소 힙
start_points = []

for house in givenList:
    start, end = house
    # 철로 길이 내에 있는 집의 시작 지점을 힙에 추가
    heapq.heappush(start_points, start)
    # 철로 길이를 벗어나는 집의 시작 지점을 힙에서 제거
    while start_points and start_points[0] < end - Distance:
        heapq.heappop(start_points)
    # 현재 철로 길이 내에 있는 집의 수를 결과와 비교
    result = max(result, len(start_points))

print(result)