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


test3()
