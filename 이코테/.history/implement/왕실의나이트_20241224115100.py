# 입력값 받고 세팅
input = input()
count = 0

def input_to_pos(input : str) -> tuple : 
    """입력값을 좌표값으로 변환"""
    x, y = input[0], input[1]
    return (ord(x) - ord('a'), (int(y)-1)%8)

def is_includ_pos(x : int, y : int) -> bool :
    """범위내에 있는 좌표값 확인 """ 
    return 0 <= x <= 7 and 0 <= y <= 7

# 총 8개 지점으로 이동 - (-1, 2), (1, 2), (2, 1), (2, -1), (1, -2), (-1, -2), (-2, -1), (-2, 1)
dx = [-1, 1, 2, 2, 1, -1, -2, -2]
dy = [2, 2, 1, -1, -2, -2, -1, 1]

pos = input_to_pos(input)
for i in range(8) : 
    x, y = pos
    nx, ny = x + dx[i], y + dy[i]
    
    if is_includ_pos(nx, ny) : 
        count += 1
    


# 카운팅 값 반환하기 
print(count)
