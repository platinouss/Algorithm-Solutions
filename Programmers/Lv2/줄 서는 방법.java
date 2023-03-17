/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 줄 서는 방법 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12936
 */

import java.util.*;

class Solution {

    static int[] arr;
    static boolean[] visited;

    public int[] solution(int n, long k) {
        arr = new int[n];
        visited = new boolean[n + 1];
        int[] answer = new int[n];

        k--;
        int index = 0;
        while (n > 0) {
            n--;
            long v = factorial(n);
            answer[index++] = getNumber(k / v);
            k -= (v * (k / v));
        }

        return answer;
    }

    private static int getNumber(long index) {
        long idx = 0;
        for (int i=1; i<=arr.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (index == idx) {
                visited[i] = true;
                return i;
            }
            idx++;
        }
        return -1;
    }

    private static long factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n-1);
    }
}