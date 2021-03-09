# N, M, K를 공백으로 구분하여 입력받기
# N = 배열의 크기, M = 숫자가 더해지는 횟수, K = 반복 가능한 횟수
def test1():
    n, m, k = map(int, input().split())
    # N개의 수를 공백으로 구분하여 입력받기
    data = list(map(int, input().split()))

    data.sort()
    first = data[n - 1]
    second = data[n - 2]

    # 가장 큰 값의 최대 횟수를 알아낸다.
    count = int(m / (k + 1)) * k
    count += m % (k + 1)  # 딱 나눠떨어지지 않을 때 나머지 값을 더해서 오류를 방지한다.

    result = 0
    result += (count) * first
    # m - count는 가장 큰 값이 최대로 돌 수 있는 값으로 최대 횟수 - k의 최대 횟수를 빼면 두번째로 큰 수의 최대 횟수가 나온다.
    result += (m - count) * second

    print(result)


def test2():
    n, m = list(map(int, input().split()))

    result = 0
    # 한 줄씩 입력받아 확인
    for i in range(n):
        data = list(map(int, input().split()))
        # 현재 줄에서 '가장 작은 수' 찾기
        min_value = min(data)
        # '가장 작은 수'들 중에서 가장 큰 수 찾기
        result = max(result, min_value)

    print(result)


def test3():
    n, m = list(map(int, input().split()))

    result = 0
    for i in range(n):
        data = list(map(int, input().split()))
        min_value = 10001
        for a in data:
            min_value = min(min_value, a)
        result = max(result, min_value)

    print(result)


def test4():
    # 데이터의 개수 N과 부분 연속 수열의 합 M을 입력 받기
    n, m = 5, 5
    data = [1, 2, 3, 2, 5]

    result = 0
    summary = 0
    end = 0

    for start in range(n):
        # end를 가능한만큼 이동시키기
        while summary < m and end < n:
            summary += data[end]
            end += 1
        # 부분 합이 m일 때 카운트 증가
        if summary == m:
            result += 1
        summary -= data[start]

    print(result)


def test5():
    n = 5
    data = [10, 20, 30, 40, 50]

    # Prefix sum 배열 계산
    summary = 0
    prefix_sum = [0]
    for i in data:
        summary += i
        prefix_sum.append(summary)

    # 구간 합 계산
    left = 3
    right = 4
    print(prefix_sum[right] - prefix_sum[left - 1])


# n, k = map(int, input().split())
# res = 0
# while n != 1:
#     n -= 1
#     if n % k == 0:
#         n /= k
#     res += 1
#
# print(res)


def test6():
    n, k = map(int, input().split())
    result = 0
    # N이 K 이상이라면 K로 계속 나누기
    while n >= k:
        # N이 K로 나누어 떨어지지 않는다면 N에서 1씩 빼기
        while n % k != 0:
            n -= 1
            result += 1
        # K로 나누기
        n //= k
        result += 1

    while n > 1:
        n -= 1
        result += 1

    print(result)


n, k = map(int, input().split())
result = 0

while True:
    # ( N == K로 나누어떨어지는 수)가 될 때까지 1씩 빼기
    target = (n // k) * k
    result += (n - target)
    n = target
    # N이 K보다 작을 때(더 이상 나눌 수 없을 때) 반복문 탈출
    if n < k:
        break
    # K로 나누기
    result += 1
    n //= k
# 마지막으로 남은 수에 대하여 1씩 빼기
result += (n - 1)
print(result)
