/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 두 큐 합 같게 만들기 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/118667
 */

import java.util.*;

class Solution {

    static long mid;
    static Queue<Integer> q1 = new LinkedList<>();
    static Queue<Integer> q2 = new LinkedList<>();

    public long solution(int[] queue1, int[] queue2) {
        long sum1 = 0;
        long sum2 = 0;
        long size = (queue1.length + queue2.length) * 10;
        for (int v : queue1) {
            q1.add(v);
            sum1 += v;
        }
        for (int v : queue2) {
            q2.add(v);
            sum2 += v;
        }
        mid = (sum1 + sum2) / 2;

        if ((sum1 + sum2) % 2 == 1) {
            return -1;
        }

        long count = 0;
        while (true) {
            if (sum1 == sum2 || count > size) {
                break;
            }
            if (sum1 < mid) {
                int v = q2.remove();
                q1.add(v);
                sum1 += v;
                sum2 -= v;
                count++;
            } else {
                int v = q1.remove();
                q2.add(v);
                sum1 -= v;
                sum2 += v;
                count++;
            }
        }
        if (count > size) {
            return -1;
        }

        return count;
    }
}