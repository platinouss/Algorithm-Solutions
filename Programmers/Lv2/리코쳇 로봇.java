/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 리코쳇 로봇 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/169199
 */

import java.util.*;

class Solution {

    static int N;
    static int M;
    static char[][] arr;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};

    public int solution(String[] board) {
        N = board.length;
        M = board[0].length();

        Node start = new Node(0, 0, 0);
        Node end = new Node(0, 0, 0);
        arr = new char[N][M];
        for (int i=0; i<N; i++) {
            String str = board[i];
            for (int j=0; j<M; j++) {
                arr[i][j] = str.charAt(j);
                if (arr[i][j] == 'R') {
                    start.i = i;
                    start.j = j;
                }
                if (arr[i][j] == 'G') {
                    end.i = i;
                    end.j = j;
                }
            }
        }
        return bfs(start, end);
    }

    private static int bfs(Node start, Node end) {
        int result = -1;
        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        q.add(start);
        visited[start.i][start.j] = true;
        while (!q.isEmpty()) {
            Node node = q.remove();
            for (int k=0; k<4; k++) {
                int ii = node.i;
                int jj = node.j;
                while (!isOutOfRange(ii + di[k], jj + dj[k]) && arr[ii + di[k]][jj + dj[k]] != 'D') {
                    ii += di[k];
                    jj += dj[k];
                }
                if (visited[ii][jj]) {
                    continue;
                }
                if (ii == end.i && jj == end.j) {
                    return node.count + 1;
                }
                visited[ii][jj] = true;
                q.add(new Node(ii, jj, node.count + 1));
            }
        }
        return result;
    }

    private static boolean isOutOfRange(int i, int j) {
        return i < 0 || i >= N || j < 0 || j >= M;
    }
}

class Node {
    int i, j, count;

    public Node(int i, int j, int count) {
        this.i = i;
        this.j = j;
        this.count = count;
    }
}