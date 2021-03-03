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


if __name__ == '__main__':
    mylist = [83, 48, 13, 4, 71, 11]
    print(solution(mylist))
