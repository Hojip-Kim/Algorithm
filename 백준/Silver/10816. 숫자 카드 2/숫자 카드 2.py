import sys

N = int(sys.stdin.readline())

givenList1 = list(map(int,sys.stdin.readline().split()))

M = int(sys.stdin.readline())

givenList2 = list(map(int,sys.stdin.readline().split()))

_dict = dict()

for i in givenList1 :
    if i not in _dict.keys() :
        _dict[i] = 1
    elif i in _dict.keys() :
        _dict[i] += 1

answerList = list()

for j in givenList2 :
    if _dict.get(j) :
        answerList.append(_dict.get(j))
    else :
        answerList.append(0)

for i in answerList :
    print(i, end=' ')