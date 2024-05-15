"""
 [Baekjoon] 2533. 사회망 서비스(SNS)
 https://www.acmicpc.net/problem/2533

 접근 방식
 1) 각 노드는 얼리 아답터일 수도 있고 아닐 수도 있다. 하지만, 자식 노드가 얼리 아답터가 아니라면 해당 노드는 무조건 얼리 어답터이다.
 2) 따라서, 리프 노드부터 루트 노드까지 모든 경우의 수를 저장하여, 부모 노드의 경우의 수를 dp 배열에 저장하는 방식으로 문제를 해결한다.
 3) 특정 노드의 얼리 어답터일 경우의 수는, 모든 자식의 min(자식 노드의 얼리 어답터 경우, 자식 노드의 얼리 어답터가 아닌 경우)를 더한 값이다.
 4) 특정 노드의 얼리 어답터가 아닐 경우의 수는, 모든 자식의 얼리 어답터인 경우의 수를 더한 값이다.
 5) 루트 노드의 max(얼리 어답터인 경우의 수, 얼리 어답터가 아닌 경우의 수)를 출력한다.
"""

import sys

input = sys.stdin.readline
sys.setrecursionlimit(10**7)


def dfs(start):
    dp[start][1] = 1
    visited[start] = True
    for friend in friends[start]:
        if visited[friend]:
            continue
        dfs(friend)
        dp[start][0] += dp[friend][1]
        dp[start][1] += min(dp[friend][0], dp[friend][1])


N = int(input())
dp = [[0, 0] for _ in range(N + 1)]
friends = [[] for _ in range(N + 1)]
visited = [False for _ in range(N + 1)]
for _ in range(N - 1):
    start, end = map(int, input().split())
    friends[start].append(end)
    friends[end].append(start)
dfs(1)
print(min(dp[1][0], dp[1][1]))
