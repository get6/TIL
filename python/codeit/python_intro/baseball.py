from random import randint


def generate_numbers():
    numbers = []
    while len(numbers) < 3:
        num = randint(0, 9)
        if num not in numbers:
            numbers.append(num)

    print("0과 9 사이의 서로 다른 숫자 3개를 랜덤한 순서로 뽑았습니다.")

    return numbers


def take_guess():
    print("숫자 3개를 하나씩 차례대로 입력하세요.")
    numbers = []
    while len(numbers) < 3:
        length = len(numbers)
        num = int(input(f'{length + 1}번째 숫자를 입력하세요: '))
        if num < 0 or num > 9:
            print("범위를 벗어나는 숫자입니다. 다시 입력하세요.")
        elif num not in numbers:
            numbers.append(num)
        elif num in numbers:
            print("중복되는 숫자입니다. 다시 입력하세요.")

    return numbers


def get_score(guess, solution):
    s = 0
    b = 0
    for i in range(len(guess)):
        user_num = guess[i]
        com_num = solution[i]
        if user_num == com_num:
            s += 1
        elif user_num in solution:
            b += 1

    return s, b


# 여기서부터 게임 시작!
ANSWER = generate_numbers()
tries = 0

while True:
    user_guess = take_guess()
    s, b = get_score(user_guess, ANSWER)
    print(f'{s}S {b}B\n')
    tries += 1

    if s == 3:
        break

print("축하합니다. {}번 만에 세 숫자의 값과 위치를 모두 맞추셨습니다.".format(tries))
