# num = '3212'
# base = 5
#
# answer = 0
# for idx, i in enumerate(num[::-1]):
#     answer += int(i) * (base ** idx)
#
# ans = int(num, base)
#
# print(answer)
# print(ans)
#
# s = 'abc'
# s.upper()
# print(s.ljust(int(3))) # 좌측 정렬
# print(s.center(int(3))) # 가운데 정렬
# print(s.rjust(int(3))) # 우측 정렬
#
# n = 3
# answer = ''
# for i in range(n + len(s)):
#     answer += ' '
# answer += s
# print(answer)
#
# import string
#
# print(string.digits)
# print(string.ascii_letters)
# print(string.hexdigits)

# import copy
#
# list1 = [3, 2, 1]
# list2 = [i for i in list1]
# list2.sort()
# list3 = copy.deepcopy(list1)
# print(list1)
# print(list2)
# print(sorted(list3))

# mylist = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
# new_list = [[], [], []]
# for i in range(len(mylist)):
#     for j in range(len(mylist[i])):
#         new_list[i].append(mylist[j][i])
#
# print(new_list)
# new_list3 = list(map(list, zip(*mylist)))
# new_list4 = map(list, zip(*mylist))
# print(new_list3)
# print(new_list4)
#
# mylist = [1,2,3]
# new_list = [40,50,60]
# for i in zip(mylist, new_list):
#     print(i)
#
# animals = ['cat','dog','lion']
# sounds = ['meow','woof','roar']
# answer = dict(zip(animals, sounds))
# print(answer)

def solution(mylist):
    answer = []
    for answer1, answer2 in zip(mylist, mylist[1:]):
        answer.append(abs(answer1 - answer2))
    return answer


# if __name__ == '__main__':
#     mylist = [83, 48, 13, 4, 71, 11]
#     print(solution(mylist))


# 상하좌우
def lrud():
    n = int(input())
    x, y = 1, 1
    plans = input().split()

    # L, R, U, D에 따른 이동 방향
    dx = [0, 0, -1, 1]
    dy = [-1, 1, 0, 0]
    move_types = ['L', 'R', 'U', 'D']

    # 이동 계획을 하나씩 확인
    for plan in plans:
        # 이동 후 좌표 구하기
        for i in range(len(move_types)):
            if plan == move_types[i]:
                nx = x + dx[i]
                ny = y + dy[i]
                break
        # 공간을 벗어나는 경우 무시
        if nx < 1 or ny < 1 or nx > n or ny > n:
            continue
        # 이동 수행
        x, y = nx, ny

    print(x, y)


# 시각
def times():
    # H를 입력받기
    h = int(input())

    count = 0
    for i in range(h + 1):
        for j in range(60):
            for k in range(60):
                if '3' in str(i) + str(j) + str(k):
                    count += 1
    print(count)


def night():
    # 현재 나이트의 위치 입력받기
    input_data = input()
    row = int(input_data[1])
    column = int(ord(input_data[0])) - int(ord('a')) + 1

    # 나이트가 이동할 수 있는 8가지 방향 정의
    steps = [(-2, -1), (-1, -2), (1, -2), (2, -1), (2, 1), (1, 2), (-1, 2), (-2, 1)]

    # 8가지 방향에 대하여 각 위치로 이동이 가능한지 확인
    result = 0
    for step in steps:
        # 이동하고자 하는 위치 확인
        next_row = row + step[0]
        next_column = column + step[1]
        # 해당 위치로 이동이 가능하다면 카운트 증가
        if 1 <= next_row <= 8 and 1 <= next_column <= 8:
            result += 1

    print(result)


