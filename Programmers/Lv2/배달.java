/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 배달 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12978
 */

import java.util.*;

class Solution {

    static int count = 0;
    static int[] arr;
    static List<List<Node>> list = new ArrayList<>();
    static PriorityQueue<Node> pq = new PriorityQueue<>();

    public int solution(int N, int[][] road, int K) {
        arr = new int[N + 1];
        Arrays.fill(arr, Integer.MAX_VALUE);

        for (int i=0; i<=N; i++) {
            list.add(new ArrayList<>());
        }

        for (int[] r : road) {
            list.get(r[0]).add(new Node(r[1], r[2]));
            list.get(r[1]).add(new Node(r[0], r[2]));
        }

        arr[1] = 0;
        pq.add(new Node(1, 0));
        while (!pq.isEmpty()) {
            Node node = pq.remove();
            if (node.distance > arr[node.idx]) {
                continue;
            }
            for (Node n : list.get(node.idx)) {
                if (arr[node.idx] + n.distance > arr[n.idx]) {
                    continue;
                }
                arr[n.idx] = arr[node.idx] + n.distance;
                pq.add(n);
            }
        }

        for (int i=1; i<=N; i++) {
            if (arr[i] <= K) {
                count++;
            }
        }

        return count;
    }
}

class Node implements Comparable<Node> {
    int idx, distance;

    public Node(int i, int d) {
        this.idx = i;
        this.distance = d;
    }

    @Override
    public int compareTo(Node n) {
        return this.distance - n.distance;
    }
}