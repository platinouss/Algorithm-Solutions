/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 야근 지수 (Lv3)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12927
 */

import java.util.*;

class Solution {

    static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

    public long solution(int n, int[] works) {
        for (int work : works) {
            pq.add(work);
        }
        while (n > 0 && !pq.isEmpty()) {
            int v = pq.remove() - 1;
            n--;
            if (v > 0) {
                pq.add(v);
            }
        }

        long answer = 0;
        while (!pq.isEmpty()) {
            answer += Math.pow(pq.remove(), 2);
        }
        return answer;
    }
}