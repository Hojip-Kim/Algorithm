import sys

T = int(sys.stdin.readline())

K = int(sys.stdin.readline())

dp = [0]*(T+1)
dp[0] = 1
coinList = []
for i in range(K) :
    coin, n = map(int,sys.stdin.readline().split()) # 5, 3 / 10, 2/ 1, 5
    coinList.append((coin, n))

coinList.sort() # 1, 5 / 5, 3 / 10, 2
for coin, cnt in coinList : # 1 5
    for i in range(T, -1, -1) : # 목표금액부터 내려오면서
        for j in range(1, cnt + 1) : # 사용할 동전의 개수만큼 반복시킨다.
            if i - coin * j < 0 :
                break
            dp[i] += dp[i - coin * j]

print(dp[T])