import sys

# 3
# 2 2
# 1 5
# 13 29

N = int(sys.stdin.readline())

def calcComb(n: int, m: int) :
    child = 1
    parent = 1
    
    while n > 0 :
        child *= m
        parent *= n
        m -= 1
        n -= 1
    
    return child // parent

for i in range(N) :
    A, B = map(int,sys.stdin.readline().split())
    print(calcComb(A, B))

