/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 인사고과 (Lv3)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/152995
 */

import java.util.*;

class Solution {

    static int[] wanHo;
    static List<Integer> list = new ArrayList<>();

    public int solution(int[][] scores) {
        int max = 0;
        wanHo = scores[0];
        Arrays.sort(scores, (a, b) -> {
            return a[0] == b[0] ? a[1] - b[1] : b[0] - a[0];
        });
        for (int[] score : scores) {
            if (score[1] < max) {
                if (score.equals(wanHo)) { return -1; }
            } else {
                list.add(score[0] + score[1]);
                max = Math.max(max, score[1]);
            }
        }
        list.sort((a, b) -> b - a);
        return list.indexOf(wanHo[0] + wanHo[1]) + 1;
    }
}