import sys

T = int(sys.stdin.readline())

for i in range(T) :
    N = int(sys.stdin.readline())
    people = []
    for _ in range(N):
        people.append(list(map(int, input().split())))

    people.sort()
    cutLine = people[0][1]  # 서류 1등의 면접 등수

    cnt = 1  # 합격자 수
    for i in people:
        # 서류는 앞 사람보다 낮지만, 면접 등수는 높은 참가자는 합격
        if cutLine > i[1]:
            cnt += 1
            cutLine = i[1]
    print(cnt)