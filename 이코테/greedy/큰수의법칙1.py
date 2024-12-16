# 문제 : 2019 국가 교육기관 코딩 테스트 
# 입력값 받고 문제 환경 세팅
N, M, K = map(int, input().split())
arr = list(map(int, input().split()))


# 매 시점마다 가장 큰 수를 k 번 연속 나열함
# 이때 그 이전의 값의 인덱스와 달라야함
arr.sort(reverse=True)
a = arr[0]
b = arr[1]

res = 0
if a == b : # - 1. 가장 큰 수와 두 번째로 큰 수가 같은 경우
    c = M//K 
    d = M%K
    res = K*c*a + d*a
else : # - 2. 가장 큰 수와 두 번째로 큰 수가 다른 경우
    c = M//(K+1)
    d = M%(K+1)
    res = (K*a+1*b)*c + d*a

# 결과 출력 
print(res)