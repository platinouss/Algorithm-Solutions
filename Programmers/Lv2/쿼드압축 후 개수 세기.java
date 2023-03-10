/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 쿼드압축 후 개수 세기 (Lv3)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/68936
 */

class Solution {

    static int[][] board;
    static int zeroCount = 0;
    static int oneCount = 0;

    public int[] solution(int[][] arr) {
        board = arr;
        dfs(0, 0, arr.length);
        int[] answer = {zeroCount, oneCount};
        return answer;
    }

    private static void dfs(int ii, int jj, int length) {
        if(isSameNumber(ii, jj, length)) {
            return;
        }
        int div = length / 2;
        dfs(ii, jj, div);
        dfs(ii, jj + div, div);
        dfs(ii + div, jj, div);
        dfs(ii + div, jj + div, div);
    }

    private static boolean isSameNumber(int ii, int jj, int length) {
        if (length == 1) {
            if (board[ii][jj] == 0) {
                zeroCount++;
                return true;
            }
            if (board[ii][jj] == 1) {
                oneCount++;
                return true;
            }
        }

        int v = board[ii][jj];
        for (int i=ii; i<ii+length; i++) {
            for (int j=jj; j<jj+length; j++) {
                if (v != board[i][j]) {
                    return false;
                }
            }
        }
        if (v == 0) {
            zeroCount++;
        }
        if (v == 1) {
            oneCount++;
        }
        return true;
    }
}