/**
 * [LeetCode] 79. Word Search
 * https://leetcode.com/problems/word-search/description/
 *
 * 접근 방식
 * 1) dfs(백트래킹)으로 어렵지 않게 해결할 수 있었다.
 */

class Solution {

    int N, M;
    boolean[][] check;
    int[] di = {-1, 1, 0, 0};
    int[] dj = {0, 0, -1, 1};

    private boolean isOutOfRange(int a, int b) {
        if (a < 0 || a >= N || b < 0 || b >= M) {
            return true;
        }
        return false;
    }

    private boolean dfs(int depth, int a, int b, char[][] board, String word) {
        if (depth == word.length()) {
            return true;
        }
        for (int k=0; k<4; k++) {
            int i = a + di[k];
            int j = b + dj[k];
            if (isOutOfRange(i, j) || check[i][j] || word.charAt(depth) != board[i][j]) {
                continue;
            }
            check[i][j] = true;
            if (dfs(depth + 1, i, j, board, word)) {
                return true;
            }
            check[i][j] = false;
        }
        return false;
    }

    public boolean exist(char[][] board, String word) {
        N = board.length;
        M = board[0].length;
        check = new boolean[N][M];
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (board[i][j] == word.charAt(0)) {
                    check[i][j] = true;
                    if (dfs(1, i, j, board, word)) {
                        return true;
                    }
                    check[i][j] = false;
                }
            }
        }
        return false;
    }
}
