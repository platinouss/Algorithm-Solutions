/**
 * 백준 6593번 (골드 5)
 * 문제 이름 : 상범 빌딩
 * 알고리즘 분류 : 그래프, BFS
 * 링크 : https://www.acmicpc.net/problem/6593
 */

import java.util.*;
import java.io.*;

public class Main {

    static class Node {
        int i, j, h;

        public Node(int i, int j, int h) {
            this.i = i;
            this.j = j;
            this.h = h;
        }
    }

    static int H;
    static int N;
    static int M;
    static int[][][] arr;
    static int[] di = {-1, 1, 0, 0, 0, 0};
    static int[] dj = {0, 0, -1, 1, 0, 0};
    static int[] dh = {0, 0, 0, 0, -1, 1};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if (H == 0 && N == 0 && M == 0) {
                break;
            }
            Node start = new Node(0, 0, 0);
            Node end = new Node(0, 0, 0);
            arr = new int[N][M][H];
            for (int h=0; h<H; h++) {
                for (int i=0; i<N; i++) {
                    String line = br.readLine();
                    for (int j=0; j<M; j++) {
                        char c = line.charAt(j);
                        if (c == 'S') {
                            arr[i][j][h] = 1;
                            start.i = i;
                            start.j = j;
                            start.h = h;
                        }
                        if (c == '#') {
                            arr[i][j][h] = -1;
                        }
                        if (c == 'E') {
                            end.i = i;
                            end.j = j;
                            end.h = h;
                        }
                    }
                }
                br.readLine();
            }
            bfs(start, end);
        }
        System.out.print(sb);
    }

    private static void bfs(Node start, Node end) {
        Queue<Node> q = new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()) {
            Node node = q.remove();
            for (int k=0; k<di.length; k++) {
                int ii = node.i + di[k];
                int jj = node.j + dj[k];
                int hh = node.h + dh[k];
                if (ii < 0 || jj < 0 || hh < 0 || ii >= N || jj >= M || hh >= H) {
                    continue;
                }
                if (ii == end.i && jj == end.j && hh == end.h) {
                    getResult(arr[node.i][node.j][node.h]);
                    return;
                }
                if (arr[ii][jj][hh] != 0) {
                    continue;
                }
                arr[ii][jj][hh] = arr[node.i][node.j][node.h] + 1;
                q.add(new Node(ii, jj, hh));
            }
        }
        sb.append("Trapped!").append("\n");
    }

    private static void getResult(int result) {
        sb.append("Escaped in ").append(result).append(" minute(s).").append("\n");
    }
}
