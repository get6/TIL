import sys


def is_prime(n):
    return max_list[n]


input = sys.stdin.readline

t = int(input())
ns = []

for _ in range(t):
    ns.append(int(input()))

max_list = [True] * (max(ns) + 1)

for i in range(2, len(max_list)):
    for j in range(i, len(max_list), i):
        if i == j:
            continue
        max_list[j] = False

for k in range(t):
    n = ns[k]
    partitions = []
    for i in range(2, n):
        l = i
        r = n - l
        if is_prime(l) and is_prime(r):
            partitions.append((l, r))

    first = partitions[0];
    min_val = abs(first[1] - first[0])
    min_index = 0
    for i in range(1, len(partitions)):
        partition = partitions[i]
        min_partition = abs(partition[1] - partition[0])
        if min_partition < min_val:
            min_val = min_partition
            min_index = i

    last = partitions[min_index]
    print(f'{last[0]} {last[1]}')
