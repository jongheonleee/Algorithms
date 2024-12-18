# 입력값받고 환경 세팅
N, K = map(int, input().split())

count = 0
# N이 1이될 때까지 반복
    # K로 나누어 떨어지면, K로 나누기 
    # 그게 아니면 1빼기
    # 카운팅 해주기
while N != 1 : 
    N = N / K if N % K == 0 else N - 1
    count += 1
    
# 횟수 반환 
print(count)
