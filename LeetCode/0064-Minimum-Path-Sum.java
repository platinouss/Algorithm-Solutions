/**
 * [LeetCode] 64. Minimum Path Sum
 * https://leetcode.com/problems/minimum-path-sum/
 *
 * 접근 방식
 * 1) 최소 비용으로 갈 수 있는 비용을 저장해 둘 배열 dp를 생성 후, 먼저 i = 0일 때와 j = 0일 때 이동할 수 있는 비용을 계산한다.
 * 2) 특정 위치 (i,j)에 최소로 이동할 수 있는 비용은 grid[i][j] + Math.min(dp[i-1][j], dp[i][j-1])이므로,
 *    (1, 1)에서 (N-1, M-1) 위치까지 계산하여 최소 비용을 계산한 값을 dp 배열에 저장한다.
 * 3) dp[N-1][M-1] 값을 반환한다.
 */

class Solution {
    public int minPathSum(int[][] grid) {
        int N = grid.length;
        int M = grid[0].length;
        int[][] dp = new int[N][M];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < N; i++){
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for (int j = 1; j < M; j++){
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[N-1][M-1];
    }
}
