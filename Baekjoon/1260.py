"""
 [Baekjoon] 1260. DFS와 BFS
 https://www.acmicpc.net/problem/1260

 접근 방식
 1) DFS 결과 출력 시 재귀를 통해 출력한다.
 2) BFS 결과 출력 시 큐 자료구조를 사용하여 출력한다.
"""

import sys
from collections import deque

input = sys.stdin.readline


def dfs(idx, visited):
    result.append(str(idx))
    for node in arr[idx]:
        if visited[node]:
            continue
        visited[node] = True
        dfs(node, visited)


def bfs():
    result = []
    dq = deque()
    dq.append(start)
    visited = [False] * (N + 1)
    visited[start] = True
    while dq:
        node = dq.popleft()
        for v in arr[node]:
            if visited[v]:
                continue
            visited[v] = True
            dq.append(v)
        result.append(str(node))
    print(' '.join(result))


N, K, start = map(int, input().split())
arr = [[] for _ in range(N + 1)]
for _ in range(K):
    s, e = map(int, input().split())
    arr[s].append(e)
    arr[e].append(s)
for i in range(1, N+1):
    arr[i] = sorted(arr[i])
result = []
visited = [False] * (N + 1)
visited[start] = True
dfs(start, visited)
print(' '.join(result))
bfs()
