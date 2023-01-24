/**
 * 백준 16933번 (골드 1)
 * 문제 이름 : 벽 부수고 이동하기 3
 * 알고리즘 분류 : 그래프, BFS
 * 링크 : https://www.acmicpc.net/problem/16933
 */

import java.util.*;
import java.io.*;

public class Main {

    static final int MAX_VALUE = 1_000_001;

    static class Node {
        // 낮 : time % 2 == 1
        // 밤 : time % 2 == 0
        int i, j, count, time;

        public Node(int i, int j, int count, int time) {
            this.i = i;
            this.j = j;
            this.count = count;
            this.time = time;
        }
    }

    static char[][] arr;
    static int[][] visited;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        visited = new int[N][M];
        for (int i=0; i<N; i++) {
            arr[i] = br.readLine().toCharArray();
            Arrays.fill(visited[i], MAX_VALUE);
        }
        bfs(N, M, K);
    }

    private static void bfs(int N, int M, int K) {
        Queue<Node> q = new LinkedList<>();
        visited[0][0] = 0;
        q.add(new Node(0, 0, 0, 1));
        while (!q.isEmpty()) {
            Node node = q.remove();
            if (node.i == N-1 && node.j == M-1) {
                System.out.println(node.time);
                return;
            }
            for (int k=0; k<di.length; k++) {
                int ii = node.i + di[k];
                int jj = node.j + dj[k];
                if (isOutOfRange(ii, jj) || visited[ii][jj] <= node.count) {
                    continue;
                }
                if (arr[ii][jj] == '1') {
                    if (node.count + 1 > K || visited[ii][jj] <= node.count + 1) {
                        continue;
                    }
                    if (node.time % 2 == 0) {
                        q.add(new Node(node.i, node.j, node.count, node.time + 1));
                    } else {
                        visited[ii][jj] = node.count + 1;
                        q.add(new Node(ii, jj, node.count + 1, node.time + 1));
                    }
                } else {
                    visited[ii][jj] = node.count;
                    q.add(new Node(ii, jj, node.count, node.time + 1));
                }
            }
        }
        System.out.println(-1);
    }

    private static boolean isOutOfRange(int i, int j) {
        return i < 0 || j < 0 || i >= arr.length || j >= arr[0].length;
    }
}