def solution(n, words):
    answer = []
    
    history = list()
    
    history.append(words[0])
    
    cnt = 1
    
    for i in range(1, len(words)) :
        
        if words[i] in history or history[-1][-1] != words[i][0]:
            return [(i % n)+1, cnt]
        
        history.append(words[i])
        
        if (i+1) % n == 0 :
            cnt += 1
    
    return [0, 0]

