# 병합 정렬 기반으로 동작
# 시간 복잡도 : O(NlogN) 보장

array = [7, 5, 9, 0, 3, 1, 6, 2, 4, 8]

result = sorted(array)  # 정렬된 결과를 리스트 자료형으로 반환
print(result)

array.sort()  # 별도의 정렬된 리스트를 반환하지 않고 내부 원소가 바로 정렬
print(array)

array = [('바나나', 2), ('사과', 5), ('당근', 3)]  # 튜플로 구성된 리스트


def setting(data):  # 데이터의 두 번째 원소를 기준으로 설정
    return data[1]


result = sorted(array, key=setting)
print(result)