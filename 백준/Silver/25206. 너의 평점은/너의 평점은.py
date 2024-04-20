import sys

graduation_dict = {'A+' : 4.5, 'A0' : 4.0, 'B+' : 3.5, 'B0' : 3.0, 'C+' : 2.5, 'C0' : 2.0, 'D+' : 1.5, 'D0' : 1.0, 'F' : 0.0}

sum = int()
allHour = int()

for _ in range(20) :
    inputString = sys.stdin.readline().strip().split(" ")
    if inputString[2] == 'P' :
        continue
    
    sum += graduation_dict.get(inputString[2]) * float(inputString[1])
    
    allHour += float(inputString[1])

avg = sum / allHour

print(round(avg, 6))
