# 현재 나이트의 위치 입력받기
input_data = input()
row = int(input_data[1])
# 열(column) 변수는 체스판의 가로축 인덱스를 의미
# 가로축은 a부터 h까지 존재하므로, 인덱스값을 계산하기 위해 'a'의 아스키코드 값만큼 빼줌
# 해당 문제에서는 인덱스가 1부터 출발하므로 추가적으로 1을 더해줌.
column = int(ord(input_data[0])) - int(ord('a')) + 1

# 나이트가 이동할 수 있는 8가지 방향 정의
steps = [(-2, -1), (-1, -2), (1, -2), (2, -1), (2, 1), (1, 2), (-1, 2), (-2, 1)]

# 8가지 방향에 대하여 각 위치로 이동이 가능한지 확인
result = 0
for step in steps:
    # 이동하고자 하는 위치 확인
    next_row = row + step[0]
    next_column = column + step[1]
    # 해당 위치로 이동이 가능하다면 카운트 증가
    if next_row >= 1 and next_row <=8 and next_column >= 1 and next_column <= 8:
        result += 1

print(result)