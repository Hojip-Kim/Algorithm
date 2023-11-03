import sys
import math

def is_prime(num: int) :
    
    for i in range(2, int(math.sqrt(num))+1) :
        if num%i == 0 :
            return False
    return True

result = list()

A = int(sys.stdin.readline())

for _ in range(A) :
    input = int(sys.stdin.readline())
    a, b = int(input/2), int(input/2)
    while True :
        if is_prime(a) and is_prime(b) and a+b == input :
            result.append([a, b])
            break
        a -= 1
        b += 1
for a, b in result :
    print(a, b)