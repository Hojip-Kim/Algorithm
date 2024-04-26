import sys

N = int(sys.stdin.readline())

_list1 = list(map(int,sys.stdin.readline().split()))
_list2 = list(map(int,sys.stdin.readline().split()))

# 2 3 1

tmp = 0
cnt = 1
ans = 0
while cnt < len(_list2) :
    compare = _list2[tmp]
    compared = _list2[cnt]
    if compare > compared :
        for i in range(tmp, cnt) :
            ans += compare *_list1[i]
        tmp = cnt
        cnt += 1
    else :
        cnt += 1


for i in range(tmp, cnt-1) :
    ans += _list2[tmp]*_list1[i]

print(ans)