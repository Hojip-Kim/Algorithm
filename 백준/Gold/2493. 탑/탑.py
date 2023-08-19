import sys

givenNum = int(sys.stdin.readline())

givenList = list(map(int,sys.stdin.readline().split())) # 6 9 5 7 4

stack = []
result = [0] * givenNum

for i in range(givenNum) :
    tower = givenList[i]
    while stack and givenList[stack[-1]] < tower :
        stack.pop()
    if stack:
        result[i] = stack[-1] +1
    stack.append(i)
        
print(' '.join(list(map(str, result))))