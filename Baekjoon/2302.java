/**
 * 백준 2302번 (실버 1)
 * 문제 이름 : 극장 좌석
 * 알고리즘 분류 : DP
 * 링크 : https://www.acmicpc.net/problem/2302
 */

import java.util.*;
import java.io.*;

class Main {

    static int[] dp = new int[41];

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i=3; i<=N; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        int result = 1;
        int startIndex = 0;
        for (int i=0; i<K; i++) {
            int v = Integer.parseInt(br.readLine());
            result *= dp[v - startIndex - 1];
            startIndex = v;
        }
        result *= dp[N - startIndex];

        System.out.println(result);
    }
}
