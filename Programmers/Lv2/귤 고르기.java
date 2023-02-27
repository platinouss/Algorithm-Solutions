/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 귤 고르기 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/138476
 */

import java.util.*;

class Solution {

    static Map<Integer, Integer> map = new HashMap<>();

    public int solution(int k, int[] tangerine) {
        Set<Integer> set = new HashSet<>();
        for (int v : tangerine) {
            map.put(v, map.getOrDefault(v, 0) + 1);
            set.add(v);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            return map.get(o1) - map.get(o2);
        });
        pq.addAll(set);

        int length = 0;
        int total = tangerine.length;
        while (total > k) {
            int idx = pq.remove();
            total -= map.get(idx);
            if (total < k) {
                return pq.size() + 1;
            }
        }

        return pq.size();
    }
}