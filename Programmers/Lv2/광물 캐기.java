/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 광물 캐기 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/172927
 */

import java.util.*;

class Solution {

    static int N;
    static int min = Integer.MAX_VALUE;

    public int solution(int[] picks, String[] minerals) {
        for (int pick : picks) {
            N += pick;
        }
        System.out.println(N);
        combination(0, 0, 0, picks, minerals);
        return min;
    }

    private static void combination(int index, int count, int total, int[] picks, String[] minerals) {
        if (count == N || index >= minerals.length) {
            min = Math.min(min, total);
            return;
        }
        for (int k=0; k<3; k++) {
            if (picks[k] == 0) {
                continue;
            }
            int tmp = 0;
            for (int i=index; i<index+5; i++) {
                if (i >= minerals.length) {
                    break;
                }
                tmp += getScore(k, minerals[i]);
            }
            picks[k]--;
            combination(index + 5, count + 1, total + tmp, picks, minerals);
            picks[k]++;
        }
    }

    private static int getScore(int k, String mineral) {
        if (mineral.equals("diamond")) {
            return (int) Math.pow(5, k);
        }
        if (mineral.equals("iron")) {
            return (k == 2) ? 5 : 1;
        }
        return 1;
    }
}