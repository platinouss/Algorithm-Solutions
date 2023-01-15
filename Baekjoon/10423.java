/**
 * 백준 10423번 (골드 3)
 * 문제 이름 : 전기가 부족해
 * 알고리즘 분류 : 그래프, 최소 스패닝 트리(최소 신장 트리)
 * 링크 : https://www.acmicpc.net/problem/10423
 */

import java.util.*;
import java.io.*;

public class Main {

    static class Node implements Comparable<Node> {
        int sIndex, eIndex, distance;

        public Node(int s, int e, int d) {
            this.sIndex = s;
            this.eIndex = e;
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
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int J = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        for (int i=0; i<=N; i++) {
            arr[i] = i;
        }
        st = new StringTokenizer(br.readLine());
        while (J-- > 0) {
            int idx = Integer.parseInt(st.nextToken());
            arr[idx] = 0;
        }
        while (K-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            pq.add(new Node(s, e, d));
        }
        int count = J;
        int result = 0;
        while (!pq.isEmpty() && count < (N - 1)) {
            Node n = pq.remove();
            if (find(n.sIndex) == find(n.eIndex)) {
                continue;
            }
            count++;
            result += n.distance;
            union(n.sIndex, n.eIndex);
        }
        System.out.println(result);
    }

    private static int find(int idx) {
        if (arr[idx] == idx) {
            return idx;
        }
        return arr[idx] = find(arr[idx]);
    }

    private static void union(int i, int j) {
        int a = find(arr[i]);
        int b = find(arr[j]);

        if (a < b) {
            arr[b] = a;
        } else {
            arr[a] = b;
        }
    }
}