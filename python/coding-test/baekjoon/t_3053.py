import math
import sys

input = sys.stdin.readline
r = int(input().strip())

print("%.6f" % (math.pi * pow(r, 2)))
print("%.6f" % (2 * pow(r, 2)))
