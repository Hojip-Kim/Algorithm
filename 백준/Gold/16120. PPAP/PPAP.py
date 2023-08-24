import sys

givenString = sys.stdin.readline().strip()

stack = []

tmpStr = ''
for i in givenString :
    if len(stack) >= 4 and stack[-4] +stack[-3] + stack[-2] + stack[-1] == 'PPAP' :
        for _ in range(4) :
            stack.pop()
        stack.append('P')
    stack.append(i)


if  len(stack) == 4 and stack[-4]+stack[-3]+stack[-2]+stack[-1] == 'PPAP'  or len(stack) == 1 and stack[0] == 'P'  :
    print('PPAP')
else :
    print('NP')