/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 양과 늑대 (Lv3)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/92343
 */

import java.util.*;

class Solution {

    static int N;
    static int max;
    static boolean[] visited;
    static List<List<Integer>> nodes = new ArrayList<>();

    public int solution(int[] info, int[][] edges) {
        N = info.length;
        visited = new boolean[N];
        for (int i=0; i<N; i++) {
            nodes.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            nodes.get(edge[0]).add(edge[1]);
        }
        visited[0] = true;
        List<Integer> tmp = new ArrayList<>();
        tmp.addAll(nodes.get(0));
        combination(1, 0, tmp, info);
        return max;
    }

    private static void combination(int sheepCount, int wolfCount, List<Integer> list, int[] info) {
        if (sheepCount <= wolfCount) {
            return;
        }
        max = Math.max(max, sheepCount);
        int M = list.size();
        for (int i=0; i<M; i++) {
            int value = list.get(i);
            if (visited[value]) {
                continue;
            }
            visited[value] = true;
            List<Integer> tmp = new ArrayList<>(list);
            tmp.addAll(nodes.get(value));
            if (info[value] == 0) { combination(sheepCount + 1, wolfCount, tmp, info); }
            else { combination(sheepCount, wolfCount + 1, tmp, info); }
            visited[value] = false;
        }
    }
}