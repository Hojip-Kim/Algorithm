import sys

givenExpression = input().split('-')

answer = 0
for i in givenExpression[0].split('+') :
    answer += int(i)
for i in givenExpression[1:]:
    for j in i.split('+'):
        answer -= int(j)
print(answer)