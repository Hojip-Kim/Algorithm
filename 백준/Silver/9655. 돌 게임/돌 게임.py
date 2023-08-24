import sys

givenNum = int(sys.stdin.readline())

if givenNum <= 2 :
    if givenNum == 1 :
        sys.stdout.write('SK')
    else :
        sys.stdout.write('CY')
else :
    boolList = [False] * (givenNum+1)
    boolList[1] = True
    boolList[2] = False
    boolList[3] = True
    for i in range(4, givenNum+1) :
        if boolList[i-3] == True and boolList[i-1] == True :
            boolList[i]=False
        else :
            boolList[i]=True

    if boolList[givenNum] :
        sys.stdout.write('SK')
    else :
        sys.stdout.write('CY')