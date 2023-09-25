def solution(answers):
    answer = []

    pattern = [
        [1, 2, 3, 4, 5],
        [2, 1, 2, 3, 2, 4, 2, 5],
        [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    ]

    scores = [0] * 3

    for i in range(3):
        for j in range(len(answers)):
            if pattern[i][j % len(pattern[i])] == answers[j]:
                scores[i] += 1

    max_score = max(scores)

    for i, score in enumerate(scores):
        if score == max_score:
            answer.append(i + 1)

    return answer


# 입력
# [1,2,3,4,5]
# 출력
# [1]

# 입력
# [1,3,2,4,2]
# 출력
# [1,2,3]