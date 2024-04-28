import sys

N = int(sys.stdin.readline())

_list = [[0 for _ in range(N)] for _ in range(N)]

for i in range(N) :
    tmp = sys.stdin.readline().strip()
    for j in range(N) :
        _list[i][j] = int(tmp[j])

def divConquer(x, y, n) :
    check = _list[x][y]
    for i in range(x, x+n):
        for j in range(y, y+n) :
            if check != _list[i][j] :
                check = -1
                break
    
    if check == -1 :
        print('(', end='')
        n = n // 2
        divConquer(x, y, n)
        divConquer(x, y+n, n)
        divConquer(x+n, y, n)
        divConquer(x+n, y+n, n)
        print(')', end='')
        return
    if check == 1 :
        print('1', end='')
    if check == 0 :
        print('0', end='')

divConquer(0, 0, N)