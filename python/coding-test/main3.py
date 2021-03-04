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


n = int(input())
cnt = 0
if n >= 10:
    kg1 = 0
    for i in range(1, (n // 5) + 1):
        kg1 += 5
        cnt += 1
    n -= kg1
if n >= 3:
    kg2 = 0
    for i in range(1, (n // 3) + 1):
        kg2 += 3
        cnt += 1
    n -= kg2
if n > 0:
    cnt = -1
print(cnt)

# 18 // 5 + 18 // 3
# 5x + 3y = 18
# x = 3 y = 1