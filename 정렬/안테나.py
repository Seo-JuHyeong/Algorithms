# 핵심 : 정확히 중간값에 해당하는 위치의 집에 안테나를 설치했을 때, 안테나로부터 모든 집까지의 거리의 총합이 최소가 됨
n = int(input())
data = list(map(int, input().split()))

data.sort()

# 중간값(median)을 출력
print(data[(n - 1) // 2])

# 입력
# 4
# 5 1 7 9

# 출력
# 5