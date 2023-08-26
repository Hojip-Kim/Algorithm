import sys

givenString1 = sys.stdin.readline().strip()
givenString2 = sys.stdin.readline().strip()

len1 = len(givenString1)
len2 = len(givenString2)

dp = [[0] * (len2+1) for _ in range(len1+1)]
for i in range(1, len1+1):
    for j in range(1, len2+1) :
        if givenString1[i-1] == givenString2[j-1] :
            dp[i][j] = dp[i-1][j-1] + 1
        else :
            dp[i][j] = max(dp[i-1][j], dp[i][j-1])
print(dp[-1][-1])