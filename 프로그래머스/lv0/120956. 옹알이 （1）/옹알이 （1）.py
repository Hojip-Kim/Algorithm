

from dataclasses import replace

def solution(babbling):
    answer = 0
    
    str1 = ",".join(babbling)

    
    babble=("aya", "ye", "woo", "ma")
    for i in babble:
        str1 = str1.replace(i, "@")

    str1 = str1.replace("@", "")
    
    list = str1.split(",")
    
    for i in list : 
        if len(i) == 0 : answer += 1
        else : continue
    
    
    
    return answer