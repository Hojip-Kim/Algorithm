def solution(s):
    answer = 1
    
    str_list = list()
    
    for i in s :
        str_list.append(i)
        if len(str_list) > 1:
            if str_list[-2] == str_list[-1] :
                str_list.pop()
                str_list.pop()
    
    if len(str_list) != 0 :
        answer = 0
    
    return answer

solution("aabbac")