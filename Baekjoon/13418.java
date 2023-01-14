/**
 * 백준 13418번 (골드 3)
 * 문제 이름 : 학교 탐방하기
 * 알고리즘 분류 : 그래프, 최소 스패닝 트리(최소 신장 트리)
 * 링크 : https://www.acmicpc.net/problem/13418
 */

import java.util.*;
import java.io.*;

public class Main {

    static class Node implements Comparable<Node> {
        int i, j, distance;

        public Node(int i, int j, int d) {
            this.i = i;
            this.j = j;
            this.distance = d;
        }

        @Override
        public int compareTo(Node n) {
            return n.distance - this.distance;
        }
    }

    static int[] arr;
    static List<List<Integer>> lines = new ArrayList<>();
    static PriorityQueue<Node> minPq = new PriorityQueue<>();
    static PriorityQueue<Node> maxPq = new PriorityQueue<>(Comparator.reverseOrder());

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken()) + 1;
        for (int i=0; i<=N; i++) {
            lines.add(new ArrayList<>());
        }
        boolean check = false;
        while (K-- > 0) {
            st = new StringTokenizer(br.readLine());
            int sIndex = Integer.parseInt(st.nextToken());
            int eIndex = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            minPq.add(new Node(sIndex, eIndex, v));
            maxPq.add(new Node(sIndex, eIndex, v));
            lines.get(sIndex).add(eIndex);
            lines.get(eIndex).add(sIndex);
        }
        System.out.println(getMaxResult(N) - getMinResult(N));
    }

    private static void init(int N) {
        arr = new int[N + 1];
        for (int i=1; i<=N; i++) {
            arr[i] = i;
        }
    }

    private static int getMinResult(int N) {
        init(N);
        int count = 0;
        int result = 0;
        while (count < N && !minPq.isEmpty()) {
            Node n = minPq.poll();
            if (find(n.i) == find(n.j)) {
                continue;
            }
            union(n.i, n.j);
            count++;
            if (n.distance == 0) {
                result++;
            }
        }
        return (int) Math.pow(result, 2);
    }

    private static int getMaxResult(int N) {
        init(N);
        int count = 0;
        int result = 0;
        while (count < N && !maxPq.isEmpty()) {
            Node n = maxPq.poll();
            if (find(n.i) == find(n.j)) {
                continue;
            }
            union(n.i, n.j);
            count++;
            if (n.distance == 0) {
                result++;
            }
        }
        return (int) Math.pow(result, 2);
    }

    private static int find(int i) {
        if (arr[i] == i) {
            return i;
        }
        return arr[i] = find(arr[i]);
    }

    private static void union(int i, int j) {
        int a = find(i);
        int b = find(j);
        if (a < b) {
            arr[b] = a;
        } else {
            arr[a] = b;
        }
    }
}