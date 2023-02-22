# 정수 N, M을 입력받기
n, m = map(int, input().split())
# N개의 화폐 단위 정보를 입력받기
array = []
for i in range(n):
    array.append(int(input()))

# 한 번 계산된 결과를 저장하기 위한 DP 테이블 초기화
d = [10001] * (m + 1)

# 금액 i를 만들 수 있는 최소한의 화폐 개수 -> a[i]
# 화폐의 단위 -> k
# 금액 (i-k)를 만들 수 있는 최소한의 화폐 개수 -> a[i - k]
# 판정식
# a[i - k]를 만드는 방법이 존재하는 경우. a[i] = min(a[i], a[i-k] + 1)
# a[i - k]를 만드는 방법이 존재하지 않는 경우. a[i] = 10,001
# 10,001은 특정 금액을 만들 수 있는 화폐 구성이 가능하지 않다는 의미
# 다이나믹 프로그래밍(Dynamic Programming) 진행 (보텀업)
d[0] = 0
for i in range(n):
    for j in range(array[i], m + 1):
        if d[j - array[i]] != 10001:  # (i - k)원을 만드는 방법이 존재하는 경우
            d[j] = min(d[j], d[j - array[i]] + 1)

# 계산된 결과 출력
if d[m] == 10001:  # 최종적으로 M원을 만드는 방법이 없는 경우
    print(-1)
else:
    print(d[m])

# 입력
# 2 15
# 2
# 3

# 출력
# 5