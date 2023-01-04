/**
 * 백준 21939번 (골드 4)
 * 문제 이름 : 문제 추천 시스템 Version 1
 * 알고리즘 분류 : 이진 검색 트리
 * 링크 : https://www.acmicpc.net/problem/21939
 */

import java.util.*;
import java.io.*;

public class Main {

    static class Node implements Comparable<Node> {
        int number, difficulty;
        public Node(int n, int d) {
            this.number = n;
            this.difficulty = d;
        }
        @Override
        public int compareTo(Node o) {
            if (this.difficulty == o.difficulty) {
                return this.number - o.number;
            }
            return this.difficulty - o.difficulty;
        }
    }

    static TreeSet<Node> set = new TreeSet<>();
    static Set<Integer> trash = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            int difficulty = Integer.parseInt(st.nextToken());
            set.add(new Node(number, difficulty));
        }

        int K = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        for (int i=0; i<K; i++) {
            String[] arr = br.readLine().split(" ");
            String command = arr[0];
            if (command.equals("add")) {
                set.add(new Node(Integer.parseInt(arr[1]), Integer.parseInt(arr[2])));
            }
            if (command.equals("recommend")) {
                int value = Integer.parseInt(arr[1]);
                if (value == 1) {
                    while (true) {
                        int lastValue = set.last().number;
                        if (!trash.contains(lastValue)) {
                            break;
                        }
                        set.pollLast();
                        trash.remove(lastValue);
                    }
                    sb.append(set.last().number).append("\n");
                }
                if (value == -1) {
                    while (true) {
                        int firstValue = set.first().number;
                        if (!trash.contains(firstValue)) {
                            break;
                        }
                        set.pollFirst();
                        trash.remove(firstValue);
                    }
                    sb.append(set.first().number).append("\n");
                }
            }
            if (command.equals("solved")) {
                trash.add(Integer.parseInt(arr[1]));
            }
        }
        System.out.print(sb);
    }
}