/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 등굣길 (Lv3)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42898
 */

import java.util.*;

class Solution {

    static final int MAX_VALUE = Integer.MAX_VALUE;
    static final int DIV = 1_000_000_007;

    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n][m];
        for (int[] arr : dp) {
            Arrays.fill(arr, MAX_VALUE);
        }
        for (int[] puddle : puddles) {
            dp[puddle[1] - 1][puddle[0] - 1] = -1;
        }

        int value = 1;
        for (int j=0; j<m; j++) {
            if (dp[0][j] == -1) {
                value = 0;
                continue;
            }
            dp[0][j] = value;
        }
        value = 1;
        for (int i=0; i<n; i++) {
            if (dp[i][0] == -1) {
                value = 0;
                continue;
            }
            dp[i][0] = value;
        }

        for (int i=1; i<n; i++) {
            for (int j=1; j<m; j++) {
                if (dp[i][j] == -1) {
                    continue;
                }
                if (dp[i-1][j] == -1 && dp[i][j-1] == -1) {
                    dp[i][j] = 0;
                    continue;
                }
                if (dp[i-1][j] == -1) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j-1]);
                } else if (dp[i][j-1] == -1) {
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j]);
                } else {
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j] + dp[i][j-1]);
                }
                dp[i][j] %= DIV;
            }
        }

        if (dp[n-1][m-1] == MAX_VALUE) {
            return 0;
        }
        return dp[n-1][m-1];
    }
}