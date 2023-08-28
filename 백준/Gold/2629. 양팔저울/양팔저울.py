import sys

weightNum = int(sys.stdin.readline())

weightList = list(map(int,sys.stdin.readline().split()))

marbleNum = int(sys.stdin.readline())

marbleList = list(map(int,sys.stdin.readline().split()))

dp = [False] * 40001
dp[0] = True

for weight in weightList:
    canMake = set()
    for i in range(40001):
        if dp[i] == True:
            if i + weight <= 40001:
                canMake.add(i+weight) # 오른쪽에 놓았을때,
            if i - weight >= 0:
                canMake.add(i-weight) # 왼쪽에 놓았을 때
            if weight - i >= 0:
                canMake.add(weight-i) # 현재 물체만 오른쪽에 두고 나머지는 왼쪽에 두었을 때
    for c in canMake:
        dp[c] = True

for marble in marbleList:
    if dp[marble] == True:
        print('Y', end=" ")
    else:
        print('N', end=" ")