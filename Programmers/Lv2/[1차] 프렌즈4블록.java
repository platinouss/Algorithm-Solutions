/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : [1차] 프렌즈4블록 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/17679
 */

import java.util.*;

class Solution {

    static int result = 0;
    static char[][] arr;

    static int[] di = {0, 0, 1, 1};
    static int[] dj = {0, 1, 0, 1};

    public int solution(int m, int n, String[] board) {
        arr = new char[m][n];
        for (int i=0; i<m; i++) {
            String str = board[i];
            for (int j=0; j<n; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        while (true) {
            if (!removeBlock(m, n)) {
                break;
            }
        }

        return result;
    }

    private static boolean removeBlock(int N, int M) {
        List<Node> list = new ArrayList<>();
        boolean[][] removed = new boolean[N][M];

        int count = 0;
        for (int i=0; i<N-1; i++) {
            for (int j=0; j<M-1; j++) {
                if (checkFourBlock(i, j)) {
                    for (int k=0; k<4; k++) {
                        int ii = i + di[k];
                        int jj = j + dj[k];
                        if (removed[ii][jj]) {
                            continue;
                        }
                        removed[ii][jj] = true;
                        list.add(new Node(ii, jj));
                        count++;
                    }
                }
            }
        }
        if (count == 0) {
            return false;
        }

        result += count;
        for (Node node : list) {
            arr[node.i][node.j] = '0';
        }
        moveBlock(N, M);
        return true;
    }

    private static boolean checkFourBlock(int ii, int jj) {
        char c = arr[ii][jj];
        if (c == '0') {
            return false;
        }
        for (int k=0; k<4; k++) {
            if (c != arr[ii + di[k]][jj + dj[k]]) {
                return false;
            }
        }
        return true;
    }

    private static void moveBlock(int N, int M) {
        for (int i=N-1; i>=0; i--) {
            for (int j=0; j<M; j++) {
                if (arr[i][j] == '0') {
                    int idx = i;
                    int location = getBlockLocation(i, j, N, M);
                    while (location >= 0) {
                        arr[idx][j] = arr[location][j];
                        arr[location][j] = '0';
                        location--;
                        idx--;
                    }
                }
            }
        }
    }

    private static int getBlockLocation(int ii, int jj, int N, int M) {
        for (int i=ii; i>=0; i--) {
            if (arr[i][jj] != '0') {
                return i;
            }
        }
        return ii;
    }
}

class Node {
    public int i, j;

    public Node(int i, int j) {
        this.i = i;
        this.j = j;
    }
}