import sys

input = sys.stdin.readline
nums = []
while True:
    n = int(input())
    if n == 0:
        break
    nums.append(n)

prime_list = [True] * (max(nums) * 2 + 1)
prime_list[0] = False
prime_list[1] = False

for i in range(2, len(prime_list)):
    if not prime_list[i]:
        continue
    for j in range(i, len(prime_list), i):
        if i == j:
            continue
        if j % i == 0:
            prime_list[j] = False

for i in range(len(nums)):
    n = nums[i]
    n2 = 2 * n
    print(prime_list[n + 1:n2 + 1].count(True))
