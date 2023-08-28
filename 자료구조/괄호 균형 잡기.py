# '('와 ')'라는 두 가지 유형의 문자로만 구성된 문자열이 주어집니다,
# '(' 또는 ')'를 필요한 만큼 삽입하여 괄호의 균형을 맞춥니다.
# 삽입해야 하는 최소 문자 수를 결정합니다.

s = "(()())("
stack = []
answer = 0

for i in range(len(s)):
    if s[i] == '(':
        stack.append(s[i])

    if s[i] == ')':
        if len(stack) == 0:
            answer += 1
        elif stack[-1] == '(':
            stack.pop()

print(answer + len(stack))