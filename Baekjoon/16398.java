/**
 * 백준 16398번 (골드 4)
 * 문제 이름 : 행성 연결
 * 알고리즘 분류 : 그래프, 최소 스패닝 트리
 * 링크 : https://www.acmicpc.net/problem/16398
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
            return this.distance - n.distance;
        }
    }

    static int[] arr;
    static PriorityQueue<Node> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        for (int i=1; i<=N; i++) {
            arr[i] = i;
        }
        for (int i=1; i<=N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=1; j<=N; j++) {
                int v = Integer.parseInt(st.nextToken());
                if (i == j) {
                    continue;
                }
                pq.add(new Node(i, j, v));
            }
        }
        int count = 0;
        long result = 0;
        while (count < (N-1) && !pq.isEmpty()) {
            Node n = pq.poll();
            if (find(n.i) == find(n.j)) {
                continue;
            }
            union(n.i, n.j);
            result += n.distance;
            count++;
        }
        System.out.println(result);
    }

    private static int find(int n) {
        if (n == arr[n]) {
            return n;
        }
        return arr[n] = find(arr[n]);
    }

    private static void union(int sIndex, int eIndex) {
        int a = find(sIndex);
        int b = find(eIndex);
        if (a < b) {
            arr[b] = a;
        } else {
            arr[a] = b;
        }
    }
}
