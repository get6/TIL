n = 1260
count = 0

coin_types = [500, 100, 50, 10]

for coin in coin_types:
    count += n // coin
    n %= coin


# print(count)

def nmkF():
    # N, M, K를 공백으로 구분하여 입력받기
    # N = 배열의 크기, M = 숫자가 더해지는 횟수, K = 반복 가능한 횟수
    n, m, k = map(int, input().split())
    # N개의 수를 공백으로 구분하여 입력받기
    data = list(map(int, input().split()))

    data.sort(reverse=True)
    first = data[n - 1]  # 가장 큰 수
    second = data[n - 2]  # 두번째로 큰 수

    result = 0

    # While True인 이유는 가장 큰 값만 더하고 싶은데
    # 가장 큰 값은 조건으로 K 반복 할 수 있기 때문에
    # K번이 끝나고 한 번은 두번째로 큰 값을 더하고 다시 K번으 큰 값을 더하는 반복을 시작한다.
    while True:
        for i in range(k):  # 가장 큰 수를 K번 더하기
            if m == 0:  # m이 0이라면 반복문 탈출
                break
            result += first
            m -= 1
        if m == 0:  # m이 0이라면 반복문 탈출
            break
        result += second  # 두 번째로 큰 수를 한 번 더하기
        m -= 1  # 더할 때마다 1씩 빼기

    print(result)


# for i in range(2, 10):
#     for j in range(1, 10):
#         print(i, "X", j, "=", i * j)
#     print()

import sys

# p = sys.stdin.readline()
# print(p)
# print(p.rstrip())

result = sorted([('홍길동', 35), ('이순신', 75), ('아무개', 50)], key=lambda x: x[1], reverse=True)

from itertools import permutations, combinations, product, combinations_with_replacement

data = ['A', 'B', 'C']

# 모든 순열 구하기
result = list(permutations(data, 2))
print(result)
# 2개를 뽑는 모든 조합 구하기
result = list(combinations(data, 2))
print(result)
# 2개를 뽑는 모든 순열 구하기(중복 허용)
result = list(product(data, repeat=2))
print(result)
# 2개를 뽑는 모든 조합 구하기(중복 허용)
result = list(combinations_with_replacement(data, 2))
print(result)

import heapq


def heapsort(iterable):
    h = []
    result = []
    # 모든 원소를 차례대로 힙에 삽입
    for value in iterable:
        # heapq.heappush(h, value)
        heapq.heappush(h, -value)
    # 힙에 삽입된 모든 원소를 차례대로 꺼내어 담기
    for i in range(len(h)):
        # result.append(heapq.heappop(h))
        result.append(-heapq.heappop(h))
    return result


result = heapsort([1, 3, 5, 7, 9, 2, 4, 6, 8, 0])
print(result)

from bisect import bisect_right, bisect_left

a = [1, 2, 4, 4, 8]
x = 4
print(bisect_left(a, x))  # 정렬된 순서를 유지하면서 리스트 a에 데이터 x를 삽입할 가장 왼쪽 인덱스를 찾는 메서드
print(bisect_right(a, x))  # 정렬된 순서를 유지하도록 리스트 a에 데이터 x를 삽입할 가장 오른쪽 인덱스를 찾는 메서드


def count_by_range(a, left_value, right_value):
    right_index = bisect_right(a, right_value)
    left_index = bisect_left(a, left_value)
    return right_index - left_index


a = [1, 2, 3, 3, 3, 3, 4, 4, 8, 9]

# 값이 4인 데이터 개수 출력
print(count_by_range(a, 4, 4))
# 값이 [-1, 3] 범위에 있는 데이터 개수 출력
print(count_by_range(a, -1, 3))

from collections import deque, Counter

data = deque([2, 3, 4])
data.appendleft(1)
data.append(5)

print(data)
print(list(data))

counter = Counter(['red', 'blue', 'red', 'green', 'blue', 'blue'])

print(counter['blue'])
print(counter['green'])
print(dict(counter))

import math

print(math.factorial(5))  # 팩토리얼
print(math.sqrt(9))  # 제곱근
print(math.gcd(21, 14))  # 최대 공약수
print(math.pi)  # 파이(pi) 출력
print(math.e)  # 자연상수 e 출력

''' 2차원 리스트(행렬)을 90도 회전하는 메서드'''


def rotate_a_matrix_by_90_degree(a):
    row_length = len(a)  # 3
    column_length = len(a[0])  # 4

    # 받은 2차원 배열 한 행의 열의 갯수 만큼 행을 만들고 한 행에는 전체 행의 갯수만큼 0으로 초기화한 열이 들어간다.
    res = [[0] * row_length for _ in range(column_length)]
    # 반복은 행 갯수 만큼
    for r in range(row_length):  # 0 ~ 3
        # 반복은 열의 갯수 만큼
        for c in range(column_length):  # 0 ~ 4
            # c=0, 3-1-0=2 / r=0, c=0
            # 행은 기존 a의 열의 갯수만큼 들어가기 때문에 res[c]이고 1차원 위치의 값인 r은
            # c=0,r=0 / row_length-1-0=2 res[0][2] = a[0][0]
            # c=1,r=0 / row_length-1-0=2 res[1][2] = a[0][1]
            # c=2,r=0 / row_length-1-0=2 res[2][2] = a[0][2]
            # c=3,r=0 / row_length-1-0=2 res[3][2] = a[0][3]

            # r=1 / row_length-1-1=1 = a[0][1]
            # r=2 / row_length-1-2=0 = a[0][2]
            res[c][row_length - 1 - r] = a[r][c]

    return res


a = [[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12]]

print(rotate_a_matrix_by_90_degree(a))
