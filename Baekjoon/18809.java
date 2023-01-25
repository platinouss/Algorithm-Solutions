/**
 * 백준 18809번 (골드 1)
 * 문제 이름 : Gaaaaaaaaaarden
 * 알고리즘 분류 : 그래프, BFS
 * 링크 : https://www.acmicpc.net/problem/18809
 */

import java.util.*;
import java.io.*;

public class Main {

    static class Node {
        int i, j;

        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    static class Ground {
        int time, color;

        public Ground(int time, int color) {
            this.time = time;
            this.color = color;
        }
    }

    static final int GREEN = 1;
    static final int RED = -1;
    static final int FLOWER = 2;

    static int N;
    static int M;
    static int greenCount;
    static int redCount;
    static int max;
    static int[] reds;
    static int[] greens;
    static int[][] arr;
    static boolean[] visited;
    static com.company.Main.Ground[][] result;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};
    static List<com.company.Main.Node> grounds = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        greenCount = Integer.parseInt(st.nextToken());
        redCount = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 2) {
                    grounds.add(new com.company.Main.Node(i, j));
                }
            }
        }
        visited = new boolean[10];
        reds = new int[redCount];
        greens = new int[greenCount];
        getRedSeed(0, 0);
        System.out.println(max);
    }

    private static void getRedSeed(int depth, int index) {
        if (depth == redCount) {
            getGreenSeed(0, 0);
            return;
        }
        for (int i=index; i<grounds.size(); i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            reds[depth] = i;
            getRedSeed(depth + 1, i + 1);
            visited[i] = false;
        }
    }

    private static void getGreenSeed(int depth, int index) {
        if (depth == greenCount) {
            bfs();
            return;
        }
        for (int i=index; i<grounds.size(); i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            greens[depth] = i;
            getGreenSeed(depth + 1, i + 1);
            visited[i] = false;
        }
    }

    private static void bfs() {
        Queue<com.company.Main.Node> q = new LinkedList<>();
        result = new com.company.Main.Ground[N][M];
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                result[i][j] = new com.company.Main.Ground(0, 0);
            }
        }
        for (int idx : greens) {
            com.company.Main.Node node = grounds.get(idx);
            result[node.i][node.j] = new com.company.Main.Ground(1, GREEN);
            q.add(new com.company.Main.Node(node.i, node.j));
        }
        for (int idx : reds) {
            com.company.Main.Node node = grounds.get(idx);
            result[node.i][node.j] = new com.company.Main.Ground(1, RED);
            q.add(new com.company.Main.Node(node.i, node.j));
        }

        int tmp = 0;
        while (!q.isEmpty()) {
            com.company.Main.Node node = q.remove();
            int nowColor = result[node.i][node.j].color;
            int nowCount = result[node.i][node.j].time;
            if (result[node.i][node.j].color == FLOWER) {
                continue;
            }
            for (int k=0; k<di.length; k++) {
                int ii = node.i + di[k];
                int jj = node.j + dj[k];
                if (isOutOfRange(ii, jj) || arr[ii][jj] == 0) {
                    continue;
                }
                if (result[ii][jj].color == 0) {
                    result[ii][jj] = new com.company.Main.Ground(nowCount + 1, nowColor);
                    q.add(new com.company.Main.Node(ii, jj));
                } else if (result[ii][jj].color == RED) {
                    if (nowColor == GREEN && result[ii][jj].time == nowCount + 1) {
                        tmp++;
                        result[ii][jj].color = FLOWER;
                    }
                } else if (result[ii][jj].color == GREEN) {
                    if (nowColor == RED && result[ii][jj].time == nowCount + 1) {
                        tmp++;
                        result[ii][jj].color = FLOWER;
                    }
                }
            }
        }
        max = Math.max(max, tmp);
    }

    private static boolean isOutOfRange(int i, int j) {
        return i < 0 || j < 0 || i >= N || j >= M;
    }
}