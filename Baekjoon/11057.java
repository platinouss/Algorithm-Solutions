/**
 * 백준 11057번 (실버 1)
 * 문제 이름 : 오르막 수
 * 알고리즘 분류 : DP
 * 링크 : https://www.acmicpc.net/problem/11057
 */

import java.util.*;
import java.io.*;

class Main {

    static final int DIV = 10007;

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N + 1][10];
        for (int j=0; j<10; j++) {
            dp[0][j] = 1;
        }

        for (int i=1; i<=N; i++) {
            for (int j=0; j<10; j++) {
                for (int k=j; k<10; k++) {
                    dp[i][j] += dp[i-1][k];
                    dp[i][j] %= DIV;
                }
            }
        }

        System.out.println(dp[N][0] % DIV);
    }
}
