"""
 [Baekjoon] 11286. 절댓값 힙
 https://www.acmicpc.net/problem/11286

 접근 방식
 1) 우선순위 큐를 활용해 input 값이 0이면 절댓값이 가장 작은 값을 pop한 후 출력한다.
    1-1) 이때, 절댓값이 같은 수가 여러개 있다면 가장 작은 수를 pop한다.
"""

import sys
import heapq

input = sys.stdin.readline


if __name__ == "__main__":
    N = int(input())
    args = [int(input()) for _ in range(N)]
    pq = []
    result = []
    for arg in args:
        if arg == 0:
            result.append(str(heapq.heappop(pq)[1]) if pq else '0')
        else:
            heapq.heappush(pq, (abs(arg), arg))
    print("\n".join(result))
