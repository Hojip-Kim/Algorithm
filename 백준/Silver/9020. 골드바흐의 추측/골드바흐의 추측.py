import sys
import math

A = int(sys.stdin.readline())

tmpList = []
for i in range(A) :
    tmpList.append(int(sys.stdin.readline()))


def isPrime(tmpNumber) :
    if tmpNumber == 1 :
        return False
    else :
        tmpNum = 0
        for i in range(2, int(math.sqrt(tmpNumber))+1) :
            if tmpNumber%(i) == 0 :
                return False
                break
        return True

for i in tmpList :
    a, b = int(i/2), int(i/2)

    while True :
        if isPrime(a) and isPrime(b) and a+b == i :
            print(a, b)
            break;
        else :
            a -= 1
            b += 1