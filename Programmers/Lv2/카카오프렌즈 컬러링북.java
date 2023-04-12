/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 카카오프렌즈 컬러링북 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/1829
 */

import java.util.*;

class Solution {

    static int N;
    static int M;
    static int count;
    static int maxTotal;
    static boolean[][] visited;

    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};

    public int[] solution(int m, int n, int[][] picture) {
        N = m;
        M = n;
        count = 0;
        maxTotal = 0;
        visited = new boolean[N][M];
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (visited[i][j] || picture[i][j] == 0) {
                    continue;
                }
                visitBoard(i, j, picture);
                count++;
            }
        }
        return new int[] {count, maxTotal};
    }

    private static void visitBoard(int a, int b, int[][] arr) {
        Queue<Node> q = new LinkedList<>();
        Node start = new Node(a, b);
        visited[a][b] = true;
        q.add(start);

        int total = 1;
        while (!q.isEmpty()) {
            Node node = q.remove();
            int value = arr[node.i][node.j];
            for (int k=0; k<4; k++) {
                int ii = node.i + di[k];
                int jj = node.j + dj[k];
                if (isOutOfRange(ii, jj) || arr[ii][jj] != value) {
                    continue;
                }
                if (visited[ii][jj]) {
                    continue;
                }
                visited[ii][jj] = true;
                q.add(new Node(ii, jj));
                total++;
            }
        }
        maxTotal = Math.max(maxTotal, total);
    }

    private static boolean isOutOfRange(int i, int j) {
        return i < 0 || i >= N || j < 0 || j >= M;
    }
}

class Node {
    int i, j;

    public Node(int i, int j) {
        this.i = i;
        this.j = j;
    }
}