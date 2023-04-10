/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 외벽 점검 (Lv3)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/60062
 */

import java.util.*;

class Solution {

    static int min;
    static int[] tmp;
    static boolean check;
    static int[][] weakCases;

    public int solution(int n, int[] weak, int[] dist) {
        min = dist.length + 1;
        tmp = new int[dist.length];
        weakCases = new int[weak.length][weak.length];

        makeWeakCase(n, weak);
        makeDistCase(0, 0, dist);

        if (min == dist.length + 1) {
            return -1;
        }
        return min;
    }

    private static void makeWeakCase(int n, int[] weak) {
        int[] weakCase = weak.clone();
        weakCases[0] = weakCase.clone();
        for(int i = 1; i < weak.length; i++){
            int tmp = weakCase[0];
            for(int j = 1; j < weak.length; j++){
                weakCase[j-1] = weakCase[j];
            }
            weakCase[weak.length-1] = tmp + n;
            weakCases[i] = weakCase.clone();
        }
    }

    private static void makeDistCase(int depth, int bitmask, int[] arr) {
        if (depth == arr.length) {
            for (int[] weakCase : weakCases) {
                getResult(weakCase, tmp);
            }
            return;
        }
        for (int i=0; i<arr.length; i++) {
            if ((bitmask & (1 << i)) > 0) {
                continue;
            }
            tmp[depth] = arr[i];
            makeDistCase(depth + 1, bitmask | (1 << i), arr);
            tmp[depth] = 0;
        }
    }

    private static void getResult(int[] weakCase, int[] distCase) {
        int weakIndex = 0;
        int distIndex = 0;
        while (weakIndex < weakCase.length && distIndex < distCase.length) {
            int next = weakIndex + 1;
            while (next < weakCase.length &&
                    weakCase[weakIndex] + distCase[distIndex] >= weakCase[next]) {
                next++;
            }
            weakIndex = next;
            distIndex++;
        }
        if (weakIndex >= weakCase.length && distIndex < min) {
            min = distIndex;
        }
    }
}