"""
 [Baekjoon] 7570. 줄 세우기
 https://www.acmicpc.net/problem/7570

 접근 방식
 1) 번호 순서대로 줄을 세워야 하므로, 현재 연속적으로 증가하는 수열의 원소 개수를 구한다.
    1-1) 이때, 연속적으로 증가하는 수열이 여러 개일 때, 가장 원소의 개수가 큰 수열을 찾는다.
 2) 연속적으로 증가하는 수열의 원소는 옮기지 않아도 되는 원소를 뜻한다.
 3) 문제에서 위치를 옮겨야 하는 어린이의 수를 출력하라고 했으므로, N - (연속적으로 증가하는 수열의 원소 개수)를 출력한다.
    3-1) 한 번의 비용으로 원하는 위치에 숫자를 배치할 수 있기 때문이다.
"""

import sys

input = sys.stdin.readline


if __name__ == "__main__":
    N = int(input())
    arr = list(map(int, input().split()))
    dic = [0] * (N+1)
    for i in range(N):
        dic[arr[i]] = i
    result = 1
    count = 1
    for i in range(1, N):
        if dic[i] < dic[i+1]:
            count += 1
        else:
            result = max(result, count)
            count = 1
    print(N - result)
