/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 입국심사 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/43238
 */

import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long min = 0;
        long max = (long) n * times[times.length-1];
        while (min < max) {
            long mid = (min + max) / 2;
            long sum = 0;
            for (int time : times) {
                sum += mid / (long) time;
            }
            if (n <= sum) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }
}