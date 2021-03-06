array = [7, 5, 9, 0, 3, 1, 6, 2, 4, 8]


def selection_sort():
    for i in range(len(array)):
        min_index = i
        for j in range(i + 1, len(array)):
            if array[min_index] > array[j]:
                min_index = j
        array[i], array[min_index] = array[min_index], array[i]  # 스

    print(array)


def insertion_sort():
    for i in range(1, len(array)):
        for j in range(i, 0, -1):
            if array[j] < array[j - 1]:
                array[j], array[j - 1] = array[j - 1], array[j]
            else:
                break

    print(array)


def quick_sort(array, start, end):
    if start >= end:  # 원소가 1개인 경우 종료
        return
    pivot = start  # 피벗은 첫 번째 원소
    left = start + 1
    right = end
    while left <= right:
        # 피벗보다 큰 데이터를 찾을 때까지 반복
        while left <= end and array[left] <= array[pivot]:
            left += 1
        while right > start and array[right] >= array[pivot]:
            right -= 1
        if left > right:  # 엇갈렸다면 작은 데이터와 피벗을 교체
            array[right], array[pivot] = array[pivot], array[right]
        else:
            array[left], array[right] = array[right], array[left]
    # 분할 이후 왼쪽 부분과 오른쪽 부분에서 각각 정렬 수행
    quick_sort(array, start, right - 1)
    quick_sort(array, right + 1, end)


# quick_sort(array, 0, len(array) - 1)

def quick_sort2(array):
    # 리스트가 하나 이하의 원소만을 담고 있다면 종료
    if len(array) <= 1:
        return array
    pivot = array[0]  # 피벗은 첫 번째 원소
    tail = array[1:]  # 피벗을 제외한 리스트

    left_side = [x for x in tail if x <= pivot]  # 분할된 왼쪽 부분
    right_side = [x for x in tail if x > pivot]  # 분할된 오른쪽 부분

    # 분할 이후 왼쪽 부분과 오른쪽 부분에서 각각 정렬을 수행하고, 전체 리스트를 반환
    return quick_sort2(left_side) + [pivot] + quick_sort2(right_side)


# print(quick_sort2(array))

array = [7, 5, 9, 0, 3, 1, 6, 2, 9, 1, 4, 8, 0, 5, 2]


def count_sort(array):
    # 모든 범위를 포함하는 리스트 선언(모든 값은 0으로 초기화)
    count = [0] * (max(array) + 1)

    for i in range(len(array)):
        count[array[i]] += 1  # 각 데이터에 해당하는 인덱스의 값 증가

    for i in range(len(count)):  # 리스트에 기록된 정렬 정보 확인
        for j in range(count[i]):
            print(i, end=' ')  # 띄어쓰기를 구분으로 등장한 횟수만큼 인덱스 출력


# print(sorted(array))

array = [('바나나', 2), ('사과', 5), ('당근', 3)]


def setting(data):
    return data[1]


# result = sorted(array, key=setting)
# print(result)

def factorial(n):
    if n < 2:
        return 1
    return n * factorial(n - 1)


def fibonacci(n, max, v1, v2):
    if max == n:
        return v1

    return fibonacci(n, max + 1, v2, v1 + v2)


# n = int(input())

# print(fibonacci(n, 0, 0, 1))

# 순차 탐색 소스코드 구현
def sequential_search(n, target, array):
    # 각 원소를 하나씩 확인하며
    for i in range(n):
        # 현재의 원소가 찾고자 하는 원소와 동일한 경우
        if array[i] == target:
            return i + 1


def test_sequential_search():
    print("생성할 원소 개수를 입력한 다음 한 칸 띄고 찾을 문자열을 입력하세요.")
    input_data = input().split()
    n = int(input_data[0])  # 원소의 개수
    target = input_data[1]  # 찾고자 하는 문자열

    print("앞서 적은 원소 개수만큼 문자열을 입력하세요. 구분은 띄어쓰기 한 칸으로 합니다.")
    array = input().split()

    # 순차 탐색 수행 결과 출력
    print(sequential_search(n, target, array))


# 이진 탐색 소스코드 구현(재귀 함수)
def binary_search(array, target, start, end):
    if start > end:
        return None
    mid = (start + end) // 2
    # 찾은 경우 중간점 인덱스 반환
    if array[mid] == target:
        return mid
    # 중간점의 값보다 찾고자 하는 값이 작은 경우 왼쪽 확인
    elif array[mid] > target:
        return binary_search(array, target, start, mid - 1)
    # 중간점의 값보다 찾고자 하는 값이 큰 경우 오른쪽 확인
    else:
        return binary_search(array, target, mid + 1, end)


def binary_search2(array, target, start, end):
    while start <= end:
        mid = (start + end) // 2
        if array[mid] == target:
            return mid
        elif array[mid] > target:
            end = mid - 1
        else:
            start = mid + 1

    return None


def test_binary_search():
    # n(원소의 개수)과 target(찾고자 하는 문자열)을 입력받기
    n, target = list(map(int, input().split()))
    # 전체 원소 입력받기
    array = list(map(int, input().split()))

    # 이진 탐색 수행 결과 출력
    # result = binary_search(array, target, 0, n - 1)
    result = binary_search2(array, target, 0, n - 1)
    if result == None:
        print("원소가 존재하지 않습니다.")
    else:
        print(result + 1)


# test_binary_search()
vocab = {
    # 코드를 입력하세요.
    'sanitizer': '살균제',
    'ambition': '야망',
    'conscience': '양심',
    'civilization': '문명',
}
vocab['privilege'] = '특권'
vocab['principle'] = '원칙'
# vocab.update({'privilege': '특권', 'principle': '원칙'})

word = '토마토마'

print(word == word[::-1])


def is_palindrome(word):
    for left in range(len(word) // 2):
        right = len(word) - left - 1
        if word[left] != word[right]:
            return False

    return True


print(word[::-1])
