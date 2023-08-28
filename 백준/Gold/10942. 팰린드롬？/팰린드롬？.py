import sys

N = int(sys.stdin.readline())

numList = list(map(int,sys.stdin.readline().split()))

questionNum = int(sys.stdin.readline())

#dp
dp = [[0] * N for _ in range(N)]


for numLength in range(N):
    for start in range(N - numLength):
        end = start + numLength
        
        # 시작점과 끝점이 같다면 글자수가 1개이므로 무조건 팰린드롬
        if start == end:
            dp[start][end] = 1
        # 시작점의 글자와 끝점의 글자가 같다면
        elif numList[start] == numList[end]:
        	# 두 글자짜리 문자열이라면 무조건 팰린드롬
            if start + 1 == end: dp[start][end] = 1
            # 가운데 문자열이 팰린드롬이라면 팰린드롬
            elif dp[start+1][end-1] == 1: dp[start][end] = 1
            

for question in range(questionNum):
    s, e = map(int,sys.stdin.readline().split())
    print(dp[s-1][e-1])