import sys

N = int(sys.stdin.readline())

_list = [[0 for _ in range(N)] for _ in range(N)]

for i in range(N) :
    givenList = list(map(int,sys.stdin.readline().split()))
    _list[i] = givenList

_dict = {}

def divideCoquer(x, y, n) :
    check = True
    tmp = _list[x][y]
    for i in range(x, x + n) :
        for j in range(y,y + n) :
            if _list[i][j] != tmp  :
                check = False
                break
    
    if check == False :
        n = n//3
        divideCoquer(x, y, n)
        divideCoquer(x, y+n, n)
        divideCoquer(x, y+2*n, n)
        divideCoquer(x+n, y, n)
        divideCoquer(x+n, y+n, n)
        divideCoquer(x+n, y+2*n, n)
        divideCoquer(x+2*n, y, n)
        divideCoquer(x+2*n, y+n, n)
        divideCoquer(x+2*n, y+2*n, n)
    
    if check == True :
        if tmp not in _dict :
            _dict[tmp] = 1
            return
        else :
            _dict[tmp] += 1



divideCoquer(0,0,N)

print(_dict.get(-1, 0))
print(_dict.get(0, 0))
print(_dict.get(1, 0))