import sys

input = sys.stdin.readline

x, y, w, h = list(map(int, input().split()))

answer = [x, y, w - x, h - y]

print(min(answer))
