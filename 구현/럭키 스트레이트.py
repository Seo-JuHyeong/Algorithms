# 핵심 : 정수형 데이터가 입력으로 들어왔을 때, 이를 각 자릿수로 구분하여 합 계산
N = input()
mid = len(N) // 2

left = list(map(int, N[:mid]))
right = list(map(int, N[mid:]))

if sum(left) == sum(right):
    print("LUCKY")
else:
    print("READY")

# 입력
# 123402

# 출력
# LUCKY