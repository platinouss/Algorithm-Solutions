/**
 * [Baekjoon] 11053. 가장 긴 증가하는 부분 수열
 * https://www.acmicpc.net/problem/11053
 *
 */

import java.io.*;
import java.util.*;

class Main {

    static int N;
    static int[] arr, dp;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }
    }

    public static void main (String[] args) throws IOException {
        input();
        int cnt = 1;
        for (int i=1; i<N; i++) {
            for (int j=0; j<i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            cnt = Math.max(cnt, dp[i]);
        }
        System.out.println(cnt);
    }
}

