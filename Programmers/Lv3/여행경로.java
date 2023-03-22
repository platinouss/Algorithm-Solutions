/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 여행경로 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/43164
 */

import java.util.*;

class Solution {

    static String[] answer;
    static boolean check = false;
    static Map<String, Map<String, Integer>> map = new HashMap<>();

    public String[] solution(String[][] tickets) {
        for (String[] ticket : tickets) {
            if (!map.containsKey(ticket[0])) {
                map.put(ticket[0], new TreeMap<>());
            }
            map.get(ticket[0]).put(ticket[1], map.get(ticket[0]).getOrDefault(ticket[1], 0) + 1);
        }

        answer = new String[tickets.length + 1];
        combination(0, "ICN", tickets.length + 1);

        return answer;
    }

    private static void combination(int depth, String startCity, int N) {
        if (depth == N - 1) {
            answer[depth] = startCity;
            check = true;
            return;
        }

        if (!map.containsKey(startCity)) {
            return;
        }

        answer[depth] = startCity;
        for (String next : map.get(startCity).keySet()) {
            if (map.get(startCity).get(next) == 0) {
                continue;
            }
            if (check) {
                return;
            }
            map.get(startCity).put(next, map.get(startCity).get(next) - 1);
            combination(depth + 1, next, N);
            map.get(startCity).put(next, map.get(startCity).get(next) + 1);
        }
    }
}