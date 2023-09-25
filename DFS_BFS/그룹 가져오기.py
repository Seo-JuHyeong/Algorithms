# 니니즈 대학에 입학한 학생들은 각각 고유한 학번(ID)을 1 부터 n 까지 부여 받습니다.
# 처음에는 학생들끼리 서로를 잘 알지 못하고 각각 다른 친구들이 있습니다.
# 학기가 진행됨에 따라 다른 친구 그룹이 무작위로 형성되기 시작 합니다.
#
# 각각 색인으로 정렬된 세 개의 배열이 있습니다.
# 첫 번째 배열에는 Friend 또는 Total 이 될 queryType 이 포함됩니다.
# 다음 두 배열 students1 과 students2 에는 각각의 학생 학번(ID)이 포함 됩니다.
# queryType 이 Friend 이면 두 학생은 같은 친구 그룹이 됩니다.
# queryType 이 Total 인 경우 각 학생이 속한 친구 그룹의 친구 수 합계를 보여 줍니다.

#n=4
#q=3
#query = ['Friend', 'Friend', 'Total']
#student1 = [1,2,1]
#student2 = [2,3,4]

n = 3
q = 2
query = ['Friend', 'Total']
student1 = [1, 2]
student2 = [2, 3]


graph = [[] for i in range(n+1)]
answer = 0

def DFS(start, visited):
    visited.append(start)
    for node in graph[start]:
        if node not in visited:
            DFS(node, visited)
    return visited


for i in range(len(query)):
    if query[i] == 'Friend':
        graph[student1[i]].append(student2[i])
        graph[student2[i]].append(student1[i])
    else: #Total
        visited = []
        answer1 = len(DFS(student1[i], visited))

        visited = []
        answer2 = len(DFS(student2[i], visited))

        answer = answer1 + answer2

print(answer)