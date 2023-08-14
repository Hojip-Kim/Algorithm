import sys

N, r, c = map(int,sys.stdin.readline().split())
global ans
ans = 0

def recur(x, y, length) :
    global ans
    if length == 0 :
        if x == r and y == c :
            print(ans)
            exit()
        ans += 1
        return

    half = length // 2
    if x<= r < x+half and y <= c < y+half :
        recur(x, y, half)
    else :
        ans += half * half
    if x<= r < x+half and y+half <= c < y + length :
        recur(x, y+half, half)
    else :
        ans += half * half
    if x+half <= r < x + length and y <= c < y+half : 
        recur(x+half, y, half)
    else :
        ans += half * half
    if x+half <= r < x + length and y+half <= c < y+ length :
        recur(x+half, y+half, half)
    else :
        ans += half * half


recur(0, 0, 2**N)