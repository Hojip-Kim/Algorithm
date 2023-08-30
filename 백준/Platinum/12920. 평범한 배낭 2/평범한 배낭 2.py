import sys

N, M = map(int,sys.stdin.readline().split()) # N = 집에있는 물건의 종류 수, M = 최대 들 수 있는 무게, 

dp = [0] * (M+1) # M = 3이라면 0, 1, 2, 3으로 DP테이블 구성 => 무게에 따른 가치를 매길것임.

weight = []
value = []

for _ in range(N):
    V, C, K = map(int, input().split())

    idx = 1
    while K > 0:
        tmp = min(idx, K)

        weight.append(V * tmp)
        value.append(C * tmp)

        idx *= 2
        K -= tmp

for i in range(len(weight)):
    for j in range(M, weight[i]-1, -1):
        dp[j] = max(dp[j], dp[j-weight[i]] + value[i])

print(dp[M])