"""
 [Baekjoon] 1167. 트리의 지름
 https://www.acmicpc.net/problem/1167

 접근 방식
 1) 특정 노드에서 모든 노드의 거리를 측정한다.
    1-1) 이때 가장 먼 거리에 있는 노드는 트리의 끝 노드라고 볼 수 있다.
 2) 1-1에서 선택된 노드에서 모든 노드까지의 거리를 측정한다.
 3) 여기서 가장 먼 노드까지의 거리가 트리의 지름이다.
"""

import sys
from collections import deque

input = sys.stdin.readline


def bfs(start):
    arr = [-1 for _ in range(N + 1)]
    arr[start] = 0
    dq = deque()
    dq.append(start)
    while dq:
        node = dq.pop()
        for nxt in edges[node]:
            if arr[nxt[0]] == -1:
                arr[nxt[0]] = arr[node] + nxt[1]
                dq.append(nxt[0])
    index, value = 0, 0
    for idx, v in enumerate(arr):
        if value < v:
            index = idx
            value = v
    return [index, value]


N = int(input())
edges = [[] for _ in range(N+1)]
for _ in range(N):
    values = list(map(int, input().split()))
    for j in range(1, len(values)-1, 2):
        edges[values[0]].append((values[j], values[j+1]))
end = bfs(1)[0]
print(bfs(end)[1])
