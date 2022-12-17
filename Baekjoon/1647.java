/**
 * 백준 1647번 (골드 4)
 * 문제 이름 : 도시 분할 계획
 * 알고리즘 분류 : 최소 스패닝 트리
 * 링크 : https://www.acmicpc.net/problem/1647
 */

import java.io.*;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node>{
        int sIndex, eIndex, v;

        public Node(int i, int j, int v) {
            this.sIndex = i;
            this.eIndex = j;
            this.v = v;
        }

        @Override
        public int compareTo(Node o) {
            return this.v - o.v;
        }
    }

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cityCount = Integer.parseInt(st.nextToken());
        int lineCount = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i=0; i<lineCount; i++) {
            st = new StringTokenizer(br.readLine());
            int sIndex = Integer.parseInt(st.nextToken());
            int eIndex = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            pq.add(new Node(sIndex, eIndex, value));
        }

        arr = new int[cityCount + 1];
        for (int i=1; i<=cityCount; i++) {
            arr[i] = i;
        }

        int count = 0;
        int value = 0;
        while (count < cityCount - 2) {
            Node n = pq.remove();
            if (isSameGroup(n.sIndex, n.eIndex)) { continue; }
            union(n.sIndex, n.eIndex);
            value += n.v;
            count++;
        }

        System.out.println(value);
    }

    private static boolean isSameGroup(int city1, int city2) {
        return find(city1) == find(city2);
    }

    private static void union(int a, int b) {
        int v1 = find(a);
        int v2 = find(b);

        if (v1 <= v2) { arr[v2] = v1; }
        else { arr[v1] = v2; }
    }

    private static int find(int n) {
        if (n == arr[n]) { return n; }

        return arr[n] = find(arr[n]);
    }
}