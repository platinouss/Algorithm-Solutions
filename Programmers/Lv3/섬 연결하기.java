/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 섬 연결하기 (Lv3)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42861
 */

import java.util.*;

class Solution {

    static int[] arr;
    static PriorityQueue<Node> pq = new PriorityQueue<>();

    public int solution(int n, int[][] costs) {
        arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = i;
        }

        for (int[] cost : costs) {
            pq.add(new Node(cost[0], cost[1], cost[2]));
        }

        int count = 0;
        int answer = 0;
        while (count < n-1) {
            Node node = pq.remove();
            if (find(node.i) == find(node.j)) {
                continue;
            }
            union(node.i, node.j);
            answer += node.distance;
            count++;
        }
        return answer;
    }


    private static void union(int idx1, int idx2) {
        int v1 = find(idx1);
        int v2 = find(idx2);

        if (v1 < v2) {
            arr[v2] = v1;
        } else {
            arr[v1] = v2;
        }
    }

    private static int find(int idx) {
        if (arr[idx] == idx) {
            return idx;
        }
        return arr[idx] = find(arr[idx]);
    }
}

class Node implements Comparable<Node> {
    int i, j, distance;

    public Node(int i, int j, int d) {
        this.i = i;
        this.j = j;
        this.distance = d;
    }

    @Override
    public int compareTo(Node n) {
        return this.distance - n.distance;
    }
}