def island():
    # N, M을 공백으로 구분하여 입력바디
    n, m = map(int, input().split())

    # 방문한 위치를 저장하기 위한 맵을 생성하여 0으로 초기화
    d = [[0] * m for _ in range(n)]
    # 현재 캐릭터의 X 좌표, Y 좌표, 방향을 입력받기
    x, y, direction = map(int, input().split())
    d[x][y] = 1  # 현재 좌표 방문 처리

    # 전체 맵 정보를 입력받기
    array = []
    for i in range(n):
        array.append(list(map(int, input().split())))

    # 북, 동, 남, 서 방향 정의
    dx = [-1, 0, 1, 0]
    dy = [0, 1, 0, -1]

    # 왼쪽으로 회전
    def turn_left():
        global direction
        direction -= 1
        # 0 3 2 1 순서 / 북 서 남 동 / 왼쪽 방향으로 돈다.
        if direction == -1:
            direction = 3

    # 시뮬레이션 시작
    count = 1
    turn_time = 0
    while True:
        # 왼쪽으로 회전
        turn_left()
        nx = x + dx[direction]
        ny = y + dy[direction]
        # 회전한 이후 정면에 가보지 않은 칸이 존재하는 경우 이동
        if d[nx][ny] == 0 and array[nx][ny] == 0:  # 방문하지 않았고 육지이면 True
            d[nx][ny] = 1
            x = nx
            y = ny
            count += 1
            turn_time = 0
            continue
        # 회전한 이후 정면에 가보지 않은 칸이 없거나 바다인 경우
        else:
            turn_time += 1
        # 네 방향 모두 갈 수 없는 경우
        if turn_time == 4:
            nx = x - dx[direction]
            ny = y - dy[direction]
            # 뒤로 갈 수 있다면 이동하기
            if array[nx][ny] == 0:
                x = nx
                y = ny
            # 뒤가 바다로 막혀있는 경우
            else:
                break
            turn_time = 0

    # 정답 출력
    print(count)


def recursive_fuc(i):
    if i == 100:
        return
    print(i, '번째 재귀 함수에서', i + 1, '번째 재귀 함수를 호출합니다.')
    recursive_fuc(i + 1)
    print(i, '번째 재귀 함수를 종료합니다.')


# 반복적으로 구현한 n!
def factorial_iterative(n):
    result = 1
    # 1부터 n까지의 수를 차례대로 곱하기
    for i in range(1, n + 1):
        result *= i
    return result


# 재귀적으로 구현한 n!
def factorial_recursive(n):
    if n <= 1:  # n이 1 이하인 경우 1을 반환
        return 1
    # n! = n * (n-1)!를 그대로 코드로 작성하기
    return n * factorial_recursive(n - 1)


# 각각의 방식으로 구현한 n! 출력(n = 5)
# print('반복적으로 구현:', factorial_iterative(5))
# print('재귀적으로 구현:', factorial_recursive(5))

INF = 999999999  # 무한의 비용 선언
# 2차원 리스트를 이용해 인접 행렬 표현
graph = [
    [0, 7, 5],
    [7, 0, INF],
    [5, INF, 0]
]

# print(graph)

graph = [[] for _ in range(3)]

graph[0].append((1, 7))
graph[0].append((2, 5))
graph[1].append((0, 7))
graph[2].append((0, 5))


# print(graph)
# if __name__ == '__main__':
#     mylist = [83, 48, 13, 4, 71, 11]
#     print(solution(mylist))

def snail():
    a, b, v = list(map(int, input().split()))
    days = (v - b - 1) / (a - b) + 1
    print(int(days))


import math


def acmHotel():
    t = int(input())  # T개의 테스트 데이터
    start = 101
    cnt = 1
    res = []
    for _ in range(t):
        # H: 호텔의 층 수, W: 각 층의 방의 갯수, N: 몇 번째 손님
        h, w, n = map(int, input().split())
        room = math.ceil(n / h)  # 호수 구하기
        floor = 100 * (n - h * (room - 1))
        res.append(floor + room)

    for i in res:
        print(i)


