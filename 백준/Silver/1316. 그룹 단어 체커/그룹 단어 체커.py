import sys

N = int(sys.stdin.readline())

answer = int() # answer

for _ in range(N) :
    string = sys.stdin.readline().strip()
    
    answer += 1
    
    for i in range(len(string)-1) :
        if string[i] == string[i+1] :
            continue
        else :
            if string[i] in string[i+1:] :
                answer -= 1
                break
print(answer)