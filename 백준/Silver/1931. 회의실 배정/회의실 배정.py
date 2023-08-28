import sys

givenNum = int(sys.stdin.readline())

givenList = []

for i in range(givenNum) :
    givenList.append(list(map(int,sys.stdin.readline().split())))

givenList.sort(key= lambda x : (x[1], x[0]))

cnt = 1
j, k = 0, 1
while k<=len(givenList)-1 :
    if givenList[j][1] <= givenList[k][0] :
        j = k
        cnt += 1
    k += 1
print(cnt)