"""
 [Baekjoon] 10986. 나머지 합
 https://www.acmicpc.net/problem/10986
"""

import sys
import math

input = sys.stdin.readline


def getResult():
    countDict = {}
    count = len(list(filter(lambda x: x == 0, sumArr)))
    for value in sumArr:
        countDict.update({value: countDict.get(value, 0) + 1})
    for value in countDict.values():
        count += math.comb(value, 2)
    return count


if __name__ == "__main__":
    N, K = list(map(int, input().split()))
    arr = list(map(int, input().split()))
    sumArr = [arr[0]] + [0 for _ in range(1, N)]
    for i in range(1, len(sumArr)):
        sumArr[i] = sumArr[i-1] + arr[i]
    sumArr = list(map(lambda x: x % K, sumArr))
    print(getResult())
