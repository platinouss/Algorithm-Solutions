/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 경주로 건설 (Lv3)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/67259
 */

import java.util.*;

class Solution {

    static int N;
    static int M;
    static int[][][] arr;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};

    public int solution(int[][] board) {
        N = board.length;
        M = board[0].length;
        arr = new int[N][M][4];
        bfs(board);

        int min = Integer.MAX_VALUE;
        for (int v : arr[N - 1][M - 1]) {
            if (v == 0) {
                continue;
            }
            min = Math.min(min, v);
        }
        return min;
    }

    private static void bfs(int[][] board) {
        Queue<Node> q = new LinkedList<>();
        for (int i=0; i<4; i++) {
            q.add(new Node(0, 0, i, 0));
        }
        while (!q.isEmpty()) {
            Node node = q.remove();
            for (int k=0; k<4; k++) {
                int ii = node.i + di[k];
                int jj = node.j + dj[k];
                int price = node.price + 100;
                if (ii < 0 || jj < 0 || ii >= N || jj >= M) {
                    continue;
                }
                if (node.dir != k) {
                    price += 500;
                }
                if (board[ii][jj] == 1 || (arr[ii][jj][k] != 0 && arr[ii][jj][k] < price)) {
                    continue;
                }
                arr[ii][jj][k] = price;
                q.add(new Node(ii, jj, k, price));
            }
        }
    }
}

class Node {
    int i, j, dir, price;

    public Node(int i, int j, int dir, int price) {
        this.i = i;
        this.j = j;
        this.dir = dir;
        this.price = price;
    }
}