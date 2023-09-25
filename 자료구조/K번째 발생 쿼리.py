# 앙몬드에게 정수형 배열 arr, indexes 와 정수 X 가 주어집니다.
# 각 i 번째 indexes 항목에 대해, arr 에서 indexes[i] 번째 X 가 발생한 인덱스를 배열로 반환하세요.
# indexes[i] 번째 항목이 존재하지 않는 경우 해당 결과는 -1 입니다.
# 주의: 반환될 배열은 1부터 시작되는 인덱싱(1-based indexing)이어야 합니다.

x = 8
arr = [1, 2, 20, 8, 8, 1, 2, 5, 8, 0]
indexes = [100, 2, 1, 3, 4]

answer = {}
k = 0

for i in range(len(arr)):
    if arr[i] == x:
        k = k+1
        answer[k] = i+1

for i in range(len(indexes)):
    try:
        print(answer[indexes[i]])
    except KeyError:
        print(-1)