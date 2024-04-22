/**
 * [Baekjoon] 2225. 합분해
 * https://www.acmicpc.net/problem/2225
 *
 */


import java.io.*;
import java.util.*;

class Main {

    static final int DIV = 1_000_000_000;

    static int N, K;
    static int[][] dp;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dp = new int[K + 1][N + 1];
    }

    public static void main (String[] args) throws IOException {
        input();
        Arrays.fill(dp[1], 1);
        for (int i=1; i<=K; i++) {
            dp[i][0] = 1;
        }
        for (int i=2; i<=K; i++) {
            for (int j=1; j<=N; j++) {
                dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % DIV;
            }
        }
        System.out.println(dp[K][N]);
    }
}