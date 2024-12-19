# 입력값받고 환경 세팅
N = int(input())
moves = input().split()

# 유효범위 확인 메서드 - 이동 위치가 지도 범위내에 있는지 확인 
def is_valid_range(pos) : 
    curr_x, curr_y = pos
    return 1 <= curr_x <= N and 1 <= curr_y <= N

# 이동 계획에 따른 좌표값 변환해주는 메서드 - 이동 계획 문자를 좌표값으로 변환 
def convert_pos(move) : 
    if move == 'L' : 
        return (0, -1)
    elif move == 'R' : 
        return (0, 1)
    elif move =='U' :
        return (-1, 0)
    elif move == 'D' : 
        return (1, 0)
    else : 
        raise ValueError("잘못된 이동 계획입니다.")

# 다음 위치로 이동하는 메서드 - 다음 위치로 계산
def move_pos(pos, next_pos) : 
    return (pos[0] + next_pos[0], pos[1] + next_pos[1])

# 지도 구현없이 풀이
# 시작지점 세팅
    # 입력으로 주어진 계획서를 각각 순회한다
        # 계획서 하나를 조회한다
        # 유효범위 내에 있는지 확인한다
            # 유효범위 내에 있다면 이동하고 위치를 업데이트한다
            # 유효범위 냐에 없다면 이동하지 않는다 
pos = (1, 1)

for move in moves : 
    next_pos = convert_pos(move)
    new_pos = move_pos(pos, next_pos)
    pos = new_pos if is_valid_range(new_pos) else pos
    

# 최종적으로 현재 위치를 반환한다 
print(*pos)
