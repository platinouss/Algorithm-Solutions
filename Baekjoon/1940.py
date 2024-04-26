"""
 [Baekjoon] 1940. 주몽
 https://www.acmicpc.net/problem/1940
"""

import sys

input = sys.stdin.readline


if __name__ == "__main__":
    N = int(input())
    M = int(input())
    arr = sorted(list(map(int, input().split())))
    if N < 2:
        print(0)
        exit(0)
    start, end, count = 0, len(arr) - 1, 0
    while start < end:
        total = arr[start] + arr[end]
        if total == M:
            count += 1
        if total <= M:
            start += 1
        else:
            end -= 1
    print(count)

