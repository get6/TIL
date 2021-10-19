import sys


def recursive(n):
    if n < 2:
        return
    print(n)
    recursive(n // 3)


input = sys.stdin.readline

n = int(input())
'''
i = 1 star = 1 index = 5 loop = 6
i = 2 star = 3 index = 4 loop = 7
'''

for i in range(n, -1, -1):
    star = 2 * i - 1
    for j in range(1, n + i):
        if j >= n + i - star:
            print('*', end='')
        else:
            print(' ', end='')
    print()

# n = int(input())
# recursive(n)

'''
  for i in range(n * n):
        if pow(n / 3, 2) == (n * 2) - i:
            print(' ', end='')
        else:
            print('*', end='')
        if i != 0 and (i + 1) % n == 0:
            print("")
'''
