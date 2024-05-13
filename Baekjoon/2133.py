"""
 [Baekjoon] 2133. 타일 채우기
 https://www.acmicpc.net/problem/2133

 접근 방식
 1) 길이가 2일 때 3가지 도형을 만들 수 있다. 또한 길이가 4이상 일 때는 특수한 도형 2개를 만들 수 있다.
 2) 길이가 N인 경우를 가정하고 해결해보자. dp배열은 해당 index 만큼의 길이일 때의 경우의 수이다.
    2-1) dp[N-2]인 경우, dp[N-2] * 3이다. 길이가 2일 때는 3가지 도형을 붙일 수 있다.
    2-2) dp[N-4]인 경우, dp[N-4] * 2이다. (1-1)과 겹치지 않고 길이가 4일 때 2가지 도형을 붙일 수 있다.
    2-3) dp[N-6]인 경우, 1-2와 동일하며 dp[2]까지 (1-3)을 반복한다
    2-4) 위 경우의 수에 포함되지 않는 경우는 2가지 이므로 추가해준다.
 3) 따라서 점화식은, dp[N] = dp[N-2] * 3 + dp[N-4] * 2 + ... dp[2] * 3 + 2이다.
"""

import sys

input = sys.stdin.readline

N = int(input())
if N <= 1:
    print(0)
    sys.exit(0)
dp = [0] * (N + 1)
dp[2] = 3
for i in range(4, N + 1):
    if i % 2 == 0:
        dp[i] = dp[i-2] * 3 + sum(dp[:i-2]) * 2 + 2
print(dp[N])
