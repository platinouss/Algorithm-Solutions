/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : N으로 표현 (Lv3)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42895
 */

import java.util.*;

class Solution {

    static List<Set<Integer>> list = new ArrayList<>();

    public int solution(int N, int number) {
        if (number == N) {
            return 1;
        }
        for (int i=0; i<9; i++) {
            list.add(new HashSet<>());
        }
        list.get(1).add(N);
        for (int i=2; i<9; i++) {
            for (int j=1; j<=(i/2); j++) {
                union(i, i-j, j);
                union(i, j, i-j);
            }
            String num = Integer.toString(N);
            list.get(i).add(Integer.parseInt(num.repeat(i)));
            for (int value : list.get(i)) {
                if (number == value) {
                    return i;
                }
            }
        }
        return -1;
    }

    private static void union(int now, int a, int b) {
        Set<Integer> set = list.get(now);
        for (int v1 : list.get(a)) {
            for (int v2 : list.get(b)) {
                set.add(v1 + v2);
                set.add(v1 - v2);
                set.add(v1 * v2);
                if (v2 != 0) {
                    set.add(v1 / v2);
                }
            }
        }
    }
}