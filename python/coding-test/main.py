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

p = sys.stdin.readline()
# print(p)
print(p.rstrip())
