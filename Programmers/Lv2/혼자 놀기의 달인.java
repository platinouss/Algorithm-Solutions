/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 혼자 놀기의 달인 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/131130
 */

import java.util.*;

class Solution {

    static int N;
    static int max = 0;
    static List<Integer> list = new ArrayList<>();

    public int solution(int[] cards) {
        N = cards.length;
        for (int i=0; i<N; i++) {
            list = new ArrayList<>();
            boolean[] visited = new boolean[N];
            setVisit(i, 0, visited, cards);
            combination(visited, cards);
        }
        return max;
    }

    private static void combination(boolean[] visited, int[] cards) {
        if (isFinish(visited)) {
            if (list.size() < 2) {
                max = 0;
                return;
            }
            Collections.sort(list);
            max = Math.max(max, list.get(list.size() - 1) * list.get(list.size() - 2));
            return;
        }

        for (int i=0; i<N; i++) {
            if (visited[i]) {
                continue;
            }
            setVisit(i, 0, visited, cards);
            combination(visited, cards);
        }
    }

    private static void setVisit(int index, int count, boolean[] visited, int[] cards) {
        if (visited[index]) {
            list.add(count);
            return;
        }
        visited[index] = true;
        setVisit(cards[index] - 1, count + 1, visited, cards);
    }

    private static boolean isFinish(boolean[] visited) {
        for (boolean check : visited) {
            if (!check) {
                return false;
            }
        }
        return true;
    }
}