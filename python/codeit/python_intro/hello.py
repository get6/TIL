def fibonacci(n):
    if n <= 1:
        return n
    a = fibonacci(n - 1)
    b = fibonacci(n - 2)
    return a + b


# print(fibonacci(12))


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
