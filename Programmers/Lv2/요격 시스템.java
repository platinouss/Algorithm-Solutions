/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 요격 시스템 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/181188
 */

import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (o1, o2) -> {
            return o1[1] - o2[1];
        });

        int count = 1;
        double now = (double) targets[0][1] - 0.1;
        for (int i=1; i<targets.length; i++) {
            double start = targets[i][0];
            if (now < start) {
                count++;
                now = (double) targets[i][1] - 0.1;
            }
        }
        return count;
    }
}