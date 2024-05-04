import sys

N = int(sys.stdin.readline())

_list1 = list(map(int,sys.stdin.readline().split()))

M = int(sys.stdin.readline())
_list2 = list(map(int,sys.stdin.readline().split()))

_dict = {}
for i in _list1 :
    _dict[i] = 1

for j in _list2 :
    if j in _dict :
        print(1)
    else :
        print(0)