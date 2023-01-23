/**
 * 백준 14442번 (골드 3)
 * 문제 이름 : 벽 부수고 이동하기 2
 * 알고리즘 분류 : 그래프, BFS
 * 링크 : https://www.acmicpc.net/problem/14442
 */

import java.util.*;
import java.io.*;

public class Main {

    static class Node {
        int i, j, count, total;

        public Node(int i, int j, int count, int total) {
            this.i = i;
            this.j = j;
            this.count = count;
            this.total = total;
        }
    }

    static int[][][] arr;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        arr = new int[N][M][K + 1];
        for (int i=0; i<N; i++) {
            String line = br.readLine();
            for (int j=0; j<M; j++) {
                char c = line.charAt(j);
                if (c == '1') {
                    arr[i][j][0] = -1;
                }
            }
        }

        arr[0][0][0] = 1;
        bfs(N, M, K);
    }

    private static void bfs(int N, int M, int K) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 0, 1));
        while (!q.isEmpty()) {
            Node node = q.remove();
            for (int k=0; k<di.length; k++) {
                int ii = node.i + di[k];
                int jj = node.j + dj[k];
                if (isOutOfRange(ii, jj)) {
                    continue;
                }
                if (ii == N-1 && jj == M-1) {
                    System.out.println(node.total + 1);
                    return;
                }
                if (arr[ii][jj][node.count] > 0 && arr[ii][jj][node.count] <= node.total + 1) {
                    continue;
                }
                boolean isWall = false;
                if (arr[ii][jj][0] == -1) {
                    if (node.count + 1 > K) {
                        continue;
                    }
                    isWall = true;
                }
                arr[ii][jj][node.count] = node.total + 1;
                int cnt = node.count;
                if (isWall) {
                    cnt++;
                }
                q.add(new Node(ii, jj, cnt, node.total + 1));
            }
        }
        if (N == 1 && M == 1) {
            System.out.println(1);
            return;
        }
        System.out.println(-1);
    }

    private static boolean isOutOfRange(int i, int j) {
        if (i < 0 || j < 0 || i >= arr.length || j >= arr[0].length) {
            return true;
        }
        return false;
    }
}