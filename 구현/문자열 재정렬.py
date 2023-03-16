# 핵심 : 문자를 하나씩 확인한 뒤에, 숫자인 경우 따로 합계를 계산하고, 알파벳인 경우 별도의 리스트에 저장하여 오름차순 정렬
data = input()
result = []
value = 0

# 문자를 하나씩 확인하며
for x in data:
    # 알파벳인 경우 결과 리스트 삽입
    if x.isalpha():
        result.append(x)
    # 숫자는 따로 더하기
    else:
        value += int(x)

# 알파벳을 오름차순으로 정렬
result.sort()

# 숫자가 하나라도 존재하는 경우 가장 뒤에 삽입
if value != 0:
    result.append(str(value))

# 최종 결과 출력(리스트를 문자열로 변환하여 출력)
print("".join(result))

# 입력
# K1KA5CB7

# 출력
# ABCKK13