import sys

S = sys.stdin.readline().strip()
N = int(sys.stdin.readline())
givenStringList = []

for i in range(N):
    givenStringList.append(sys.stdin.readline().strip())

dp = [0] * (len(S) + 1)

def canString(index):
    if index == len(S):
        dp[-1] = 1
        return
    else:
        if dp[index] != 1:
            dp[index] = 1
            for i in range(N):
                if len(S[index:]) >= len(givenStringList[i]):
                    for j in range(len(givenStringList[i])):
                        if S[index+j] != givenStringList[i][j]:
                            t = False
                            break
                    else:
                        canString(index + len(givenStringList[i]))

canString(0)
print(dp[-1])