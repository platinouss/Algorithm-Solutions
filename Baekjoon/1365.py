"""
 [Baekjoon] 1365. 꼬인 전깃줄
 https://www.acmicpc.net/problem/1365

 접근 방식
 1) 꼬이지 않은 전봇대의 최대 개수를 구하고자 한다.
 2) list를 생성한 후, 순차적으로 전봇대를 탐색하며 오른편 전봇대 번호를 추가한다.
    2-1) 이때, list의 마지막 원소가 추가하고자 하는 오른쪽 전봇대 번호보다 클 경우, 꼬여있는 전봇대로 판단
    2-2) 따라서, 이진 탐색을 통해 추가하고자 하는 오른쪽 전봇대 번호보다 크면서 가장 작은 인덱스 번호를 찾는다.
    2-3) 해당 인덱스의 원소를 추가하려는 오른쪽 전봇대의 번호로 변경한다.
 3) list의 길이는 꼬이지 않은 전봇대의 최대 개수이므로 N에서 해당 값를 빼면 잘라내야 할 전선의 최소 개수를 구할 수 있다.
"""

import sys
from bisect import bisect_left

input = sys.stdin.readline


if __name__ == "__main__":
    N = int(input())
    arr = tuple(map(int, input().split()))
    dp = []
    for value in arr:
        if not dp:
            dp.append(value)
        if dp[-1] < value:
            dp.append(value)
        else:
            dp[bisect_left(dp, value)] = value
    print(N - len(dp))

