import sys

input = sys.stdin.readline

n = int(input().strip())
stars = [-1] * 2 * n
last = len(stars) - 1

for i in range(1, 2 * n):
    if i <= n:
        star = 2 * i
        for j in range(star // 2):
            stars[j] = j
            stars[last - j] = last - j
    else:
        star = 2 * (i - n)
        for j in range(star // 2):
            stars[n - j - 1] = -1
            stars[n + j] = -1

    for j in range(2 * n):
        if stars[j] != -1:
            print('*', end='')
        else:
            print(' ', end='')
    print()
