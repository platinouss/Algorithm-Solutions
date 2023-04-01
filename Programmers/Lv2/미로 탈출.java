/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 미로 탈출 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/159993
 */

import java.util.*;

class Solution {

    static final int MAX_VALUE = 100 * 100 + 1;

    static int N;
    static int M;
    static char[][] board;
    static int[][][] arr;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};

    public int solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        board = new char[N][M];
        arr = new int[N][M][2];
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                Arrays.fill(arr[i][j], MAX_VALUE);
            }
        }

        Node start = new Node();
        Node end = new Node();
        Node lever = new Node();
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                board[i][j] = maps[i].charAt(j);
                if (board[i][j] == 'S') {
                    start = new Node(i, j, 0);
                }
                if (board[i][j] == 'E') {
                    end = new Node(i, j, 1);
                }
                if (board[i][j] == 'L') {
                    lever = new Node(i, j, 0);
                }
            }
        }
        bfs(start, end, lever);
        return arr[end.i][end.j][1];
    }

    private static void bfs(Node start, Node end, Node lever) {
        Queue<Node> q = new LinkedList<>();
        arr[start.i][start.j][0] = 0;
        q.add(start);
        while (!q.isEmpty()) {
            Node node = q.remove();
            int value = arr[node.i][node.j][node.check];
            for (int k=0; k<di.length; k++) {
                int ii = node.i + di[k];
                int jj = node.j + dj[k];
                if (isOutOfRange(ii, jj) || board[ii][jj] == 'X') {
                    continue;
                }
                if (arr[ii][jj][node.check] <= value + 1) {
                    continue;
                }
                if (lever.i == ii && lever.j == jj && node.check == 0
                        && arr[ii][jj][node.check] > value + 1)
                {
                    arr[ii][jj][0] = value + 1;
                    arr[ii][jj][1] = value + 1;
                    q.add(new Node(ii, jj, 1));
                    continue;
                }
                arr[ii][jj][node.check] = arr[node.i][node.j][node.check] + 1;
                q.add(new Node(ii, jj, node.check));
            }
        }
        if (arr[end.i][end.j][1] == MAX_VALUE) {
            arr[end.i][end.j][1] = -1;
        }
    }

    private static boolean isOutOfRange(int a, int b) {
        return a < 0 || a >= N || b < 0 || b >= M;
    }
}

class Node {
    int i, j, check;

    public Node() {}

    public Node(int i, int j, int check) {
        this.i = i;
        this.j = j;
        this.check = check;
    }
}