/**
 * 백준 16920번 (골드 2)
 * 문제 이름 : 확장 게임
 * 알고리즘 분류 : 그래프, BFS
 * 링크 : https://www.acmicpc.net/problem/16920
 */

import java.util.*;
import java.io.*;

public class Main {

    static class Node implements Comparable<Node> {
        int i, j, value, depth, count;

        public Node(int i, int j, int value, int depth, int count) {
            this.i = i;
            this.j = j;
            this.value = value;
            this.depth = depth;
            this.count = count;
        }

        @Override
        public int compareTo(Node o) {
            if (this.depth == o.depth) {
                return this.count - o.count;
            }
            return this.depth - o.depth;
        }
    }

    static int[][] arr;
    static int[] distance;
    static int[] result;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};
    static PriorityQueue<Node> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        result = new int[K + 1];
        distance = new int[K + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i=1; i<=K; i++) {
            distance[i] = Integer.parseInt(st.nextToken());
            distance[i] = Math.min(distance[i], N * M);
        }

        for (int i=0; i<N; i++) {
            String line = br.readLine();
            for (int j=0; j<M; j++) {
                char ch = line.charAt(j);
                if ('1' <= ch && ch <= '9') {
                    int value = ch - '0';
                    result[value]++;
                    arr[i][j] = value;
                    pq.add(new Node(i, j, value, value, 0));
                } else {
                    if (ch == '#') {
                        arr[i][j] = -1;
                    }
                }
            }
        }
        bfs(N, M, K);
        StringBuilder sb = new StringBuilder();
        for (int i=1; i<=K; i++) {
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb);
    }

    private static void bfs(int N, int M, int K) {
        int nowIndex = 0;
        int nowDepth = K;
        PriorityQueue<Node> q = new PriorityQueue<>();
        while (!pq.isEmpty()) {
            if (pq.peek().value != nowIndex) {
                nowIndex = pq.peek().value;
                nowDepth++;
            }
            while (!pq.isEmpty() && pq.peek().value == nowIndex) {
                q.add(pq.remove());
            }
            while (!q.isEmpty()) {
                Node node = q.remove();
                if (node.count == distance[node.value]) {
                    pq.add(new Node(node.i, node.j, node.value, nowDepth, 0));
                    continue;
                }
                for (int k=0; k<di.length; k++) {
                    int ii = node.i + di[k];
                    int jj = node.j + dj[k];
                    if (ii < 0 || jj < 0 || ii >= N || jj >= M) {
                        continue;
                    }
                    if (arr[ii][jj] != 0) {
                        continue;
                    }
                    arr[ii][jj] = node.value;
                    result[node.value]++;
                    q.add(new Node(ii, jj, node.value, node.depth, node.count + 1));
                }
            }
        }
    }
}
