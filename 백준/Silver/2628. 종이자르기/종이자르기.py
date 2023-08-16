import sys

A, B = map(int,sys.stdin.readline().split())

N = int(sys.stdin.readline())

givenList = list()

for i in range(N) :
    givenList.append(list(map(int,sys.stdin.readline().split())))


yList = list()
xList = list()
for i in givenList :
    if i[0] == 0 :
        yList.append(i[1])
    if i[0] == 1 :
        xList.append(i[1])
xList.append(0)
xList.append(A)
yList.append(0)
yList.append(B)
yList.sort() # 0 2 3 10
xList.sort() # 0 4 10


tmpX = xList[0]
tmpY = xList[0]

for i in range(len(xList)-1) : # 2까지 index
    tmpX = max(tmpX, xList[i+1]-xList[i])

for i in range(len(yList)-1) :
    tmpY = max(tmpY, yList[i+1]-yList[i])
    
print(tmpX*tmpY)