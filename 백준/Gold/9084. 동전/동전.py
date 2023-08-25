import sys

T = int(sys.stdin.readline())


def func(coin, target) : # coinList = 튜플
    tmpDP = [0] * (target+1)
    tmpDP[0] = 1
    for coin1 in coin : # 코인이 1, 2가 있음.
        for j in range(1, target+1) : # 타겟은 1000
            if coin1 <= j : # 코인보다 j가 같거나 크면
                tmpDP[j] += tmpDP[j-coin1] # j-coin 참조
    return tmpDP[target]
    
    

for i in range(T) :
    num = int(sys.stdin.readline())
    coinList = map(int,sys.stdin.readline().split())
    target = int(sys.stdin.readline())
    print(func(coinList, target))