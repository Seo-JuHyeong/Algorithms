# 핵심 : 문자열의 길이(N)가 1,000 이하이므로 완전 탐색을 수행하여 1 ~ N/2 까지의 모든 수를 단위로 문자열을 압축하고 가장 짧게 압축되는 길이 출력

s = "aaaabbabbabb"

def solution(s):
    answer = len(s)
    # 1개 단위(step)부터 압축 단위를 늘려가며 확인
    for step in range(1, len(s) // 2 + 1):
        compressed = ""
        prev = s[0:step] # 앞에서부터 step만큼의 문자열 추출
        count = 1
        # 단위(step) 크기만큼 증가시키며 이전 문자열과 비교
        for j in range(step, len(s), step):
            # 이전 상태와 동일하다면 압축 횟수(count) 증가
            if prev == s[j:j + step]:
                count += 1
            # 다른 문자열이 나왔다면 (더 이상 압축하지 못하는 경우라면)
            else:
                # count >= 2 조건문을 통해, 이전 문자가 2번 이상 반복되었을 때만 압축
                compressed += str(count) + prev if count >= 2 else prev
                prev = s[j:j + step] # 다시 상태 초기화
                count = 1
        # 남아 있는 문자열에 대해서 처리
        compressed += str(count) + prev if count >= 2 else prev
        # 만들어지는 압축 문자열이 가장 짧은 것이 정답
        answer = min(answer, len(compressed))

    return answer

print(solution(s))

# 입력
# aaaabbabbabb

# 출력
# 7