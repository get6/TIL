def fibonacci(n):
    if n <= 1:
        return n
    a = fibonacci(n - 1)
    b = fibonacci(n - 2)
    return a + b


# print(fibonacci(12))

def fly_me_to_the_moon():
    t = int(input())
    arr = []
    for _ in range(t):
        x, y = map(int, input().split())
        arr.append((x, y))

    for x, y in arr:
        # 이동거리
        dist = y - x
        # 장치 작동 횟수 = 최고 속도 찾기
        k = 0
        while True:
            k += 1
            # 중간지점에서 속도가 줄어들어야하기 때문에
            # 거리 - 시작 k값 * 종료 k값으로 이동거리를 갈 수 있는 k값을 구함

            # k ** 2이 되는 이유
            # k(k+1)/2 = 최고점 도달하기 전 거리
            # k(k-1)/2 = 최고점 이후 마지막에 도달하는 거리
            if dist - k * k <= 0:
                break
        # 속도가 1씩 증가했고 중간지점에서 마지막까지 1씩 감소한게 딱 맞아 떨어질 때
        if dist - k * k == 0:
            # k가 최고점에 도달한 경우는 1번이기때문에 1을 뺌
            print(k * 2 - 1)
        # 너무 간 경우 = 0 이하인 경우
        else:
            # 정점찍고 내려왔는데 조금 남은 경우

            # k를 조정한다.
            k = k - 1
            # 이동거리 - k 제곱한 값이 k보다 작거나 같을 때
            # 해당 값을 한번 더 가야하는 경우
            if dist - k * k <= k:
                print(k * 2)
            # k보다 크고 2k보다 작은 경우
            else:
                print(k * 2 + 1)


print(8 // 3)
print(8.0 // 3)
print(round(3.14))
print(round(3.54))

print("""'응답하라 1998'은 많은 시청자들에게 사랑을 받은 드라마예요.
데카르트는 "나는 생각한다. 고로 존재한다."라고 말했다.""")
print("영화 \'신세계\'에서 \"드루와~\"라는 대사가 유행했다.")

print(float(2))
print(str(2))

year = 2021
month = 3
day = 19

print("오늘은 {}년 {}월 {}일입니다.".format(year, month, day))
print("오늘은 {0}년 {2}월 {1}일입니다.".format(year, month, day))

num_1 = 1
num_2 = 3
print("{0} 나누기 {1}은 {2:.0f}입니다.".format(num_1, num_2, num_1 / num_2))

name = "황성준"
age = 29

print("제 이름은 %s이고 %d살입니다." % (name, age))
print(f"제 이름은 {name}이고 {age}살입니다.")


def calculate_change(payment, cost):
    payment -= cost
    arr = [50000, 10000, 5000, 1000]
    for i in arr:
        count = payment // i
        payment -= i * count
        print('{}원 지폐: {}장'.format(i, count))


# 테스트
calculate_change(100000, 33000)
print()
calculate_change(500000, 378000)
i = 1

reward = 50000000
year = 1988
price_bank = reward
price_apart = 1100000000
while year < 2016:
    price_bank = price_bank * (1 + 0.12)
    year += 1

list_test = [3.54, 4.45, 3.41, 1.25]
list_test.reverse()

print(f"사실은 {[round(x, 1) for x in list_test[:3]]}을 불러오고 싶은데")
print(f"사실은 {[float(f'{x:.1f}') for x in list_test[:3]]}을 불러오고 싶은데")

for a in range(1, 333):
    for b in range(a + 1, 500):
        c = 1000 - a - b
        if a ** 2 + b ** 2 == c ** 2 and a + b + c == 1000:
            print(a * b * c)

import random


def game_3():
    # 코드를 작성하세요.
    answer = random.randint(1, 20)

    i = 4
    while 0 < i:
        inp = int(input(f"기회가 {i}번 남았습니다. 1-20 사이의 숫자를 맞혀 보세요: "))
        if inp == answer:
            print(f"축하합니다. {5 - i}번 만에 숫자를 맞히셨습니다.")
            break
        elif inp < answer:
            print("Up")
        else:
            print("Down")
        i -= 1

    if i < 1:
        print(f"아쉽습니다. 정답은 {answer}입니다.")


d = [0] * 100


def fibo(x):
    if x == 1 or x == 2:
        return 1

    if d[x] != 0:
        return d[x]

    d[x] = fibo(x - 1) + fibo(x - 2)
    return d[x]


def pibo(x):
    print(f'({x})', end=' ')
    if x == 1 or x == 2:
        return 1
    if d[x] != 0:
        return d[x]
    d[x] = pibo(x - 1) + pibo(x - 2)
    return d[x]


# d[1] = 1
# d[2] = 1
# n = 99
#
# for i in range(3, n + 1):
#     d[i] = d[i - 1] + d[i - 2]
#
# answer = d[n]
# print(answer)

def eight_five():
    # 정수 x를 입력받기
    x = int(input())

    # 앞서 계산된 결과를 저장하기 위한 DP 테이블 초기화
    d = [0] * 30001

    # 다이나믹 프로그래밍 진행(보텀업)
    for i in range(2, x + 1):
        # 현재의 수에서 1을 빼는 경우
        d[i] = d[i - 1] + 1
        # 현재의 수가 2로 나누어 떨어지는 경우
        if i % 2 == 0:
            val = d[i // 2]
            d[i] = min(d[i], val + 1)
        if i % 3 == 0:
            val = d[i // 3]
            d[i] = min(d[i], val + 1)
        if i % 5 == 0:
            val = d[i // 5]
            d[i] = min(d[i], val + 1)

    print(d[x])


def eight_six():
    n = int(input())

    array = list(map(int, input().split()))
    d = [0] * 100

    d[0] = array[0]
    d[1] = max(array[0], array[1])
    for i in range(2, n):
        prev1 = d[i - 1]
        prev2 = d[i - 2]
        arr_val = array[i]
        d[i] = max(prev1, prev2 + arr_val)

    print(d[n - 1])


def eight_seven():
    n = int(input())

    d = [0] * 1001

    d[1] = 1
    d[2] = 3
    for i in range(3, n + 1):
        d[i] = (d[i - 1] + 2 * d[i - 2]) % 796796

    print(d[n])


def eight_eight():
    n, m = map(int, input().split())
    array = []
    for i in range(n):
        array.append(int(input()))

    d = [10001] * (m + 1)

    d[0] = 0
    for i in range(n):
        for j in range(array[i], m + 1):
            # (i - k)원을 만드는 방법이 존재하는 경우
            val = d[j - array[i]]
            if val != 10001:
                d[j] = min(d[j], val + 1)

    # 최종적으로 M원을 만드는 방법이 없는 경우
    if d[m] == 10001:
        print(-1)
    else:
        print(d[m])

eight_eight()