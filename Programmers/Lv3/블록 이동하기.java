/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 블록 이동하기 (Lv3)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/60063
 */

import java.util.*;

class Solution {

    static int N, M;
    static boolean[][][] visited;
    static int min = Integer.MAX_VALUE;

    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};
    static int[][] da = {{0, 0, 1, 1}, {-1, 0, -1, 0}};
    static int[][] db = {{-1, 0, -1, 0}, {0, 0, 1, 1}};

    public int solution(int[][] board) {
        N = board.length;
        M = board[0].length;
        visited = new boolean[N][M][2];
        Robot robot = new Robot(0, 1, 0, 0);
        bfs(robot, board);
        return min;
    }

    private static void bfs(Robot robot, int[][] board) {
        Queue<Robot> q = new LinkedList<>();
        visited[robot.i][robot.j][robot.dir] = true;
        q.add(robot);
        while (!q.isEmpty()) {
            Robot r = q.remove();
            if (r.i == N - 1 && r.j == M - 1) {
                min = Math.min(min, r.count);
                return;
            }
            for (int k=0; k<4; k++) {
                int ii = r.i + di[k];
                int jj = r.j + dj[k];
                if (!canMove(ii, jj, r.dir, board)) {
                    continue;
                }
                if (visited[ii][jj][r.dir]) {
                    continue;
                }
                q.add(new Robot(ii, jj, r.dir, r.count + 1));
                visited[ii][jj][r.dir] = true;
            }

            for (int k=0; k<4; k++) {
                int dir = (r.dir == 0) ? 1 : 0;
                int ii = r.i + da[r.dir][k];
                int jj = r.j + db[r.dir][k];
                int aa, bb;
                if (r.dir == 0) {
                    aa = r.i + di[(k < 2) ? 0 : 1];
                    bb = r.j + dj[(k < 2) ? 0 : 1];
                } else {
                    aa = r.i + di[(k < 2) ? 2 : 3];
                    bb = r.j + dj[(k < 2) ? 2 : 3];
                }
                if (!canMove(ii, jj, dir, board) || !canMove(aa, bb, r.dir, board)) {
                    continue;
                }
                if (visited[ii][jj][dir]) {
                    continue;
                }
                visited[ii][jj][dir] = true;
                q.add(new Robot(ii, jj, dir, r.count + 1));
            }
        }
    }

    private static boolean canMove(int a, int b, int dir, int[][] board) {
        if (isOutOfRange(a, b)) {
            return false;
        }
        if (dir == 0) {
            if (isOutOfRange(a, b-1)) {
                return false;
            }
            if (board[a][b] != 0 || board[a][b-1] != 0) {
                return false;
            }
        } else {
            if (isOutOfRange(a - 1, b)) {
                return false;
            }
            if (board[a][b] != 0 || board[a-1][b] != 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean isOutOfRange(int i, int j) {
        return i < 0 || i >= N || j < 0 || j >= M;
    }
}

class Robot {
    // dir = 0 : 가로
    int i, j, dir, count;

    public Robot(int i, int j, int dir, int count) {
        this.i = i;
        this.j = j;
        this.dir = dir;
        this.count = count;
    }
}