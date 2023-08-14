import sys
import math

A = int(sys.stdin.readline())

B = list(map(int,sys.stdin.readline().split()))


def isPrime(tmpNumber) :
    tmpNum = 0
    for i in range(2, tmpNumber) :
        if tmpNumber%(i) == 0 :
            return False
            break
    return True

tmpAnswer = 0
for i in B :
    if i != 1 and isPrime(i) :
        tmpAnswer += 1

print(tmpAnswer)