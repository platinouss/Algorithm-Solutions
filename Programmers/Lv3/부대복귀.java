/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 부대복귀 (Lv3)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/132266
 */

import java.util.*;

class Solution {

    static int[] arr;
    static List<List<Integer>> list = new ArrayList<>();
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        for (int i=0; i<=n; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            list.get(road[0]).add(road[1]);
            list.get(road[1]).add(road[0]);
        }

        arr = new int[n + 1];
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[destination] = 0;
        pq.add(destination);
        while (!pq.isEmpty()) {
            int index = pq.remove();
            for (int next : list.get(index)) {
                if (arr[index] + 1 < arr[next]) {
                    arr[next] = arr[index] + 1;
                    pq.add(next);
                }
            }
        }

        int[] answer = new int[sources.length];
        for (int i=0; i<sources.length; i++) {
            answer[i] = (arr[sources[i]] == Integer.MAX_VALUE) ? -1 : arr[sources[i]];
        }
        return answer;
    }
}