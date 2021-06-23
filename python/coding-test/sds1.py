# 최고점 66점 어딘가 에러가 있는데 모르겠음..
def get_available_number(right: list):
    number = 0
    for camel in right:
        if camel != 0:
            number += 1
            if number == 2:
                break
    return number


def main():
    t = int(input())
    for now in range(1, t + 1):
        _ = int(input())
        right = sorted([int(i) for i in input().split()])
        left = [0] * (len(right))
        total = len(right)
        time = 0
        i = total - 1
        j = 0
        move_shortest = True
        # 옮겨야하는 낙타 수
        while 0 < total:
            moving_camels = []
            number = get_available_number(right)
            for _ in range(number):
                cur = j if move_shortest else i
                camel = right[cur]
                moving_camels.append(camel)
                left[cur] = camel
                right[cur] = 0
                if move_shortest:
                    j += 1
                    if j == number:
                        move_shortest = False
                else:
                    i -= 1
                total -= 1

            time += max(moving_camels)
            if 0 < total:
                camel = int(1e3) + 1
                for k in range(len(left)):
                    current = left[k]
                    if current != 0 and current < camel:
                        camel = current
                        break

                idx = left.index(camel)
                left[idx] = 0
                time += camel
                right[idx] = camel
                total += 1
                j -= 1
                if j == 0:
                    move_shortest = True

        print(f'#{now} {time}')


main()
'''
2
1
5
4
1 2 8 9
1
8
2 5 7 8 11 15 1 999
5
2
999
5
5
2
11
5
5
2
8
5
5

1059
53



'''
