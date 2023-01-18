/**
 * 백준 1238번 (골드 3)
 * 문제 이름 : 파티
 * 알고리즘 분류 : 그래프, 다익스트라
 * 링크 : https://www.acmicpc.net/problem/1238
 */

import java.util.*;
import java.io.*;

public class Main {

    static class Node implements Comparable<Node> {
        int index, distance;

        public Node(int i, int d) {
            this.index = i;
            this.distance = d;
        }

        @Override
        public int compareTo(Node o) {
            return this.distance - o.distance;
        }
    }

    static final int MAX_VALUE = 10_000_001;

    static int[] total;
    static List<List<Node>> list = new ArrayList<>();
    static PriorityQueue<Node> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int mainTown = Integer.parseInt(st.nextToken());
        total = new int[N + 1];
        for (int i=0; i<=N; i++) {
            list.add(new ArrayList<>());
        }
        while (K-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int sIndex = Integer.parseInt(st.nextToken());
            int eIndex = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            list.get(sIndex).add(new Node(eIndex, distance));
        }
        pq.add(new Node(mainTown, 0));
        int[] tmp = new int[N + 1];
        Arrays.fill(tmp, MAX_VALUE);
        tmp[mainTown] = 0;
        while (!pq.isEmpty()) {
            Node node = pq.remove();
            for (Node n : list.get(node.index)) {
                if (node.distance + n.distance < tmp[n.index]) {
                    tmp[n.index] = node.distance + n.distance;
                    pq.add(new Node(n.index, tmp[n.index]));
                }
            }
        }
        for (int i=1; i<=N; i++) {
            total[i] += tmp[i];
        }
        int max = 0;
        for (int i=1; i<=N; i++) {
            tmp = new int[N + 1];
            Arrays.fill(tmp, MAX_VALUE);
            tmp[i] = 0;
            pq = new PriorityQueue<>();
            pq.add(new Node(i, 0));
            while (!pq.isEmpty()) {
                Node node = pq.poll();
                if (tmp[node.index] < node.distance) {
                    continue;
                }
                if (node.index == mainTown) {
                    break;
                }
                for (Node n : list.get(node.index)) {
                    if (node.distance + n.distance < tmp[n.index]) {
                        tmp[n.index] = node.distance + n.distance;
                        pq.add(new Node(n.index, tmp[n.index]));
                    }
                }
            }
            max = Math.max(max, tmp[mainTown] + total[i]);
        }
        System.out.println(max);
    }
}
