import sys

input = sys.stdin.readline

x = []
y = []
for _ in range(3):
    coor = tuple(map(int, input().split()))
    x.append(coor[0])
    y.append(coor[1])

answer = [0, 0]

left = x[0]
right = y[0]

x_cnt = x.count(left)
y_cnt = y.count(right)

if x_cnt < 2:
    answer[0] = left
else:
    for i in range(1, 3):
        if left != x[i]:
            answer[0] = x[i]
            break
if y_cnt < 2:
    answer[1] = right
else:
    for i in range(1, 3):
        if right != y[i]:
            answer[1] = y[i]
            break

# print(' '.join(map(str, answer)))
print(*answer, sep=' ')
