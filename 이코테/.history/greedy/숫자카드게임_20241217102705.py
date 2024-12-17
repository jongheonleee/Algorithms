# 입력값받고 환경 세팅
N, M = map(int, input().split())
arr2D = []

for _ in range(N) : 
    row = list(int, input().split())
    arr2D.append(row)


# 각 행을 순회하면서 최대값을 기록한다 
    # 각 행에서의 최소값을 선택한다
    # 이전에 기록된 최대값보다 큰 경우 최대값을 갱신한다
res = 0
for row in arr2D : 
    min = min(row)
    res = res if res > min else min
    
# 최대값을 출력한다 
print(res)