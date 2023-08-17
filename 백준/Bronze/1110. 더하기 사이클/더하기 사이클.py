import sys

input = int(sys.stdin.readline())

inputTmp = input # 26

resultTmp = inputTmp // 10 + inputTmp % 10 # 2+6 => 8임.
backTmp = int()
result = (inputTmp%10 * 10) + resultTmp % 10 # 60 + 8 => 다음 수
inputTmp = result
cnt = 1

while True :
    if result == input :
        break
    
    resultTmp = inputTmp//10 + inputTmp%10
    result = (inputTmp%10 *10) + resultTmp % 10
    inputTmp = result
    cnt += 1
    
print(cnt)