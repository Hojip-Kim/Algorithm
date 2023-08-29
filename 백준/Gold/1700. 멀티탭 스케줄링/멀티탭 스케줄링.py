import sys

N, K = map(int,sys.stdin.readline().split())

givenList = list(map(int,sys.stdin.readline().split()))

tmpmultiTap = []
cnt = 0

for i in range(K) :
    if len(tmpmultiTap) <= N and givenList[i] not in tmpmultiTap :
        tmpmultiTap.append(givenList[i])
    if len(tmpmultiTap) > N :
        latest = 0
        for j in range(N) :
            A = givenList[i+1 : K] # 앞으로 사용할 물건 리스트 전체
            if tmpmultiTap[j] not in A : # 앞으로도 사용하지않을 물건이 있다면 tmpMultiTap에서 제거
                tmpmultiTap.remove(tmpmultiTap[j])
                cnt += 1
                break
            else : #멀티탭에 사용예정이 있는 물건만 있는경우 가장 나중에 사용할 물건 찾기
                latest = max(latest, A.index(tmpmultiTap[j]))
        if len(tmpmultiTap) > N : # tmpmultiTap에 멀티탭개수보다 초과하여 꽂을경우
                tmpmultiTap.remove(A[latest]) # 가장 나중에 사용할 물건 멀티탭에서 제거한다.
                cnt += 1
print(cnt)
