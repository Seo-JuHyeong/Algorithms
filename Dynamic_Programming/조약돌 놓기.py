# 3×N 테이블의 각 칸에 양 또는 음의 정수가 기록되어 있다
# 조약돌을 놓는 방법 (제약 조건)
# 가로나 세로로 인접한 두 칸에 동시에 조약돌을 놓을 수 없다
# 각 열에는 적어도 하나 이상의 조약돌을 놓는다
# 목표: 돌이 놓인 자리에 있는 수의 합을 최대가 되도록 조약돌을 놓는다

n = 4
m = 4
arr = [ [5, 2, -1, 3],
        [-1, 8, -5, 0],
        [2, 3, 12, 7], ]

peb = [[0 for j in range(m)] for i in range(n)]
s = [[0 for j in range(m)] for i in range(n)]

for i in range(n):
    peb[i][0] = arr[0][i]
    peb[i][1] = arr[1][i]
    peb[i][2] = arr[2][i]
    peb[i][3] = arr[0][i] + arr[2][i]

for j in range(m):
    s[0][j] = peb[0][j]

for i in range(1, n):
    s[i][0] = max(s[i-1][1], s[i-1][2])+peb[i][0]
    s[i][1] = max(s[i-1][0], s[i-1][2], s[i-1][3]) + peb[i][1]
    s[i][2] = max(s[i-1][0], s[i-1][1]) + peb[i][2]
    s[i][3] = s[i-1][1] + peb[i][3]

print(max(s[n-1][0], s[n-1][1], s[n-1][2], s[n-1][3]))