import sys
import math

givenStr = sys.stdin.readline().strip()

def isPalindrome(start, end):
    while start < end:
        if givenStr[start] != givenStr[end]:
            return False
        start += 1
        end -= 1
    return True

n = len(givenStr)
dp = [0] + [math.inf]*n

for i in range(1, n+1):
    for j in range(1, i+1):
        if isPalindrome(j-1, i-1):
            dp[i] = min(dp[i], dp[j-1] + 1)

print(dp[n])