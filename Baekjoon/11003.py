"""
 [Baekjoon] 11003. 최솟값 찾기
 https://www.acmicpc.net/problem/11003
"""

import sys
from collections import deque

input = sys.stdin.readline


if __name__ == "__main__":
    N, L = map(int, input().split())
    arr = tuple(map(int, input().split()))
    result = []
    dq = deque()
    for i in range(N):
        while dq and dq[-1] > arr[i]:
            dq.pop()
        dq.append(arr[i])
        if i >= L and dq[0] == arr[i-L]:
            dq.popleft()
        result.append(str(dq[0]))
    print(" ".join(result))
