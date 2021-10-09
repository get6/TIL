import math

n = int(input())
coordinates = []

for i in range(n):
    coordinates.append(tuple(map(int, input().split())))

# 1
# coordinates.append((coordinates[n - 1][0], 0))
# coordinates.append((coordinates[0][0], 0))

# 2
coordinates.insert(0, (coordinates[0][0], 0))
coordinates.append((coordinates[n][0], 0))
# coordinates.append(coordinates[0])

x_coord = 0
y_coord = 0
for i in range(n + 1):
    current_coord = coordinates[i]
    next_coord = coordinates[i + 1]
    x_coord += current_coord[0] * next_coord[1]
    y_coord += current_coord[1] * next_coord[0]

answer = math.fabs(0.5 * (x_coord - y_coord))
print(answer)

"""
6
1 2
6 5
4 2
8 3
3 3
5 4

3
1 1
2 1
3 2

2.5

test 
1 2
8 3
6 4
5 4
4 2
3 3
"""
