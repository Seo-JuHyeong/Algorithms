# 핵심 : 스테이지 번호(i)를 1부터 N까지 증가시키며, 해당 단계에 머물러 있는 플레이어들의 수(count)를 계싼
#       count 정보를 이용하여 모든 스테이지에 따른 실패율을 계산한 뒤에 내림차순으로 정렬
def solution(N, stages):
    answer = []
    length = len(stages)

    # 스테이지 번호를 1부터 N까지 증가시키며
    for i in range(1, N+1):
        # 해당 스테이지에 머물러 있는 사람의 수 계산
        count = stages.count(i)

        # 실패율 계산
        if length == 0:
            fail = 0
        else:
            fail = count / length

        # 리스트에 (스테이지 번호, 실패율) 원소 삽입
        answer.append((i, fail))
        length -= count

    # 실패율을 기준으로 각 스테이지를 내림차순 정렬
    answer = sorted(answer, key=lambda t: t[1], reverse=True)

    # 정렬된 스테이지 번호 출력
    answer = [i[0] for i in answer]
    return answer

N = 5
stages = [2, 1, 2, 6, 2, 4, 3, 3]
print(solution(N, stages))

# 입력
# 5
# [2, 1, 2, 6, 2, 4, 3, 3]

# 출력
# [3, 4, 2, 1, 5]