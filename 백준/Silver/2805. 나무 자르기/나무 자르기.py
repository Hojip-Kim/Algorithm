import sys

A, B = map(int,sys.stdin.readline().split())

List = list(map(int,sys.stdin.readline().split()))

List.sort()

Ans = int()
def binarySearch(left, right, target):
    global List, Ans
    tmp = int()
    if left>right :
        return
        
    mid = (left + right) // 2
    
    for i in range(A) :
        if List[i] > mid :
            tmp += (List[i] - mid)
    if tmp >= target :
        
        Ans = max(Ans, mid)
        
    if tmp > target :
        binarySearch(mid+1, right, target)
    else :
        binarySearch(left, mid-1, target)

binarySearch(0, List[len(List)-1], B)
print(Ans)
#4 7
#20 15 10 17 => 10 15 17 20