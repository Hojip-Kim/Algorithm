import sys

n = int(sys.stdin.readline())

givenList = [[]for _ in range(n+1)]

isVisited = [False] * (n+1)

a, b = map(int,sys.stdin.readline().split())

m = int(sys.stdin.readline())

for i in range(m) :
    x, y = map(int,sys.stdin.readline().split())
    givenList[x].append(y)
    givenList[y].append(x)

def dfs(x, target, depth) :
    isVisited[x] = True
    if x == target :
        return depth
    
    for i in givenList[x] :
        if isVisited[i] == False :
            result = dfs(i, target, depth+1)
            if result != -1 :
                return result
    
    return -1

result = dfs(a, b, 0)


if result == -1 :
    print(-1)
else :
    print(result)