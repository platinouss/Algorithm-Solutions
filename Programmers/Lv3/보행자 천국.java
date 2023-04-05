/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 보행자 천국 (Lv3)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/1832
 */

class Solution {

    static final int MOD = 20170805;

    // dp[][][0] = 오른쪽, dp[][][1] = 아래
    static int dp[][][];

    public int solution(int m, int n, int[][] cityMap) {
        dp = new int[m + 1][n + 1][2];
        dp[1][1][0] = dp[1][1][1] = 1;
        for (int i=1; i<=m; i++) {
            for (int j=1; j<=n; j++) {
                if (cityMap[i - 1][j - 1] == 0) {
                    int cases = (dp[i - 1][j][1] + dp[i][j - 1][0]) % MOD;
                    dp[i][j][0] += cases;
                    dp[i][j][1] += cases;
                }
                if (cityMap[i - 1][j - 1] == 1) {
                    dp[i][j][0] = dp[i][j][1] = 0;
                }
                if (cityMap[i - 1][j - 1] == 2) {
                    dp[i][j][0] = dp[i][j-1][0];
                    dp[i][j][1] = dp[i-1][j][1];
                }
            }
        }
        return dp[m][n][0];
    }
}