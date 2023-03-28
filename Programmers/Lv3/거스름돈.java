/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 거스름돈 (Lv3)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12907
 */

import java.util.*;

class Solution {

    static final int DIV = 1_000_000_007;

    static int[][] dp;

    public int solution(int n, int[] money) {
        Arrays.sort(money);

        int N = money.length;
        int M = n;
        dp = new int[N + 1][M + 1];
        for (int i=1; i<=N; i++) {
            int coin = money[i-1];
            for (int j=1; j<=M; j++) {
                if (coin > j) {
                    dp[i][j] = dp[i-1][j] % DIV;
                } else if (coin == j) {
                    dp[i][j] = (dp[i-1][j] + 1) % DIV;
                } else {
                    dp[i][j] = (dp[i-1][j] + dp[i][j - coin]) % DIV;
                }
            }
        }

        return dp[N][M];
    }
}