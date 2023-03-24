# 핵심 : 파이썬에서는 튜플을 원소로 하는 리스트가 있을 때, 그 리스트를 정렬하면 기본적으로 각 튜플을 구성하는 원소의 순서에 맞게 정렬
#       또한 리스트의 원소를 정렬할 때는 sort() 함수의 key 속성에 값을 대입하여 내가 원하는 '조건'에 맞게 튜플을 정렬시킬 수 있음
n = int(input())
students = [] # 학생 정보를 담을 리스트

# 모든 학생 정보를 입력받기
for _ in range(n):
    students.append(input().split())

# [정렬 기준]
# 1) 두 번째 원소를 기준으로 내림차순 정렬
# 2) 두 번째 원소가 같은 경우, 세 번째 원소를 기준으로 오름차순 정렬
# 3) 세 번째 원소가 같은 경우, 네 번째 원소를 기준으로 내림차순 정렬
# 4) 네 번째 원소가 같은 경우, 첫 번째 원소를 기준으로 오름차순 정렬

students.sort(key=lambda x: (-int(x[1]), int(x[2]), -int(x[3]), x[0]))

# 정렬된 학생 정보에서 이름만 추출
for student in students:
    print(student[0])

# 입력
# 12
# Junkyu 50 60 100
# Sangkeun 80 60 50
# Sunyoung 80 70 100
# Soong 50 60 90
# Haebin 50 60 100
# Kangsoo 60 80 100
# Donghyuk 80 60 100
# Sei 70 70 70
# Wonseob 70 70 90
# Sanghyun 70 70 80
# nsj 80 80 80
# Minjae 50 60 90

# 출력
# Donghyuk
# Sangkeun
# Sunyoung
# nsj
# Wonseob
# Sanghyun
# Sei
# Kangsoo
# Haebin
# Junkyu
# Soong
# injae