"""
 [Baekjoon] 1253. 좋다
 https://www.acmicpc.net/problem/1253
"""

import sys

input = sys.stdin.readline


def isGoodNum(idx):
    tmp = arr[:idx] + arr[idx+1:]
    start, end = 0, len(tmp) - 1
    while start < end:
        total = tmp[start] + tmp[end]
        if total == arr[idx]:
            return True
        if total < arr[idx]:
            start += 1
        else:
            end -= 1
    return False


if __name__ == "__main__":
    N = int(input())
    arr = sorted(list(map(int, input().split())))
    if N < 3:
        print(0)
        exit(0)
    count = 0
    for i in range(len(arr)):
        if isGoodNum(i):
            count += 1
    print(count)
