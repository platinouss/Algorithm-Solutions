/**
 * [LeetCode] 72. Edit Distance
 * https://leetcode.com/problems/edit-distance/
 *
 * 접근 방식
 * 1) word1의 부분 문자열을 word2의 부분 문자열로 변환하는데 최소 비용을 저장할 dp 배열을 만든다.
 * 2) dp[i][0]은 word1의 부분 문자열을 빈 문자열로 만들 때 발생하는 비용으로 해당 값을 i로 저장한다.
 * 3) dp[0][j]는 빈 문자열을 word2의 부분 문자열로 만들 때 발생하는 비용으로 해당 값을 j로 저장한다.
 * 4) (1, 1)에서 (N, M)까지 탐색하면서 만약 문자가 동일하다면 dp[i][j] = dp[i-1][j-1]로 설정한다.
 *    만약 문자가 다르다면, 변경/삽입/삭제 비용 중 최소 비용 + 1을 dp[i][j]에 저장한다.
 * 5) dp[N][M] 값을 반환한다.
 */

class Solution {
    public int minDistance(String word1, String word2) {
        int N = word1.length();
        int M = word2.length();
        int[][] dp = new int[N + 1][M + 1];
        for (int i=1; i<=N; i++) {
            dp[i][0] = i;
        }
        for (int j=1; j<=M; j++) {
            dp[0][j] = j;
        }
        for (int i=1; i<=N; i++) {
            for (int j=1; j<=M; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[N][M];
    }
}
