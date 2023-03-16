/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 징검다리 건너기 (Lv3)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/64062
 */

import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        int min = 1;
        int max = 200_000_000;
        while (min < max) {
            int mid = (min + max) / 2 + 1;
            if (check(mid, k, stones)) {
                min = mid;
            } else {
                max = mid - 1;
            }
        }

        return min;
    }

    private static boolean check(int mid, int k, int[] stones) {
        int count = 0;
        for (int i=0; i<stones.length; i++) {
            if (stones[i] < mid) {
                count++;
                if (count >= k) {
                    return false;
                }
            } else {
                count = 0;
            }

        }
        return true;
    }
}