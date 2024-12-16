# 문제 : 2019 국가 교육기관 코딩 테스트 
# 입력값 받고 문제 환경 세팅
N, M, K = map(int, input().split())
arr = list(map(int, input().split()))


# 매 시점마다 가장 큰 수를 k 번 연속 나열함
# 이때 그 이전의 값의 인덱스와 달라야함
arr.sort(reverse=True)
a = arr[0]
b = arr[1]

# k번 연속해서 가장 큰 수 나열, 그 이후에 한번만 두 번째로 큰 수 나열 
res, i = 0, 0
while True :
    if i == M : 
        break
    if i % (1+K) == 0 :
        res += b
    else : 
        res += a
    i += 1

# 결과 출력 
print(res)