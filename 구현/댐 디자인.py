# 회사에서 작은 호수를 만들기 위해 하천을 가로질러 댐을 건설할 계획을 세우고 있습니다.
# 재료비를 줄이기 위해 댐은 콘크리트 벽 사이에 진흙을 채운 하나 이상의 콘크리트 벽으로 만들어질 것입니다.
# 다음을 사용하여 댐의 진흙 세그먼트의 최대 높이를 결정합니다.

# 벽 사이의 간격의 1단위 너비에는 포장된 진흙 세그먼트 하나가 포함됩니다.
# 세그먼트의 진흙 높이는 인접한 벽이나 진흙 세그먼트보다 1단위를 초과할 수 없습니다.
# 여러 벽의 배치와 높이가 주어졌을 때, 건설할 수 있는 진흙 세그먼트의 최대 높이를 결정합니다. 진흙 세그먼트를 만들 수 없으면 0을 반환합니다.

wallPositions = [1, 2, 4, 7]
wallHeights = [4, 6, 8, 11]

answer = -1

for i in range(len(wallPositions)-1):
    k = wallPositions[i+1] - wallPositions[i]
    h = abs(wallHeights[i+1] - wallHeights[i])

    if h > k:
        answer = max(answer, 0)
    elif h == k:
        answer = max(answer, max(wallHeights[i+1], wallHeights[i]) - 1)
    else:
        if (k-h-1) % 2 == 0:
            answer = max(answer, max(wallHeights[i+1], wallHeights[i]) + (k-h-1)//2)
        else:
            answer = max(answer, max(wallHeights[i+1], wallHeights[i]) + (k-h-1)//2 + 1)

print(answer)