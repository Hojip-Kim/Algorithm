import sys

K, N = map(int,sys.stdin.readline().split())

_list = list()

for _ in range(K) :
    _list.append(int(sys.stdin.readline()))

min_num, max_num = 1, max(_list)

while max_num >= min_num :
    mid = (min_num+max_num) // 2
    _line = 0
    for i in _list :
        _line += i // mid
    
    if _line >= N :
        min_num = mid +1
    else :
        max_num = mid -1

print(max_num)