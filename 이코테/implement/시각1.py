# 입력값을 받고 세팅 
N = int(input())
count = 0

# N:59:59 이전까지 반복한다
    # 시간을 업데이트한다
    # 3이 포함되어 있는지 확인한다
    # 3이 포함되어 있다면 카운팅 한다
for i in range(N+1) : 
    for j in range(60) : 
        for z in range(60) : 
            time = str(i) + str(j) + str(z)
            
            if '3' in time : 
                count += 1



# 총 카운팅을 반환한다 
print(count)