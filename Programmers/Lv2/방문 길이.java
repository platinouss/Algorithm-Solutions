/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 방문 길이 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/49994
 */

class Solution {

    static int count = 0;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, 1, -1};
    static boolean[][][][] visited = new boolean[11][11][11][11];

    public int solution(String dirs) {
        Node now = new Node(5, 5);
        for (char c : dirs.toCharArray()) {
            if (c == 'U') {
                move(now, 0);
            }
            if (c == 'D') {
                move(now, 1);
            }
            if (c == 'R') {
                move(now, 2);
            }
            if (c == 'L') {
                move(now, 3);
            }
        }

        return count;
    }

    private static void move(Node now, int k) {
        int ii = now.i + di[k];
        int jj = now.j + dj[k];
        if (isOutOfRange(ii, jj)) {
            return;
        }
        if (!visited[now.i][now.j][ii][jj] && !visited[ii][jj][now.i][now.j]) {
            visited[now.i][now.j][ii][jj] = true;
            visited[ii][jj][now.i][now.j] = true;
            count++;
        }
        now.i = ii;
        now.j = jj;
    }

    private static boolean isOutOfRange(int i, int j) {
        return i < 0 || j < 0 || i > 10 || j > 10;
    }
}

class Node {
    int i, j;

    public Node(int i, int j) {
        this.i = i;
        this.j = j;
    }
}