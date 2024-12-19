# 입력값받고 환경 세팅
N = int(input())
moves = input().split()

# 이동 계획에 다른 좌표값 처리 세팅
dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]
move_types = ['L', 'R', 'U', 'D']

# 각 이동 계획 순회한다
    # 이동 좌표를 계산한다
    # 유효 범위이면 이동한다
    # 그렇지 않으면 이동하지 않고 스킵한다

x, y = 1, 1

for move in moves : 
    for i in range(len(move_types)) : 
        if move_types[i] != move : 
            continue
        
        nx, ny = x + dx[i], y + dy[i]
        
        if 1 > nx or nx > N or 1 > ny or ny > N : 
            continue
            
        x, y = nx, ny

# 최종 위치를 반환한다 
print(x, y)