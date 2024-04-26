import sys

N = int(sys.stdin.readline())

_list = list(map(int,sys.stdin.readline().split()))


_list.sort()
cnt = 0
answer = 0
for i in _list :
    cnt += i
    answer += cnt


print(answer)