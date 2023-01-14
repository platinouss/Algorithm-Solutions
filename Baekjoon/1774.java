/**
 * 백준 1774번 (골드 3)
 * 문제 이름 : 우주신과의 교감
 * 알고리즘 분류 : 그래프, 최소 스패닝 트리(최소 신장 트리)
 * 링크 : https://www.acmicpc.net/problem/1774
 */

import java.util.*;
import java.io.*;

public class Main {

    static class Node {
        int index;
        double i, j;

        public Node(int index, double i, double j) {
            this.index = index;
            this.i = i;
            this.j = j;
        }
    }

    static class Line implements Comparable<Line> {
        int sIndex, eIndex;
        double distance;

        public Line(int s, int e, double d) {
            this.sIndex = s;
            this.eIndex = e;
            this.distance = d;
        }

        @Override
        public int compareTo(Line l) {
            if (this.distance < l.distance) {
                return -1;
            }
            return 1;
        }
    }

    static int[] arr;
    static List<Node> nodes = new ArrayList<>();
    static PriorityQueue<Line> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        for (int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            long ii = Long.parseLong(st.nextToken());
            long jj = Long.parseLong(st.nextToken());
            nodes.add(new Node(i, ii, jj));
        }
        arr = new int[N + 1];
        for (int i=1; i<=N; i++) {
            arr[i] = i;
        }
        for (int i=0; i<nodes.size(); i++) {
            for (int j=i+1; j<nodes.size(); j++) {
                pq.add(new Line(nodes.get(i).index, nodes.get(j).index, getDistance(nodes.get(i), nodes.get(j))));
            }
        }
        int count = K;
        while (K-- > 0) {
            st = new StringTokenizer(br.readLine());
            int sIndex = Integer.parseInt(st.nextToken());
            int eIndex = Integer.parseInt(st.nextToken());
            if (find(sIndex) == find(eIndex)) {
                count--;
                continue;
            }
            union(sIndex, eIndex);
        }
        double result = 0;
        while (!pq.isEmpty() && count < (N - 1)) {
            Line n = pq.poll();
            if (find(n.sIndex) == find(n.eIndex)) {
                continue;
            }
            union(n.sIndex, n.eIndex);
            result += n.distance;
            count++;
        }
        System.out.printf("%.2f%n", result);
    }

    private static double getDistance(Node a, Node b) {
        return Math.sqrt(Math.pow(b.i - a.i, 2) + Math.pow(b.j - a.j, 2));
    }

    private static int find(int idx) {
        if (arr[idx] == idx) {
            return idx;
        }
        return arr[idx] = find(arr[idx]);
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