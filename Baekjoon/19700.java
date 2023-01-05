/**
 * 백준 19700번 (골드 1)
 * 문제 이름 : 수업
 * 알고리즘 분류 : 이진 검색 트리, 그리디
 * 링크 : https://www.acmicpc.net/problem/19700
 */

import java.util.*;
import java.io.*;

public class Main {

    static class Node implements Comparable<Node> {
        int length, count;

        public Node(int l, int c) {
            this.length = l;
            this.count = c;
        }

        @Override
        public int compareTo(Node o) {
            return o.length - this.length;
        }
    }

    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static TreeMap<Integer, Integer> groups = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int length = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());
            pq.add(new Node(length, count));
        }

        int result = 0;
        while (!pq.isEmpty()) {
            int count = pq.remove().count;
            Integer key = groups.lowerKey(count);
            if (key == null) {
                groups.put(1, groups.getOrDefault(1, 0) + 1);
                result++;
            } else {
                if (groups.get(key) == 1) {
                    groups.remove(key);
                } else {
                    groups.put(key, groups.get(key) - 1);
                }
                groups.put(key + 1, groups.getOrDefault(key + 1, 0) + 1);
            }
        }

        System.out.println(result);
    }
}