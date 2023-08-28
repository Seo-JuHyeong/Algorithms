# 두 축구팀이 한 리그에서 넣은 골의 개수가 두개의 배열 형태로 주어집니다.
# 팀 베로니(teamB)가 진행한 각각의 경기에 대해서, 팀 케로(teamK)가 획득한 골의 개수가 팀 베로니가 획득한 골의 개수보다 적거나 같은 경기 횟수를 계산하세요.

# Constraints
# 2 ≤ n, m ≤ 105
# 1 ≤ teamK[j] ≤ 109, where 0 ≤ j < n.
# 1 ≤ teamB[i] ≤ 109, where 0 ≤ i < m.

# 즉, 이중 for문으로 구현 시 계산량이 10^10이 되어 1억(10^8) 보다 크므로 시간 초과가 발생한다.
# log(n)의 풀이인 이진 탐색 알고리즘이 필요하다.

teamK = [1, 4, 2, 4]
teamB = [3, 5]
answer = []
teamK.sort()

for score in teamB:
    low = 0
    high = len(teamK) - 1

    while low <= high:
        mid = (low + high) // 2
        if teamK[mid] > score:
            high = mid - 1
        else:
            low = mid + 1
    answer.append(low)

print(answer)