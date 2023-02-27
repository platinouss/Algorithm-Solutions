/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 최고의 집합 (Lv3)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12938
 */

import java.util.*;

class Solution {

    static int max = 0;
    static int[] result;

    public int[] solution(int n, int s) {
        if (n > s) {
            return new int[] {-1};
        }

        result = new int[n];
        getResult(n, s);

        return result;
    }

    private static void getResult(int n, int s) {
        int total = 0;
        int v = s / n;
        for (int i=0; i<n; i++) {
            result[i] = v;
            total += v;
        }

        int idx = n-1;
        for (int k=0; k<(s%n); k++) {
            result[idx]++;
            idx--;
        }
    }
}