def calculate_filter(filters: str, digits: str, index: int):
    cal_digits = int(digits)
    can_calculate = True
    for i, v in enumerate(filters):
        add_str = ['0'] * (len(digits) - index)
        if v == '+' or v == '-':
            add_str[i] = '1'
            add_num = int(''.join(add_str))
            if v == '+':
                if digits[i] == '9':
                    can_calculate = False
                    break
                cal_digits = int(cal_digits) + add_num
            elif v == '-':
                if digits[i] == '0':
                    can_calculate = False
                    break
                cal_digits = int(cal_digits) - add_num

    if can_calculate:
        return str(cal_digits)
    else:
        return digits


def main():
    t = int(input())  # 첫번째 입력
    for this in range(1, t + 1):
        nums = input().split()  # 두번째 입력
        f_digits = nums[0]
        t_digits = nums[1]
        filters = input()  # 필터 뒤집어 사용가능
        reverse_filters = filters[::-1]
        count = 0
        is_something = int(f_digits) < int(t_digits)  # 시작값이 더 작은 경우 참
        i = 0
        while int(f_digits) < int(t_digits) if is_something else int(f_digits) > int(t_digits):
            if f_digits[i] == t_digits[i]:
                i += 1
                continue

            add_order = filters.find('+')
            sub_order = filters.find('-')
            current_filters = filters
            if int(f_digits) < int(t_digits):
                if add_order != -1 and add_order < sub_order:
                    current_filters = reverse_filters
            else:
                if sub_order != -1 and add_order < sub_order:
                    current_filters = reverse_filters
            f_digits = calculate_filter(current_filters, f_digits, i)
            count += 1

        if f_digits != t_digits:  # 빠져나오고도 같지 않은 경우
            count = -1

        print(f'#{this} {count}')


main()

'''
1
1142 350 3
+0-


5
159 555 2
+-
1142 350 3
+0-
116 676 2
+-
887 854 2
0-
370 994 2
+0
'''
