"""
 [Baekjoon] 13460. 구슬 탈출 2
 https://www.acmicpc.net/problem/13460

 접근 방식
 1) 10번 이내로, 보드를 상/하/좌/우로 움직인다.
    1-1) 이때, 빨간공과 파란공은 벽을 만나기 전까지 특정 방향으로 한칸씩 움직인다. 구멍을 만났을 때는 움직임을 중단한다.
    1-2) 만약 빨간공과 파란공의 위치가 동일할 때는, 많이 움직인 공을 한칸 뒤로 옮긴다.
    1-3) 파란공이 먼저 빠져나갔다면, 해당 경우는 제외한다.
 2) 빨간 공이 먼저 빠져나갔다면 보드 움직인 횟수를 출력한다.
 2) 보드 움직임이 10번을 초과했다면, -1을 출력한다.
"""

import sys
from collections import deque

input = sys.stdin.readline


di = [-1, 1, 0, 0]
dj = [0, 0, -1, 1]


def getLocation():
    r = next([i, j, 0] for i in range(N) for j in range(M) if arr[i][j] == 'R')
    b = next([i, j, 0] for i in range(N) for j in range(M) if arr[i][j] == 'B')
    exit = next([i, j, 0] for i in range(N) for j in range(M) if arr[i][j] == 'O')
    return r, b, exit


def moveBall(position, k):
    row, col, cnt = position[0], position[1], 0
    while arr[row + di[k]][col + dj[k]] != '#':
        row += di[k]
        col += dj[k]
        cnt += 1
        if arr[row][col] == 'O':
            break
    return [row, col, cnt]


def moveBallToAvoidOverlap(r, b, k):
    if r[2] > b[2]:
        r[0] -= di[k]
        r[1] -= dj[k]
    elif r[2] < b[2]:
        b[0] -= di[k]
        b[1] -= dj[k]


N, M = map(int, input().split())
arr = ['#' for _ in range(N)]
visited = [[[[False for _ in range(M)] for _ in range(N)] for _ in range(M)] for _ in range(N)]
for i in range(N):
    arr[i] = input().strip()
red, blue, exit = getLocation()
dq = deque()
dq.append([red, blue, 0])
visited[red[0]][red[1]][blue[0]][blue[1]] = True
while dq:
    node = dq.popleft()
    if node[2] >= 10:
        break
    for k in range(len(di)):
        r = moveBall(node[0], k)
        b = moveBall(node[1], k)
        if b[0] == exit[0] and b[1] == exit[1]:
            if not (r[0] == b[0] and r[1] == b[1]):
                continue
        if r[0] == b[0] and r[1] == b[1]:
            if r[0] == exit[0] and r[1] == exit[1]:
                continue
            moveBallToAvoidOverlap(r, b, k)
        if r[0] == exit[0] and r[1] == exit[1]:
            print(node[2] + 1)
            sys.exit(0)
        if visited[r[0]][r[1]][b[0]][b[1]]:
            continue
        visited[r[0]][r[1]][b[0]][b[1]] = True
        dq.append([r, b, node[2] + 1])
print(-1)
