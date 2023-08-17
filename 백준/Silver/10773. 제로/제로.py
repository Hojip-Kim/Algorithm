import sys

givenNum = int(sys.stdin.readline())

tmp = list()
for i in range(givenNum) :
    N = int(sys.stdin.readline())
    if N != 0 :
        tmp.append(N)
    else :
        tmp.pop()
    
result = int()    
for i in tmp :
    result += i
print(result)