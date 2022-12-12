package com.company;

import java.util.*;
import java.io.*;

class Main {

    static class Node {
        int i, j;

        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    static int[][] arr;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int day = 0;
        int count = 0;
        while ((count = divideCount(N, M)) < 2) {
            if (count == 0) { day = 0; break; }

            Queue<Node> q = new LinkedList<>();
            boolean[][] visited = new boolean[N][M];
            for (int i=0; i<N; i++) {
                for (int j=0; j<M; j++) {
                    if (arr[i][j] != 0) {
                        visited[i][j] = true;
                        q.add(new Node(i, j));
                    }
                }
            }
            while (!q.isEmpty()) {
                Node n  = q.remove();
                int cnt = 0;
                for (int k=0; k<di.length; k++) {
                    int a = n.i + di[k];
                    int b = n.j + dj[k];
                    if (isOutOfRange(a, b) || visited[a][b]) { continue; }
                    if (arr[a][b] == 0) { cnt++; }
                }

                if (arr[n.i][n.j] - cnt < 0) { arr[n.i][n.j] = 0; }
                else { arr[n.i][n.j] -= cnt; }
            }

            day++;
        }

        System.out.println(day);
    }

    private static int divideCount(int N, int M) {
        int count = 0;
        boolean[][] visited = new boolean[N][M];
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (arr[i][j] == 0 || visited[i][j]) { continue; }
                dfs(i, j, visited);
                count++;
            }
        }

        return count;
    }

    private static void dfs(int i, int j, boolean[][] visited) {
        visited[i][j] = true;

        for (int k=0; k<di.length; k++) {
            int a = i + di[k];
            int b = j + dj[k];
            if (isOutOfRange(a, b) || visited[a][b] || arr[a][b] == 0) { continue; }
            dfs(a, b, visited);
        }
    }

    private static boolean isOutOfRange(int i, int j) {
        return i < 0 || j < 0 || i >= arr.length || j >= arr[0].length;
    }
}