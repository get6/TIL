import sys

input = sys.stdin.readline

t = int(input().strip())

for _ in range(t):
    x1, y1, r1, x2, y2, r2 = tuple(map(int, input().strip().split()))
    d = pow(x1 - x2, 2) + pow(y1 - y2, 2)
    sub = pow(r1 - r2, 2)
    add = pow(r1 + r2, 2)
    answer = 0

    # 1. 원이 두 점에서 만나는 경우
    # r2 - r1 < d < r1 + r2
    if sub < d < add:
        answer = 2
    # 2. 두 원이 외접하는 경우 (한점에서 만난다)
    # d == r1 + r2
    # 3. 두 원이 내접하는 경우 (한점에서 만난다)
    # d == r2 - r1 and d != 0
    elif d == add or (d == sub and d != 0):
        answer = 1
    # 4. 하나의 원이 다른 원을 포함하는 경우 (만나지 않는다)
    # d < r2 - r1
    # 5. 두 원이 멀리 떨어져 만나지 않는 경우
    # d > r1 + r2
    elif d < sub or add < d:
        answer = 0
    # 6. 두 원이 일치하는 경우 (무수히 많은 점에서 만난다)
    # d == 0 or r1 == r2
    elif d == 0:
        if r1 == r2:
            answer = -1
        else:
            answer = 0
    print(answer)
