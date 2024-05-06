"""
 [Baekjoon] 2283. 구간 자르기
 https://www.acmicpc.net/problem/2283

 접근 방식
 1) 각 인덱스마다 총 수직선의 길이를 저장하는 누적 합 배열(dp)을 선언한다.
    1-1) 이때, 양 끝점의 위치는 0 - 1,000,000 이 될 수 있고, 선분의 개수는 1000개 이므로,
         각 선분별로 배열을 갱신하면 시간 초과가 날 것이다. 따라서, 선분의 시작 지점과 마지막 지점만 체크해둔다.
 2) 1-1번에서 체크한 선분의 시작/종료 지점을 바탕으로, 0번 인덱스부터 특정 인덱스까지의 모든 선분 길이의 누적 합을 저장한다.
 3) 시작과 끝을 체크하는 포인터를 선언하고, 각 포인터를 적절하게 움직여서 선분의 총합이 K가 되는 지점을 출력한다.
"""

import sys

input = sys.stdin.readline


N, K = map(int, input().split())
dp = [0] * 1_000_002
for _ in range(N):
    start, end = map(int, input().split())
    dp[start + 1] += 1
    dp[end + 1] -= 1
current = 0
for i in range(1, 1_000_001):
    current += dp[i]
    dp[i] = dp[i-1] + current
s, e = 0, 0
while s < 1_000_001 and e < 1_000_001:
    if dp[e] - dp[s] == K:
        print(str(s) + ' ' + str(e))
        exit(0)
    elif dp[e] - dp[s] < K:
        e += 1
    else:
        s += 1
print('0 0')
