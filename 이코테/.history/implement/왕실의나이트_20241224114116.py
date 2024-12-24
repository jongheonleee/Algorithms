# 입력값 받고 세팅
input = input()

# 입력값을 좌표값으로 변환
def input_to_pos(input : str) -> tuple : 
    x, y = input[0], input[1]
    return (ord(x) - ord('a'), (int(y)-1)%8)

# 총 8개 지점으로 이동

# 범위내에 있는 좌표값 카운팅

# 카운팅 값 반환하기 