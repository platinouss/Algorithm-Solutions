"""
 [Baekjoon] 1874. 스택 수열
 https://www.acmicpc.net/problem/1874

 접근 방식
 1) 입력된 수열을 만들기 위해서는, stack의 최상단 값이 수열의 원소이거나,
    stack에 추가할 정수 번호가 다음 수열의 원소 번호보다 작을 때만 가능하다.
 2) 1번의 경우에는 적절한 push, pop 연산을 진행하고, 1번을 제외한 모든 경우에서는 NO를 출력한다.
"""

import sys

input = sys.stdin.readline


if __name__ == "__main__":
    N = int(input())
    arr = [int(input()) for _ in range(N)]
    num = 1
    stack = []
    result = []
    for i in range(N):
        value = arr[i]
        if stack and stack[-1] == value:
            stack.pop()
            result.append('-')
        elif num <= value:
            result += ['+'] * (value - num + 1) + ['-']
            stack += list(range(num, value))
            num = value + 1
        else:
            print('NO')
            exit(0)
    print("\n".join(result))

