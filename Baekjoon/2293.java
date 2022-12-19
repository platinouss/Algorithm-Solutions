/**
 * 백준 2293번 (골드 5)
 * 문제 이름 : 동전 1
 * 알고리즘 분류 : DP
 * 링크 : https://www.acmicpc.net/problem/2293
 */

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int value = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int[] dp = new int[value + 1];

        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 1; j <= value; j++) {
                if (j >= arr[i]) { dp[j] += dp[j - arr[i]]; }
            }
        }

        System.out.println(dp[value]);
    }
}