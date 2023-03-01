/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 더 맵게 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42626
 */

import java.util.*;

class Solution {

    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public int solution(int[] scoville, int K) {
        for (int v : scoville) {
            pq.add(v);
        }

        int count = 0;
        while (!pq.isEmpty() && pq.peek() < K) {
            int v1 = pq.remove();
            if (pq.isEmpty()) {
                return -1;
            }
            int v2 = pq.remove() * 2;
            pq.add(v1 + v2);
            count++;
        }

        return count;
    }
}