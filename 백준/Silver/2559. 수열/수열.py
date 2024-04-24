import sys

N, M = map(int,sys.stdin.readline().split())

_list = list(map(int,sys.stdin.readline().split()))

max_num = 0

for i in range(M) :
    max_num += _list[i]
tmp_num = max_num
for i in range(N-M) :
    tmp_num = tmp_num-_list[i]+_list[i+M]
    max_num = max(max_num, tmp_num)
    
print(max_num)