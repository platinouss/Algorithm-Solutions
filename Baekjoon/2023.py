import sys
import math

input = sys.stdin.readline


def isPrime(num):
    for j in range(2, int(math.sqrt(num)) + 1):
        if num % j == 0:
            return False
    return True


def dfs(idx):
    for value in primeNum[idx - 1]:
        for prime in range(1, 10):
            number = int(value + str(prime))
            if not isPrime(number):
                continue
            primeNum[idx].append(str(number))


N = int(input())
primeNum = [[] for _ in range(N)]
primeNum[0] = ['2', '3', '5', '7']
for i in range(1, N):
    dfs(i)
print('\n'.join(primeNum[N-1]))
