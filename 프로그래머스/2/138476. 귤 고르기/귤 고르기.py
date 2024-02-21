

def solution(k, tangerine):
    dict = {}
    answer = 0
    for tan in tangerine :
        if tan in dict :
            dict[tan] += 1
        else :
            dict[tan] = 1
    
    sortedDict = sorted(dict.items(), key=lambda x: x[1], reverse=True)
    
    for a,b in sortedDict :
        k -= b
        if k > 0 :
            answer += 1
            continue
        else :
            answer += 1
            break
        
    return answer
