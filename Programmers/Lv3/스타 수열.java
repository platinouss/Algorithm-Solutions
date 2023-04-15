/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 스타 수열 (Lv3)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/70130
 */

import java.util.*;

class Solution {

    static int N;
    static int max;
    static Map<Integer, Integer> map = new HashMap<>();

    public int solution(int[] a) {
        N = a.length;
        for (int v : a) {
            map.put(v, map.getOrDefault(v, 0) + 1);
        }

        for (int v : map.keySet()) {
            if (map.get(v) * 2 <= max) {
                continue;
            }
            int len = 0;
            for (int i=0; i<N-1; i++) {
                int v1 = a[i];
                int v2 = a[i + 1];
                if (v1 != v2 && (v1 == v || v2 == v)) {
                    len += 2;
                    i++;
                }
            }
            max = Math.max(max, len);
        }
        return max;
    }
}