# 동적 계획법
# 1. 최적 부분 구조 (Optimal Substructure)
# 큰 문제를 작은 문제로 나눌 수 있으며 작은 문제의 답을 모아서 큰 문제를 해결 할 수 있다.
# 2. 중복되는 부분 문제 (Overlapping Subproblem)
# 동일한 작은 문제를 반복적으로 해결해야 합니다.

# 피보나치 함수(Fibonacci Function)을 재귀함수로 구현
# def fibo(x):
#     if x == 1 or x == 2:
#         return 1
#     return fibo(x - 1) + fibo(x - 2)

# print(fibo(3))

# 탑다운(메모이제이션) 방식은 하향식, 보텀업 방식은 상향식

# 한 번 계산된 결과를 메모이제이션(Memoization)하기 위한 리스트 초기화
d = [0] * 100

# 피보나치 함수(Fibonacci Function)를 재귀함수로 구현(탑다운 다이나믹 프로그래밍)
def fibo(x):
    print('f(' + str(x) + ')', end= ' ')
    # 종료 조건(1 혹은 2일 때 1을 반환)
    if x == 1 or x == 2:
        return 1
    # 이미 계산한 적 있는 문제라면 그대로 반환
    if d[x] != 0:
        return d[x]
    # 아직 계산하지 않은 문제라면 점화식에 따라서 피보나치 결과 반환
    d[x] = fibo(x - 1) + fibo(x - 2)
    return d[x]

print(fibo(20))

# 앞서 계산된 결과를 저장하기 위한 DP 테이블 초기화
d = [0] * 101

# 첫 번째 피보나치 수와 두 번째 피보나치 수는 1
d[1] = 1
d[2] = 1
n = 100

# 피보나치 함수(Fibonacci Function) 반복문으로 구현(보텀업 다이나믹 프로그래밍)
for i in range(3, n + 1):
    d[i] = d[i - 1] + d[i - 2]
    
print(d[n])