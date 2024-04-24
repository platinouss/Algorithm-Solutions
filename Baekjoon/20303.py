"""
 [Baekjoon] 20303. 할로윈의 양아치
 https://www.acmicpc.net/problem/20303
"""

import sys

input = sys.stdin.readline


def union(a1, b1):
    a2 = find(a1)
    b2 = find(b1)
    if a2 <= b2:
        arr[b2] = a2
    else:
        arr[a2] = b2


def find(v):
    if v == arr[v]:
        return v
    arr[v] = find(arr[v])
    return arr[v]


def getMaxCount():
    dp = [0 for _ in range(K)]
    for value in friends.values():
        for i in reversed(range(value[0], K)):
            dp[i] = max(dp[i], dp[i-value[0]] + value[1])
    return dp[K-1]


if __name__ == "__main__":
    N, M, K = map(int, input().split())
    candyCounts = list(map(int, input().split()))
    arr = [i for i in range(N + 1)]
    for _ in range(M):
        a, b = map(int, input().split())
        union(a, b)
    for i in range(1, len(arr)):
        find(i)
    friends = {}
    for i in range(1, N+1):
        if arr[i] not in friends:
            friends[arr[i]] = [1, candyCounts[i-1]]
        else:
            friends[arr[i]][0] += 1
            friends[arr[i]][1] += candyCounts[i - 1]
    print(getMaxCount())
