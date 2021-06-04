# def select_stops(water_stops, capacity):
#     stop_list = []
#     drank_water = capacity
#     km = 0
#
#     for i in range(len(water_stops) - 1):
#         current_water_stop = water_stops[i]
#         drank_water -= current_water_stop - km
#         km = current_water_stop
#         if drank_water < 1:
#             stop_list.append(current_water_stop)
#             drank_water = capacity
#         elif drank_water < water_stops[i + 1] - km:
#             stop_list.append(current_water_stop)
#             drank_water = capacity
#
#     stop_list.append(water_stops[-1])
#
#     return stop_list
#
#
# # 테스트
# list1 = [1, 4, 5, 7, 11, 12, 13, 16, 18, 20, 22, 24, 26]
# print(select_stops(list1, 4))
#
# list2 = [5, 8, 12, 17, 20, 22, 23, 24, 28, 32, 38, 42, 44, 47]
# print(select_stops(list2, 6))
def select_stops(water_stops, capacity):
    stop_list = []

    # 마지막 들른 약수터 위치
    prev_stop = 0

    for i in range(len(water_stops)):
        # i 지점까지 갈 수없으면, i - 1 지점 약수터를 들른다.
        current = water_stops[i]
        if current - prev_stop > capacity:
            stop_list.append(water_stops[i - 1])
            prev_stop = water_stops[i - 1]

    # 마지막 약수터는 무조건 간다
    stop_list.append(water_stops[-1])

    return stop_list


# 테스트
list1 = [1, 4, 5, 7, 11, 12, 13, 16, 18, 20, 22, 24, 26]
print(select_stops(list1, 4))

list2 = [5, 8, 12, 17, 20, 22, 23, 24, 28, 32, 38, 42, 44, 47]
print(select_stops(list2, 6))
