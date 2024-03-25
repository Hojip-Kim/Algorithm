import sys

input = int(sys.stdin.readline())
result = int()

def sumSlice(input: int) :
    input = str(input)
    tmp = 0
    for i in input :
        tmp += int(i)
    return tmp

for i in range(1, input+1) :
    if i + sumSlice(i) == input :
        result = i
        print(i)
        break
    if i == input :
        print(0)
        break