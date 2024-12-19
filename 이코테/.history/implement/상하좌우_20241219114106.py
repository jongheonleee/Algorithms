# 입력값받고 환경 세팅
N = int(input())

# 유효범위 확인 메서드 
def is_valid_position(pos) : 
    curr_x, curr_y = pos
    return True if 1 <= curr_x <= N and 1 <= curr_y <= N else False

# 지도 구현없이 풀이
# 시작지점 세팅
    # 입력으로 주어진 계획서를 각각 순회한다
        # 계획서 하나를 조회한다
        # 유효범위 내에 있는지 확인한다
            # 유효범위 내에 있다면 이동하고 위치를 업데이트한다
            # 유효범위 냐에 없다면 이동하지 않는다 

pos = (1, 1)


# 최종적으로 현재 위치를 반환한다 
