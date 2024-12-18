# 입력값받고 횐경 세티
N = int(input())
count = 0

# 동전 시퀀스 역정렬
coins = [500, 100, 50, 10]

# 가장 큰 동전부터 나누기
    # N이 0인 경우 반복문 탈출
    # 그게 아니고 나눌수 있는 경우면 계산해주기
        # 몫, 나머지 구하기
        # N 값 업데이트 
        # count에 몫만큼 더하기
for coin in coins : 
    if N == 0 : break
    
    if coin < N : 
        r, N = divmod(N, coin)
        print(coin)
        print(r)
        count += r
        
        
    

# 최소 개수 반환 
print(count)
    