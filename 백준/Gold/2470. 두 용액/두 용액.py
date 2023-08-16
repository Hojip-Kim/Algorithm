import sys
import math

N = int(sys.stdin.readline())

givenList = list(map(int,sys.stdin.readline().split())) # givenList = [-2 , 4 , -99 , -1 , 98]

givenList.sort() # -99 -2 -1 4 98

Ans = math.inf

left = int()
right = len(givenList)-1
mid = int()

resultList = list()
while left < right :
    
    mid = givenList[left] + givenList[right]
    
    if mid == 0 :
        resultList=[givenList[left], givenList[right]]
    if mid > 0 :
        tmp = abs(mid)
        if Ans > tmp :
            resultList = [givenList[left], givenList[right]]
        Ans = min(abs(Ans), abs(mid))
        right -= 1
    else :
        tmp = abs(mid)
        if Ans > tmp :
            resultList = [givenList[left], givenList[right]]
        Ans = min(abs(Ans), abs(mid))
        left += 1
print(resultList[0], resultList[1])

# def binarySearch(left, right, target) : => 재귀는 depth가 1000까지만 들어갈 수 있음.
#     global Ans, ansList
#     if left >= right :
#         return
    
#     mid = (givenList[left] + givenList[right]) // 2 # givenList[1] + givenList[2] = -1.5
#     if mid == target :
#         ansList.append(givenList[left], givenList[right])
        
#     if mid > target :
#         Ans = min(abs(Ans), abs(mid)) # 1이랑 -1이랑 비교 => -1
#         binarySearch(left, right-1 , target) #1, 1, 0이 들어감
#     else :
#         Ans = min(abs(Ans), abs(mid)) # -1이랑 100000001이랑 비교 => -1이 Ans
#         binarySearch(left+1, right, target)  # 1, 4, 0이 들어감