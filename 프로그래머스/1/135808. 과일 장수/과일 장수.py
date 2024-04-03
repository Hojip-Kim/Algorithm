def solution(k, m, score):
    answer = 0
    
    score.sort(reverse=True)
    
    n = len(score) // m
    
    for i in range(n) :
        tmp = []
        for j in range(m) :
            tmp.append(score[j+(m*i)])
    
        if len(tmp) == m :
            answer += min(tmp) * m
    
    return answer