import sys

input = sys.stdin.readline

while True:
    inp = input().strip()
    if inp == '0 0 0':
        break

    inp = list(map(int, inp.split()))

    max_n = max(inp)
    index = inp.index(max_n)

    del inp[index]

    if pow(inp[0], 2) + pow(inp[1], 2) == pow(max_n, 2):
        print("right")
    else:
        print("wrong")
