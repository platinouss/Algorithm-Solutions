/**
 * 백준 11722번 (실버 2)
 * 문제 이름 : 가장 긴 감소하는 부분 수열
 * 알고리즘 분류 : DP
 * 링크 : https://www.acmicpc.net/problem/11722
 */

import java.util.*;
import java.io.*;

class Main {

    static int[] arr;
    static int[] dp;

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        dp = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for (int i=1; i<=N; i++) {
            dp[i] = 1;
            for (int j=1; j<i; j++) {
                if (arr[i] < arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}
