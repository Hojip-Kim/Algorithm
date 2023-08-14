import sys

A, B, C = map(int,sys.stdin.readline().split())


def recur(a, b) :
    
    if b == 1 :
        return a % C
        
    tmp = recur(a, b//2)
    if b % 2 == 0 :
        tmp = tmp*tmp%C
    else : 
        tmp = tmp*tmp*a%C
    return tmp

print(recur(A,B))