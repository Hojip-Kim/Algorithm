import sys

givenNum = int(sys.stdin.readline())

tileFibo = []

tileNum = 0
for i in range(0, givenNum+1) :
    if i == 0 :
        tileNum = 1
    elif i == 1 :
        tileNum = 1
    else :
        tileNum = (tileFibo[-2] + tileFibo[-1]) % 15746
        
    tileFibo.append(tileNum)

print(tileFibo[givenNum])