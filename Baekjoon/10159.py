"""
 [Baekjoon] 10159. 저울
 https://www.acmicpc.net/problem/10159

 접근 방식
 1) 물건의 크기를 비교할 수 있는지 판단해야 하기 때문에, 2차원 배열 생성 후 단방향 그래프로 생각하고 문제를 해결한다.
    1-1) 예를 들어, 2번 물건이 1번 물건보다 크다면, arr[1][2] = 1로 대입한다.
 2) 이후, 시작점에서 특정 지점을 거쳐 종료 지점으로 갈 수 있는지 플로이드 워셜 알고리즘 이용하여 판단한다.
 3) A -> B, B -> A로 갈 수 있다면 무게를 측정할 수 있다고 판단할 수 있음
 4) 특정 물건에서 무게를 측정할 수 없는 물건의 개수를 카운팅한 후 출력한다.
"""

import sys

input = sys.stdin.readline


N = int(input())
K = int(input())
arr = [[0 for _ in range(N)] for _ in range(N)]
for _ in range(K):
    big, small = map(int, input().split())
    arr[small - 1][big - 1] = 1
for k in range(N):
    for i in range(N):
        for j in range(N):
            if arr[i][k] and arr[k][j]:
                arr[i][j] = 1
result = []
for i in range(N):
    cnt = 0
    for j in range(N):
        if not arr[i][j] and not arr[j][i]:
            cnt += 1
    result.append(str(cnt - 1))
print('\n'.join(result))
