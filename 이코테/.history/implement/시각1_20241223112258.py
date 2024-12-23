# 입력값을 받고 세팅 
N = int(input())

MAX = N * 10000 + 5959
count = 0
# N:59:59 이전까지 반복한다
    # 시간을 업데이트한다
    # 3이 포함되어 있는지 확인한다
    # 3이 포함되어 있다면 카운팅 한다

def is_included_3(time) : # 3이 포함되었는지 확인함 
    # 문자열로 변환
    MARK = '3'
    
    # 반복문으로 3이 포함되었는지 확인함
    for ch in time : 
        if ch == MARK : 
            return True
        
    return False
    
for i in range(N+1) : 
    for j in range(60) : 
        for z in range(60) : 
            time = str(i) + str(j) + str(z)
            print(time)
            
            if is_included_3(time) : 
                count += 1


# 총 카운팅을 반환한다 
print(count)