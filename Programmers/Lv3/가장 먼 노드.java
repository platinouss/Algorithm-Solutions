/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : [3차] 가장 먼 노드 (Lv3)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/49189
 */

import java.util.*;

class Solution {

    static int[] arr;
    static List<List<Integer>> list = new ArrayList<>();
    static Queue<Integer> q = new LinkedList<>();

    public int solution(int n, int[][] edge) {
        arr = new int[n + 1];
        for (int i=2; i<=n; i++) {
            arr[i] = Integer.MAX_VALUE;
        }

        for (int i=0; i<=n; i++) {
            list.add(new ArrayList<>());
        }

        for (int[] e : edge) {
            list.get(e[0]).add(e[1]);
            list.get(e[1]).add(e[0]);
        }

        q.add(1);
        while (!q.isEmpty()) {
            int index = q.remove();
            for (int idx : list.get(index)) {
                if (arr[index] + 1 < arr[idx]) {
                    arr[idx] = arr[index] + 1;
                    q.add(idx);
                }
            }
        }

        int max = 0;
        int count = 0;
        for (int i=2; i<=n; i++) {
            if (max == arr[i]) {
                count++;
            }
            if (max < arr[i]) {
                max = arr[i];
                count = 1;
            }
        }

        return count;
    }
}