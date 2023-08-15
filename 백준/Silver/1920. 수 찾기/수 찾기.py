import sys
import math

n = int(sys.stdin.readline())
givenArray = sorted(list(map(int,sys.stdin.readline().split())))
m = int(sys.stdin.readline())
findNums = list(map(int,sys.stdin.readline().split()))

Ans = int()

def binarySearch(left, right, target) :
    global givenArray, Ans
    if right < left :
        return

    mid = (left + right) // 2
    if givenArray[mid] == target :
        # print("찾음")
        Ans = 1
        return 
    if givenArray[mid] < target :
        binarySearch(mid+1, right, target)
    else :
        binarySearch(left, mid-1, target)
    return


for i in findNums :
    Ans = 0
    binarySearch(0, len(givenArray)-1, i)
    print(Ans)