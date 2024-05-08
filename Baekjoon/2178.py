"""
 [Baekjoon] 2178. 미로 탐색
 https://www.acmicpc.net/problem/2178

 접근 방식
 1) (0, 0)에서 (N-1, M-1)까지 bfs로 1로 표현된 경로만 탐색하여 최소 비용을 출력한다.
"""

import sys
from collections import deque

input = sys.stdin.readline

di = [-1, 1, 0, 0]
dj = [0, 0, -1, 1]


def isOutOfRange(a, b):
    return a < 0 or a >= N or b < 0 or b >= M


def bfs(a, b):
    dq = deque()
    dq.append([a, b, 1])
    visited = [[False] * M for _ in range(N)]
    visited[a][b] = True
    while dq:
        node = dq.popleft()
        if node[0] == N-1 and node[1] == M-1:
            print(node[2])
            return
        for k in range(len(di)):
            ii = node[0] + di[k]
            jj = node[1] + dj[k]
            if isOutOfRange(ii, jj) or visited[ii][jj] or arr[ii][jj] == '0':
                continue
            visited[ii][jj] = True
            dq.append([ii, jj, node[2] + 1])


N, M = map(int, input().split())
arr = []
for _ in range(N):
    arr.append(list(input().strip()))
bfs(0, 0)
