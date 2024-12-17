# 입력값받고 환경 세팅
N, M = map(int, input().split())

res = 0
# 각 로우를 입력받을 때 부터 계산하기
    # 각 로우 중에서 최소값을 기록
    # 이전에 기록한 최대값보다 큰 경우 최대값을 갱신한다

for _ in range(N) : 
    row = list(map(int, input().split()))
    tmp = min(row)
    res = res if res > tmp else tmp

# 결과를 출력한다 
print(res)