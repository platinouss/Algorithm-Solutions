/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 호텔 대실 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/155651
 */

import java.util.*;

class Solution {

    static List<Node> list = new ArrayList<>();
    static PriorityQueue<Node> pq = new PriorityQueue<>();

    public int solution(String[][] book_time) {
        for (String[] time : book_time) {
            String[] start = time[0].split(":");
            String[] end = time[1].split(":");
            pq.add(new Node(strToInt(start), strToInt(end)));
        }

        int count = 1;
        while (!pq.isEmpty()) {
            Node node = pq.remove();
            for (Node n : list) {
                if (n.end + 10 <= node.start) {
                    list.remove(n);
                    break;
                }
            }
            list.add(node);
        }

        return list.size();
    }

    private static int strToInt(String[] time) {
        return Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
    }
}

class Node implements Comparable<Node> {
    int start, end;

    public Node(int s, int e) {
        this.start = s;
        this.end = e;
    }

    @Override
    public int compareTo(Node n) {
        if (this.start == n.start) {
            return this.end - n.end;
        }
        return this.start - n.start;
    }
}