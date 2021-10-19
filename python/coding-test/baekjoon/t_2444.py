import sys

input = sys.stdin.readline

n = int(input().strip())

for i in range(1, n + 1):
    start = n - i
    for j in range(start):
        print(' ', end='')
    for j in range(2 * i - 1):
        print('*', end='')
    print()

for i in range(1, n):
    for j in range(i):
        print(' ', end='')
    for j in range(2 * (n - i) - 1):
        print('*', end='')
    print()
