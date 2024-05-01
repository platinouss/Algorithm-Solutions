"""
 [Baekjoon] 17298. 오큰수
 https://www.acmicpc.net/problem/17298

 접근 방식
 1) 주어진 arr 배열을 뒤에서부터 순차적으로 탐색한다.
    1-1) stack이 비어있다면 -1을 result에 추가한다.
    1-2) stack[-1]이 arr 원소의 값보다 크다면 오큰수라는 뜻이므로 result에 stack[-1]을 추가한다.
    1-3) stack[-1]이 arr 원소의 값보다 작거나 같다면 오큰수가 나올 때까지 pop한다.
         오큰수를 찾았다면 reulst에 추가하고, stack이 empty된다면 -1을 result에 추가한다.
 2) result를 역순으로 출력한다.
"""

import sys

input = sys.stdin.readline


if __name__ == "__main__":
    N = int(input())
    arr = list(map(int, input().split()))
    stack = []
    result = []
    for value in reversed(arr):
        if not stack:
            result.append(-1)
        elif stack[-1] > value:
            result.append(stack[-1])
        else:
            while stack and stack[-1] <= value:
                stack.pop()
            if not stack:
                result.append(-1)
            else:
                result.append(stack[-1])
        stack.append(value)
    print(" ".join(map(str, reversed(result))))
