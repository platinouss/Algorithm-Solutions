/**
 * [Baekjoon] 11066. 파일 합치기
 * https://www.acmicpc.net/problem/11066
 *
 */

import java.io.*;
import java.util.*;

class Main {

    static int N;
    static int[] sum;
    static int[][] dp;

    private static void input(BufferedReader br) throws IOException {
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1][N + 1];
        sum = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=1; i<=N; i++) {
            int price = Integer.parseInt(st.nextToken());
            sum[i] = sum[i - 1] + price;
        }
    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int K = Integer.parseInt(br.readLine());
        while (K-- > 0) {
            input(br);
            for (int cnt=1; cnt<N; cnt++) {
                for (int i=1; i+cnt<=N; i++) {
                    int j = i + cnt;
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int mid=i; mid<j; mid++) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][mid] + dp[mid + 1][j] + sum[j] - sum[i - 1]);
                    }
                }
            }
            sb.append(dp[1][N]).append("\n");
        }
        System.out.print(sb);
    }
}

