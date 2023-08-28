# 앙몬드는 가진 문자열 s를 이용하여 아래 규칙에 따라 새 문자열 b를 만들기로 합니다.
# 문자열 b는 초기에 빈 문자열입니다.
# 1부터 증가하는 i 에 대해 (1 ≤ i ≤ |s|, |s|는 문자열 s의 길이):
#
# -	문자열 b 끝에 문자 s[i-1]을 추가합니다.
# -	문자열 b를 뒤집습니다.
#
# 문자열 b를 만들기 전에, 문자열 b가 사전식 순서로 최댓값을 가질 수 있도록 앙몬드가 가진 문자열 s를 재배열하세요.

s = "1001"
arr = []
answer = []

for i in range(len(s)):
    arr.append(s[i])

arr.sort(reverse=True)

type = 1 # 1이면 앞에서 뺀다

while(len(arr) >= 1):
    if type == 1:
        answer.insert(0, arr.pop(0))
        type = 0
    else:
        answer.insert(0, arr.pop())
        type = 1

print(''.join(answer)) 