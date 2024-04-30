"""
 [Baekjoon] 2169. 로봇 조종하기
 https://www.acmicpc.net/problem/2169

 접근 방식
 1) 로봇은 왼쪽/오른쪽/아래쪽 방향으로만 움직이므로, 첫 번째 row는 (1,1)에서 오른쪽으로 가는 방법 밖에 없다.
    따라서, 누적 합 배열로 구성한다.
 2) 두 번째 row 부터는 바로 위 row의 특정 지점에서 내려오므로, 바로 위 row의 값을 그대로 물려받은 배열을 2개 선언한다.
    2-1) 첫 번째 배열은, 왼쪽 방향으로 움직이는 배열이다. 따라서 왼쪽에서 온 비용과 위에서 내려온 비용 중 큰 값으로 갱신한다.
    2-2) 두 번째 배열은, 오른쪽 방향으로 움직이는 배열이다. 오른쪽에서 온 비용과 위에서 내려온 비용 중 가장 큰 값으로 갱신한다.
    2-3) 해당 위치의 값은 첫 번째 배열과 두 번째 배열 중 큰 값으로 갱신한다.
 3) (N, M) 위치의 값을 반환한다.
"""

import sys

input = sys.stdin.readline


if __name__ == "__main__":
    N, M = map(int, input().split())
    arr = [list(map(int, input().split())) for _ in range(N)]
    for j in range(1, M):
        arr[0][j] = arr[0][j - 1] + arr[0][j]
    for i in range(1, N):
        right = list(map(lambda x: arr[i-1][x] + arr[i][x], range(M)))
        for j in range(1, M):
            right[j] = max(right[j], right[j-1] + arr[i][j])
        left = list(map(lambda x: arr[i-1][x] + arr[i][x], range(M)))
        for j in reversed(range(0, M-1)):
            left[j] = max(left[j], left[j+1] + arr[i][j])
        arr[i] = list(map(lambda x: max(right[x], left[x]), range(M)))
    print(arr[-1][-1])
