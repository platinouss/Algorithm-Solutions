/**
 * 백준 1261번 (골드 4)
 * 문제 이름 : 알고스팟
 * 알고리즘 분류 : 그래프, 다익스트라
 * 링크 : https://www.acmicpc.net/problem/1261
 */

import java.util.*;
import java.io.*;

public class Main {

    static class Node implements Comparable<Node> {
        int i, j, count;

        public Node(int i, int j, int c) {
            this.i = i;
            this.j = j;
            this.count = c;
        }

        @Override
        public int compareTo(Node o) {
            return this.count - o.count;
        }
    }

    static int N;
    static int M;
    static int[][] arr;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for (int i=0; i<N; i++) {
            arr[i] = Arrays.stream(br.readLine().split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        System.out.println(bfs(0, 0, 0));
    }

    private static int bfs(int s, int e, int count) {
        boolean[][] visited = new boolean[N][M];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(s, e, count));
        visited[s][e] = true;
        while (!pq.isEmpty()) {
            Node n = pq.poll();
            if ((n.i == N - 1) && (n.j == M - 1)) {
                return n.count;
            }
            for (int k=0; k<4; k++) {
                int ii = n.i + di[k];
                int jj = n.j + dj[k];
                if (ii < 0 || jj < 0 || ii >= N || jj >= M) {
                    continue;
                }
                if (visited[ii][jj]) {
                    continue;
                }
                visited[ii][jj] = true;
                if (arr[ii][jj] == 0) {
                    pq.add(new Node(ii, jj, n.count));
                }
                else if (arr[ii][jj] == 1) {
                    pq.add(new Node(ii, jj, n.count + 1));
                }
            }
        }
        return -1;
    }
}