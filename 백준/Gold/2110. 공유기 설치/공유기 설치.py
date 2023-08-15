import sys

A, B = map(int,sys.stdin.readline().split())

givenList = list()

for i in range(A) :
    givenList.append(int(sys.stdin.readline()))

givenList.sort() # 0 1 2 4 8 9

Ans = 0
def check(distance) :
    start = givenList[0]
    cnt = 1
    
    for i in range(1, A) :
        if givenList[i] - start >= distance :
            cnt += 1
            start = givenList[i]
    return cnt
            
def binarySearch(left, right, target):
    global Ans
    
    if left>right:
        return
        
    mid = (left + right) // 2 # 4
    tmp = check(mid) # 공유기 박은 갯수가 나옴
    if tmp >= target :
        Ans = max(Ans, mid)
        binarySearch(mid+1, right, target) # 만약 성공했으면 distance를 늘려서 다시 check
    else :
        binarySearch(left, mid-1, target) # 실패(공유기의 갯수가 타겟보다 작으면) distacne를 줄여서 다시 check
    
binarySearch(0, givenList[-1], B) # 08.16 한번더 보고 이해하기

print(Ans)