# 입력값받고 횐경 세티
N = int(input())
count = 0

# 동전 시퀀스 역정렬
coins = [500, 100, 50, 10]

# N이 0이될 때까지 반복
    # 가장 큰 동전부터 나누기 
        # N 값 업데이트 
        # 최소 개수 카운팅(몫만큼 더해주기)
for coin in coins : 
    if coin < N : 
        r = N / coin
        count += r
        N = N % coin 
        
        
    

# 최소 개수 반환 
print(count)
    