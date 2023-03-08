/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 다리를 지나는 트럭 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42583
 */

import java.util.*;

class Solution {

    static int N;
    static Queue<Node> q = new LinkedList<>();

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        N = truck_weights.length;

        int time = 0;
        int index = 0;
        int total = 0;
        while (index < N || !q.isEmpty()) {
            time++;
            upCount();
            if (!q.isEmpty()) {
                if (q.peek().count > bridge_length) {
                    total -= q.remove().weight;
                }
            }
            if (index < N && truck_weights[index] + total <= weight) {
                total += truck_weights[index];
                q.add(new Node(truck_weights[index++], 1));
            }
        }
        return time;
    }

    private static void upCount() {
        for (Node node : q) {
            node.count += 1;
        }
    }
}

class Node {
    int weight, count;

    public Node (int w, int c) {
        this.weight = w;
        this.count = c;
    }
}