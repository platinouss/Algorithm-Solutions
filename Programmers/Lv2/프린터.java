/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 프린터 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42587
 */

import java.util.*;

class Solution {

    static int N;
    static int[] result;
    static Queue<Integer> q = new LinkedList<>();
    static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

    public int solution(int[] priorities, int location) {
        N = priorities.length;
        for (int i=0; i<N; i++) {
            q.add(i);
        }
        for (int p : priorities) {
            pq.add(p);
        }

        int order = 1;
        result = new int[N];
        while (!q.isEmpty()) {
            int idx = q.remove();
            int v = pq.peek();
            if (v == priorities[idx]) {
                pq.remove();
                result[idx] = order;
                order++;
            } else {
                q.add(idx);
            }
        }


        return result[location];
    }
}