"""
 [Baekjoon] 11724. 연결 요소의 개수
 https://www.acmicpc.net/problem/11724

 접근 방식
 1) 간선을 하나 탐색하면서 연결된 노드를 모두 탐색한다. 이후 count를 1 증가 시킨다.
    1-1) 이때 탐색한 노드는 방문 완료로 체크한다.
 2) count 값을 출력한다.
"""

import sys

sys.setrecursionlimit(10 ** 5)
input = sys.stdin.readline


def dfs(index):
    for idx in arr[index]:
        if not visited[idx]:
            visited[idx] = True
            dfs(idx)


if __name__ == "__main__":
    N, K = map(int, input().split())
    arr = [[] for _ in range(N + 1)]
    visited = [False] * (N+1)
    for _ in range(K):
        s, e = map(int, input().split())
        arr[s].append(e)
        arr[e].append(s)
    count = 0
    for i in range(1, N+1):
        if not visited[i]:
            visited[i] = True
            count += 1
            dfs(i)
    print(count)
