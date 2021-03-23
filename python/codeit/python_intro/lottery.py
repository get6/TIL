from random import randint


def generate_numbers(n):
    arr = []
    while len(arr) < n:
        num = randint(1, 45)
        if num not in arr:
            arr.append(num)

    return arr


def draw_winning_numbers():
    # 코드를 작성하세요.
    # numbers = generate_numbers(6)
    # numbers.sort()
    # while len(numbers) < 7:
    #     num = randint(1, 45)
    #     if num not in numbers:
    #         numbers.append(num)
    winning_numbers = generate_numbers(7)
    return sorted(winning_numbers[:6]) + winning_numbers[-1:]


def count_matching_numbers(numbers, winning_numbers):
    return len(set(numbers).intersection(winning_numbers))


def check(numbers, winning_numbers):
    count = count_matching_numbers(numbers, winning_numbers[:6])
    bonus = count_matching_numbers(numbers, winning_numbers[-1:])
    price = 0
    if count == 6:
        price = 10000000000
    elif count == 5 and bonus == 1:
        price = 50000000
    elif count == 5:
        price = 1000000
    elif count == 4:
        price = 50000
    elif count == 3:
        price = 5000

    return price
