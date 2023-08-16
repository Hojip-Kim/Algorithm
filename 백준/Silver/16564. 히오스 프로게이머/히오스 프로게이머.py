import sys

A, B = map(int,sys.stdin.readline().split())

# 1 100
# 40
List = []
for i in range(A) :
    List.append(int(sys.stdin.readline()))

List.sort() 

bottom = List[0]
top = List[-1]+ B + 1

while True :
    if bottom >= top :
        break
    tmp = int()
    mid = (top + bottom) // 2
    for i in List :
        if i < mid :
            tmp += (mid - i) # tmp : 레벨업에 사용된 경험치
            
    if tmp > B : # 레벨업에 사용된 경험치가 기존보다 크다면 (더 많이 사용했다면)
        top = mid
    else :
        bottom = mid+1
        
print(bottom-1)