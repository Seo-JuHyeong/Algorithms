# 죠르디 섬의 한 도시에는 n 개의 집들이 일직선상에 세워져 있습니다.
# 각각의 집들은 1 부터 n 까지의 고유한번호로 식별 가능하며, 집에 부여되는 번호는 왼쪽부터 시작하여 오른쪽으로 갈수록 1 씩 증가합니다.
# 현재 이 도시에는 바이러스가 퍼져있으며, 이미 m 개의 집은 바이러스에 감염되었습니다.
# 바이러스에 감염된 집은, 아직 감염되지 않은 이웃한 집(왼쪽과 오른쪽에 위치한 집)들에 바이러스를 전파합니다.
# 예를 들어서, 만약 i 번째 날에 X 번 집이 바이러스에 감염되어 있다면, i+1 번째 날에는 X-1, X+1 번 집들에 바이러스가 전파됩니다.
# (이웃한 집이 이미 바이러스에 감염된 상태이면 바이러스는 전파되지 않습니다).
# 결과적으로 n 개의 모든 집들은 바이러스에 감염되게 됩니다.
# 바이러스에 감염되는 집들의 순서를 우리는 "바이러스감염 시퀀스" 라고 부릅니다.
#
# 양수 n 과 바이러스에 이미 감염되어있는 집들의 번호가 주어졌을 때, 가능한 모든 바이러스 감염 시퀀스의개수를 109+7 로 나눈 나머지 값을 구하세요.
# 주의: 감염된 집의 번호는 1부터 시작되는 인덱싱(1-based indexing)입니다.

n = 5
m = 2
infectedHouses = [1, 5]

#n= 6
#m=2
#infectedHouses=[3,5]

#n=4
#m=1
#infectedHouses=[1]

graph = [[] for i in range(n+1)]
visited = [0 for i in range(n+1)]
visitedNodeAtLevel = [[] for i in range(n+1)]
level = [0 for i in range(n+1)]
queue = []
maxLevel = 0
modular = pow(10, 9) + 7

for i in range(1, n+1):
    if i-1 >= 1:
        graph[i].append(i-1)
    if i+1 <= n:
        graph[i].append(i+1)

for i in range(m):
    queue.append(infectedHouses[i])
    visited[infectedHouses[i]]=1
    level[infectedHouses[i]]=0

while len(queue) > 0:
    curNode = queue.pop(0)
    for node in graph[curNode]:
        if visited[node] == 0:
            visited[node] = 1
            level[node] = level[curNode]+1
            visitedNodeAtLevel[level[node]].append(node)
            maxLevel = level[node]
            queue.append(node)

answer = 1

def fact(number):
    result = 1
    for i in range(1, number+1):
        result = ((result % modular)  * (i % modular)) % modular
    return result

for i in range(1, maxLevel+1):
    answer = ((answer % modular) * fact(len(visitedNodeAtLevel[i])))%modular

print(answer)
