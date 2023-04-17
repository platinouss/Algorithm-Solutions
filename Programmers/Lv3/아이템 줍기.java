/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 아이템 줍기 (Lv3)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/87694
 */

import java.util.*;

class Solution {

    static final int N = 101;

    static boolean[][] board;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        board = new boolean[N][N];
        draw(rectangle);
        Node start = new Node(characterY * 2, characterX * 2);
        Node end = new Node(itemY * 2, itemX * 2);
        int total = dfs(0, start, start, new boolean[N][N]) + 1;
        int distance = dfs(0, start, end, new boolean[N][N]);
        return Math.min(distance, total - distance) / 2;
    }

    private static int dfs(int count, Node start, Node end, boolean[][] visited) {
        if (count > 0 && start.i == end.i && start.j == end.j) {
            return count;
        }
        visited[start.i][start.j] = true;

        for (int k=0; k<4; k++) {
            int ii = start.i + di[k];
            int jj = start.j + dj[k];
            if (isOutOfRange(ii, jj)) {
                continue;
            }
            if (visited[ii][jj] || !board[ii][jj]) {
                continue;
            }
            return dfs(count + 1, new Node(ii, jj), end, visited);
        }
        return count;
    }

    private static boolean isOutOfRange(int i, int j) {
        return i < 0 || i >= N || j < 0 || j >= N;
    }

    private static void draw(int[][] rectangles) {
        for (int[] rectangle : rectangles) {
            int i1 = rectangle[1] * 2;
            int j1 = rectangle[0] * 2;
            int i2 = rectangle[3] * 2;
            int j2 = rectangle[2] * 2;
            drawRectangle(i1, j1, i2, j2);
        }

        for (int[] rectangle : rectangles) {
            int i1 = rectangle[1] * 2;
            int j1 = rectangle[0] * 2;
            int i2 = rectangle[3] * 2;
            int j2 = rectangle[2] * 2;
            removeInside(i1, j1, i2, j2);
        }
    }

    private static void removeInside(int i1, int j1, int i2, int j2) {
        for (int i=i1+1; i<i2; i++) {
            for (int j=j1+1; j<j2; j++) {
                board[i][j] = false;
            }
        }
    }

    private static void drawRectangle(int i1, int j1, int i2, int j2) {
        for (int i=i1; i<=i2; i++) { board[i][j1] = true; }
        for (int j=j1; j<=j2; j++) { board[i1][j] = true; }
        for (int j=j1; j<=j2; j++) { board[i2][j] = true; }
        for (int i=i1; i<=i2; i++) { board[i][j2] = true; }
    }
}

class Node {
    int i, j;

    public Node(int i, int j) {
        this.i = i;
        this.j = j;
    }
}