def womensChairman():
    # 해당 집에 거주민 수를 출력
    # 1 <= k, n <= 14
    for _ in range(int(input())):
        k = int(input())  # k층
        n = int(input())  # n호
        # k=1, n=3, 거주민=6
        # n이 3이라면 초기 floor는 [1, 2, 3]까지 생성되면 된다.
        floor = [i for i in range(1, n + 1)]
        # 0층에서 부터 해당 층수까지 반복 k=1이라면 0부터 k-1까지 k가 1이라면 1번 반복
        for _ in range(k):
            # 0은 증가될 필요가 없기 때문에 1부터 (n-1)까지 반복. i는 인덱스 접근값으로 쓰인다.
            for i in range(1, n):
                # 현재 값 + 이전 값이 더해진다.
                floor[i] += floor[i - 1]
        print(floor[-1])


# 18 // 5 + 18 // 3
# 5x + 3y = 18
# x = 3 y = 1

# 우선 순위를 정해야 하나
# 5로 나눴을 때 남는다면 3키로나 -1이 될 수 있고
# 5로 나눴을 때 11같은 경우에는 5키로 하나 3키로 두개해서 3개를 들고 갈 수 있지만 5키로를 2개 들면 1이 남아 -1이 된다.
# 해결방법은 무한루프안에 먼저 5로 나눌 수 있는지 확인하고 참이라면 5로 나누고 종료 아니라면 3을 계속 뺀다.
def findSugar():
    n = int(input())
    cnt = 0
    while True:
        if n % 5 == 0:
            cnt += int(n / 5)
            n /= 5
            break
        n -= 3
        cnt += 1

        if n < 0:
            cnt = -1
            break

    print(cnt)


# =WHeK9MM
# print(sum(list(map(int, input().split()))))
# print(eval('+'.join(input().split())))

def prime_number():
    n, m = map(int, input().split())
    arr = [False] * (m + 1)

    for i in range(2, m + 1):
        if arr[i]:
            continue
        j = i * 2
        while j <= m:
            if m < j:
                break
            arr[j] = True
            j += i

    for i in range(n, len(arr)):
        if i < 2:
            continue
        if not arr[i]:
            print(i)


