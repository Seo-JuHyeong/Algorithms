# N, M, K를 공백으로 구분하여 입력받기
n, m, k = map(int, input().split())

# N개의 수를 공백으로 구분하여 입력받기
data = list(map(int, input().split()))

data.sort()  # 입력받은 수들 정렬하기

first = data[n - 1]  # 가장 큰 수
second = data[n - 2]  # 두 번째로 큰 수

"""
result = 0

while True:
    for i in range(k):  # 가장 큰 수를 k번 더하기
        if m == 0:  # m이 0이라면 반복문 탈출
            break
        result += first
        m -= 1  # 더할 때마다 1씩 빼기
    if m == 0:  # m이 0이라면 반복문 탈출
        break
    result += second  # 두 번째로 큰 수를 한 번 더하기
    m -= 1  # 더할 때마다 1씩 빼기
"""

#  better code
#  가장 큰 수가 더해지는 횟수 계산
#  반복되는 수열의 길이 => k + 1
#  수열이 반복되는 횟수 => M을 (k + 1)로 나눈 몫
#  큰 수가 등장하는 횟수 => {M을 (k + 1)로 나눈 몫} * K
count = int(m / (k + 1)) * k

#  M이 (k + 1)로 나누어 떨어지지 않는 경우를 고려
count += m % (k + 1)  # 나머지만큼 추가로 덧셈

result = 0
result += (count) * first  # 가장 큰 수 더하기
result += (m - count) * second  # 두 번째로 큰 수 더하기

print(result)  # 최종 답안 출력