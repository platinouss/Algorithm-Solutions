/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 해시 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42578
 */

import java.util.*;

class Solution {

    static int N;
    static int result;
    static List<String> list;
    static Map<String, Integer> map = new HashMap<>();

    public int solution(String[][] clothes) {
        for (String[] cloth : clothes) {
            map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1);
        }
        list = new ArrayList<>(map.keySet());
        N = list.size();

        combination(0, N, 0, 1);

        return result;
    }

    private static void combination(int depth, int length, int index, int count) {
        if (depth == length) {
            result = (count - 1);
            return;
        }
        for (int i=index; i<N; i++) {
            combination(depth + 1, length, i+1, count * (map.get(list.get(i)) + 1));
        }
    }
}