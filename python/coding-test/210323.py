def binary_search(array, target, start, end):
    while start <= end:
        mid = (start + end) // 2
        if array[mid] == target:
            return mid
        # 중간점의 값보다 찾고자 하는 값이 작은 경우 왼쪽 확인
        elif array[mid] > target:
            end = mid - 1
        # 중간점의 값보다 찾고자 하는 값이 큰 경우 오른쪽 확인
        else:
            start = mid + 1


def seven_five():
    n = int(input())
    array = list(map(int, input().split()))
    array.sort()

    m = int(input())
    x = list(map(int, input().split()))

    for i in x:
        result = binary_search(array, i, 0, n - 1)
        if result != None:
            print('yes', end=" ")
        else:
            print('no', end=" ")


def seven_six():
    n = int(input())
    array = [0] * 1000001

    for i in input().split():
        array[int(i)] = 1

    m = int(input())
    x = list(map(int, input().split()))

    for i in x:
        if array[i] == 1:
            print('yes', end=' ')
        else:
            print('no', end=' ')


def seven_seven():
    n = int(input())
    array = set(map(int, input().split()))

    m = int(input())
    x = list(map(int, input().split()))

    for i in x:
        if i in array:
            print('yes', end=' ')
        else:
            print('no', end=' ')


# 떡의 개수(N)와 요청한 떡의 길이(M)을 입력받기
n, m = list(map(int, input().split()))
# 각 떡의 개별 높이 정보를 입력받기
array = list(map(int, input().split()))

# 이진 탐색을 위한 시작점과 끝점 설정
start = 0
end = max(array)

# 이진 탐색 수행(반복적)
result = 0
while start <= end:
    total = 0
    mid = (start + end) // 2
    for x in array:
        # 잘랐을 때의 떡의 양 계산
        if x > mid:
            total += x - mid
    # 떡의 양이 부족한 경우 더 많이 자르기(왼쪽 부분 탐색)
    if total < m:
        end = mid - 1
    # 떡의 양이 충분한 경우 덜 자르기(오른쪽 부분 탐색)
    else:
        result = mid  # 최대한 덜 잘랐을 때가 정답이므로, 여기에서 result에 기록
        start = mid + 1

print(result)
