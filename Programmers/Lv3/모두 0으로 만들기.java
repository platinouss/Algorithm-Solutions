/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 모두 0으로 만들기 (Lv3)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/76503
 */

import java.util.*;

class Solution {

    static int[] indegree;
    static List<Node> nodes = new ArrayList<>();
    static List<List<Integer>> list = new ArrayList<>();

    public long solution(int[] a, int[][] edges) {
        for (int i=0; i<a.length; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }
        indegree = new int[a.length];
        for (int i=0; i<a.length; i++) {
            nodes.add(new Node(i, a[i]));
            indegree[i] = list.get(i).size();
        }
        long totalCount = 0;
        Queue<Node> q = new LinkedList<>();
        for (int i=0; i<a.length; i++) {
            if (indegree[i] <= 1) {
                q.add(nodes.get(i));
            }
        }
        boolean check = true;
        boolean[] finished = new boolean[a.length];
        while (!q.isEmpty()) {
            Node node = q.remove();
            if (indegree[node.index] == 0) {
                if (node.count != 0) {
                    check = false;
                }
                break;
            }
            int index = 0;
            while (finished[list.get(node.index).get(index)]) {
                index++;
            }
            int nextIndex = list.get(node.index).get(index);
            nodes.get(nextIndex).count += node.count;
            totalCount += Math.abs(node.count);
            node.count = 0;
            for (int idx : list.get(node.index)) {
                indegree[idx]--;
                if (indegree[idx] == 1) {
                    q.add(nodes.get(idx));
                }
            }
            finished[node.index] = true;
        }
        if (!check) {
            totalCount = -1;
        }
        return totalCount;
    }
}

class Node {
    int index;
    long count;

    public Node(int index, long count) {
        this.index = index;
        this.count = count;
    }
}