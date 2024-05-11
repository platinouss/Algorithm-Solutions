"""
 [Baekjoon] 10800. 컬러볼
 https://www.acmicpc.net/problem/10800

 접근 방식
 1) 입력으로 받은 공을 크기 순으로 정렬한다. 이때 크기가 동일하다면 색상 번호로 정렬한다.
 2) 순차적으로 공을 탐색하면서, 모든 공의 크기와 색상별 공의 크기의 누적합을 저장해둔다.
 3) 특정 공의 결과를 도출할 때, (모든 공 크기 누적합 - 해당 색상 크기 누적합)으로 저장한다.
"""

import sys

input = sys.stdin.readline


N = int(input())
balls = []
for i in range(N):
    color, size = map(int, input().split())
    balls.append((i, color, size))
balls.sort(key=lambda x: (x[2], x[1]))
prev = 0
total = 0
result = [0] * N
colorSum = [0] * (N+1)
for i in range(N):
    while balls[prev][2] < balls[i][2]:
        colorSum[balls[prev][1]] += balls[prev][2]
        total += balls[prev][2]
        prev += 1
    result[balls[i][0]] = str(total - colorSum[balls[i][1]])
print('\n'.join(result))
