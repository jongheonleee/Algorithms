# 입력값을 받고 세팅 
N = int(input())

MAX = N * 10000 + 5959
# N:59:59 이전까지 반복한다
    # 시간을 업데이트한다
    # 3이 포함되어 있는지 확인한다
    # 3이 포함되어 있다면 카운팅 한다
    
def update_time(time) : # 시간을 업데이트함 
    pass

def is_included_3(time) : # 3이 포함되었는지 확인함 
    # 문자열로 변환
    time_str = time + ''
    MARK = '3'
    
    # 반복문으로 3이 포함되었는지 확인함
    for ch in time_str : 
        if ch == MARK : 
            return True
        
    return False
    
    


# 총 카운팅을 반환한다 