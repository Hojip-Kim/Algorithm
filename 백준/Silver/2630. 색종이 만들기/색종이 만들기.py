import sys

N = int(sys.stdin.readline())

givenList = list()

for i in range(N) :
    givenList.append(list(map(int,sys.stdin.readline().split())))

blue = 0
white = 0

def recur(x, y, length) :
    global blue, white
    color = givenList[x][y] #초기 색상
    for i in range(x, x+length) :
        for j in range(y, y+length) :
            if givenList[i][j] != color :
                    recur(x, y, length//2)
                    recur(x + length//2, y, length//2)
                    recur(x, y + length//2, length//2)
                    recur(x + length//2, y + length//2, length//2)
                    return

    if color == 1:
        blue += 1
    elif color == 0 :
        white += 1
    return
recur(0, 0, N)
print(white)
print(blue)
