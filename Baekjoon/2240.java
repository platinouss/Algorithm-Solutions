/**
 * 백준 2240번 (골드 5)
 * 문제 이름 : 자두 나무
 * 알고리즘 분류 : DP
 * 링크 : https://www.acmicpc.net/problem/2240
 */

import java.util.*;
import java.io.*;

class Main {

    static int[][] dp;

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        dp = new int[N + 1][K + 1];

        for (int i=1; i<=N; i++) {
            int v = Integer.parseInt(br.readLine());
            for (int j=0; j<=K; j++) {
                if (j == 0) {
                    if (v == 1) {
                        dp[i][j] = dp[i-1][j] + 1;
                    } else {
                        dp[i][j] = dp[i-1][j];
                    }
                    continue;
                }
                if (j % 2 == 1) {
                    if (v == 1) {
                        dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1] + 1);
                    } else {
                        dp[i][j] = Math.max(dp[i-1][j] + 1, dp[i-1][j-1]);
                    }
                }
                if (j % 2 == 0) {
                    if (v == 1) {
                        dp[i][j] = Math.max(dp[i-1][j] + 1, dp[i-1][j-1]);
                    } else {
                        dp[i][j] = Math.max(dp[i-1][j-1] + 1, dp[i-1][j]);
                    }
                }
            }
        }
        int answer = 0;
        for (int count : dp[N]) {
            answer = Math.max(answer, count);
        }
        System.out.println(answer);
    }
}