def getNumCount():
    # 642 정답 10, 643 정답 11
    x = int(input())
    # 입력된 값 + 1의 값으로 배열을 생성 = 0부터 시작하기 때문에
    dp = [0 for _ in range(x + 1)]
    # 다이나믹 프로그래밍 참고하기
    for i in range(2, x + 1):
        # 2, 3으로 나눠지는 지 값을 확인하기 전에 모르기 때문에 기본적으로 이전 값을 현재 위치에 넣어줌
        dp[i] = dp[i - 1] + 1
        # 2로 나눠지고 현재 값이 i를 2로 나눈 위치의 값 + 1보다 클 때에만 나눔.
        # 현재값이 클 때에만 하는 이유는 이전값이 크거나 같다면 이후 값에 영향을 미친다.
        # 94는 실제로 7 인데 i % 2 == 0로만 하면 10임.
        if i % 2 == 0 and dp[i] > dp[i // 2] + 1:
            dp[i] = dp[i // 2] + 1
        if i % 3 == 0 and dp[i] > dp[i // 3] + 1:
            dp[i] = dp[i // 3] + 1

    print(dp[x])


# DFS 메소드 정의
def dfs(graph, v, visited):
    # 현재 노드를 방문 처리
    visited[v] = True
    print(v, end=" ")
    # 현재 노드와 연결된 다른 노드를 재귀적으로 방문
    for i in graph[v]:
        if not visited[i]:
            dfs(graph, i, visited)


# 각 노드가 연결된 정보를 리스트 자료형으로 표현(2차원 리스트)
graph = [
    [],
    [2, 3, 8],
    [1, 7],
    [1, 4, 5],
    [3, 5],
    [3, 4],
    [7],
    [2, 6, 8],
    [1, 7]
]
# 각 노드가 방문된 정보를 리스트 자료형으로 표현(1차원 리스트)
visited = [False] * len(graph)
# 정의된 DFS 함수 호출
# dfs(graph, 1, visited)

from collections import deque


# BFS 메소드 정의
def bfs(graph, start, visited):
    # 큐(Queue) 구현을 위해 deque 라이브러리 사용
    queue = deque([start])
    # 현재 노드를 방문 처리
    visited[start] = True
    # 큐가 빌 때까지 반복
    while queue:
        # 큐에서 하나의 원소를 뽑아 출력
        v = queue.popleft()
        print(v, end=" ")
        # 해당 원소와 연결된, 아직 방문하지 않은 원소들을 큐에 삽입
        for i in graph[v]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True


# 정의된 BFS 함수 호출
# bfs(graph, 1, visited)

def solution(mylist):
    answer = []
    # for i in mylist:
    #     answer.append(int(i))
    answer = list(map(int, mylist))

    return answer


# print(solution(['1', '100', '33']))

def lunarProj():
    # 테스트케이스의 개수
    t = int(input())
    answer = []
    while t > 0:
        # 출발 지점 x, 도착 지점 y까지 필요한 최소한의 공간이동 장치 작동 횟수
        x, y = map(int, input().split())
        if x == 0:
            x = 1
        length = y - x
        arr = [0] * length

        for i in range(1, length):
            arr[i] = arr[i - 1] + 1

        answer.append(arr[-1] + 1)
        t -= 1

    for i in answer:
        print(i)


def findIce():
    # n, m을 공백으로 구분하여 입력받기
    n, m = map(int, input().split())

    # 2차원 리스트의 맵 정보 입력받기
    graph = []
    for i in range(n):
        graph.append(list(map(int, input())))

    # DFS로 특정한 노드를 방문한 뒤에 연결된 모든 노드들도 방문
    def dfs(x, y):
        # 주어진 범위를 벗어나는 경우에는 즉시 종료
        if x <= -1 or x >= n or y <= -1 or y >= m:
            return False
        # 현재 노드를 아직 방문하지 않았다면
        if graph[x][y] == 0:
            # 해당 노드 방문 처리
            graph[x][y] = 1
            # 상,좌,하,우의 위치도 재귀적으로 호출
            dfs(x - 1, y)
            dfs(x, y - 1)
            dfs(x + 1, y)
            dfs(x, y + 1)
            return True
        return False

    # 모든 노드(위치)에 대하여 음료수 채우기
    result = 0
    for i in range(n):
        for j in range(m):
            # 현재 위치에서 DFS 수행
            if dfs(i, j):
                result += 1

    print(result)


from collections import deque

# N, M을 공백으로 구분하여 입력받기
n, m = map(int, input().split())
# 2차원 리스트의 맵 정보 입력받기
graph = []
for i in range(n):
    graph.append(list(map(int, input())))

# 이동할 네 방향 정의(상, 하, 좌, 우)
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


# BFS 소스코드 구현
def bfs(x, y):
    # 큐(Queue) 구현을 위해 deque 라이브러리 사용
    queue = deque()
    queue.append((x, y))
    # 큐가 빌 때까지 반복
    while queue:
        x, y = queue.popleft()
        # 현재 위치에서 네 방향으로의 위치 확인
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            # 미로 찾기 공간을 벗어난 경우 무시
            if nx < 0 or ny < 0 or nx >= n or ny >= m:
                continue
            # 벽인 경우 무시
            if graph[nx][ny] == 0:
                continue
            # 해당 노드를 처음 방문하는 경우에만 최단 거리 기록
            if graph[nx][ny] == 1:
                graph[nx][ny] = graph[x][y] + 1
                queue.append((nx, ny))

    # 가장 오른쪽 아래까지의 최단 거리 반환
    print(graph)
    return graph[n - 1][m - 1]


# BFS를 수행한 결과 출력
# print(bfs(0, 0))
