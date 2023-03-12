/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 숫자 변환하기 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/154538
 */

import java.util.*;

class Solution {

    static Map<Integer, Integer> map = new HashMap<>();

    public int solution(int x, int y, int n) {
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        map.put(x, 0);

        while (!q.isEmpty()) {
            int v = q.remove();
            if (v == y) {
                return map.get(v);
            }
            if ((v + n) <= y && !map.containsKey(v + n)) {
                map.put(v + n, map.get(v) + 1);
                q.add(v + n);
            }
            if ((v * 2) <= y && !map.containsKey(v * 2)) {
                map.put(v * 2, map.get(v) + 1);
                q.add(v * 2);
            }
            if ((v * 3) <= y && !map.containsKey(v * 3)) {
                map.put(v * 3, map.get(v) + 1);
                q.add(v * 3);
            }
        }

        return -1;
    }
}