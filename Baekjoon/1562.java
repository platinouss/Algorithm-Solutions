/**
 * 백준 1562번 (골드 1)
 * 문제 이름 : 계단 수
 * 알고리즘 분류 : DP, 비트마스크
 * 링크 : https://www.acmicpc.net/problem/1562
 */

import java.io.*;

public class Main {

    static final int MOD = 1_000_000_000;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][][] dp = new long[N + 1][10][1 << 10];

        for (int i = 1; i <= 9; i++) {
            dp[1][i][1 << i] = 1;
        }

        for (int n = 2; n <= N; n++) {
            for (int k = 0; k <= 9; k++) {
                for (int visit = 0; visit < (1 << 10); visit++) {
                    int bitMask = visit | (1 << k);
                    if (k == 0) {
                        dp[n][k][bitMask] += dp[n - 1][k + 1][visit] % MOD;
                    }
                    else if (k == 9) {
                        dp[n][k][bitMask] += dp[n - 1][k - 1][visit] % MOD;
                    }
                    else {
                        dp[n][k][bitMask] += dp[n - 1][k + 1][visit] % MOD + dp[n - 1][k - 1][visit] % MOD;
                    }
                    dp[n][k][bitMask] %= MOD;
                }
            }
        }

        long sum = 0;
        for (int i = 0; i <= 9; i++) {
            sum += dp[N][i][(1 << 10) - 1] % MOD;
            sum %= MOD;
        }

        System.out.println(sum);
    }
}