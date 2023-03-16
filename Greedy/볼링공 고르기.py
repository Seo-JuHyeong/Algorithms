# 핵심 : 무게마다 볼링공이 몇 개 있는지 계산 후 A가 특정한 무게의 볼링공을 선택했을 때,
#       이어서 B가 볼링공을 선택하는 경우를 차례대로 계산
n, m = map(int, input().split())
data = list(map(int, input().split()))

# 1부터 10까지의 무게를 담을 수 있는 리스트
array = [0] * 11

for x in data:
    # 각 무게에 해당하는 볼링공의 개수 카운트
    array[x] += 1

result = 0
# 1부터 m까지의 각 무게에 대하여 처리
for i in range(1, m + 1):
    n -= array[i] # 무게가 i인 볼링공의 개수(A가 선택할 수 있는 개수) 제외
    result += array[i] * n # B가 선택하는 경우의 수와 곱하기

print(result)

# 입력
# 5 3
# 1 3 2 3 2

# 출력
# 8