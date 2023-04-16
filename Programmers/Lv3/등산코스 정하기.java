/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 등산코스 정하기 (Lv3)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/118669
 */

import java.util.*;

class Solution {

    static List<List<Node>> list = new ArrayList<>();

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        for (int i=0; i<=n; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] path : paths) {
            int s = path[0];
            int e = path[1];
            int w = path[2];
            if (isGate(s, gates) || isSummit(e, summits)) {
                list.get(s).add(new Node(e, w));
            }
            else if (isGate(e, gates) || isSummit(s, summits)) {
                list.get(e).add(new Node(s, w));
            } else {
                list.get(s).add(new Node(e, w));
                list.get(e).add(new Node(s, w));
            }
        }

        return dijkstra(n, gates, summits);
    }

    private static int[] dijkstra(int N, int[] gates, int[] summits) {
        Queue<Node> q = new LinkedList<>();
        int[] intensity = new int[N + 1];
        Arrays.fill(intensity, Integer.MAX_VALUE);
        for (int gate : gates) {
            q.add(new Node(gate, 0));
            intensity[gate] = 0;
        }

        while (!q.isEmpty()) {
            Node node = q.remove();
            if (intensity[node.e] < node.w) {
                continue;
            }
            for (Node endNode : list.get(node.e)) {
                int max = Math.max(intensity[node.e], endNode.w);
                if (max < intensity[endNode.e]) {
                    intensity[endNode.e] = max;
                    q.add(new Node(endNode.e, max));
                }
            }
        }

        int summitNum = N + 1;
        int minIntensity = Integer.MAX_VALUE;
        Arrays.sort(summits);
        for (int summit : summits) {
            if (minIntensity > intensity[summit]) {
                minIntensity = intensity[summit];
                summitNum = summit;
            }
        }
        return new int[] {summitNum, minIntensity};
    }

    private static boolean isGate(int num, int[] gates) {
        for (int gate : gates) {
            if (gate == num) {
                return true;
            }
        }
        return false;
    }

    private static boolean isSummit(int num, int[] summits) {
        for (int summit : summits) {
            if (summit == num) {
                return true;
            }
        }
        return false;
    }
}

class Node {
    int e, w;

    public Node(int e, int w) {
        this.e = e;
        this.w = w;
    }
}