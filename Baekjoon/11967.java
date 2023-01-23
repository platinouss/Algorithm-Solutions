/**
 * 백준 11967번 (골드 2)
 * 문제 이름 : 불켜기
 * 알고리즘 분류 : 그래프, BFS
 * 링크 : https://www.acmicpc.net/problem/11967
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

    static int count = 1;
    static List<Node>[][] list;
    static boolean[][] visited;
    static boolean[][] switched;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1][N + 1];
        switched = new boolean[N + 1][N + 1];
        list = new ArrayList[N + 1][N + 1];
        for (int i=1; i<=N; i++) {
            for (int j=1; j<=N; j++) {
                list[i][j] = new ArrayList<>();
            }
        }
        while (K-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            list[a][b].add(new Node(c, d));
        }

        bfs(N);
        System.out.println(count);
    }

    private static void bfs(int N) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(1, 1));
        visited[1][1] = true;
        switched[1][1] = true;
        while (!q.isEmpty()) {
            Node node = q.remove();
            for (Node n : list[node.i][node.j]) {
                if (visited[n.i][n.j] || switched[n.i][n.j]) {
                    continue;
                }
                switched[n.i][n.j] = true;
                count++;
                if (isReachable(n)) {
                    visited[n.i][n.j] = true;
                    q.add(new Node(n.i, n.j));
                }
            }
            for (int k=0; k<di.length; k++) {
                int ii = node.i + di[k];
                int jj = node.j + dj[k];
                if (isOutOfRange(ii, jj) || !switched[ii][jj] || visited[ii][jj]) {
                    continue;
                }
                visited[ii][jj] = true;
                q.add(new Node(ii, jj));
            }
        }
    }

    private static boolean isReachable(Node node) {
        for (int k=0; k<di.length; k++) {
            int ii = node.i + di[k];
            int jj = node.j + dj[k];
            if (isOutOfRange(ii, jj)) {
                continue;
            }
            if (visited[ii][jj]) {
                return true;
            }
        }
        return false;
    }

    private static boolean isOutOfRange(int i, int j) {
        return i < 1 || j < 1 || i >= visited.length || j >= visited[0].length;
    }
}