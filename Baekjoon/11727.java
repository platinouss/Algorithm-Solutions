/**
 * 백준 11727번 (실버 3)
 * 문제 이름 : 2×n 타일링 2
 * 알고리즘 분류 : DP
 * 링크 : https://www.acmicpc.net/problem/11727
 */

import java.util.*;
import java.io.*;

class Main {

    static final int DIV = 10007;

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N == 1) {
            System.out.println(1);
            return;
        }
        int[] dp = new int[N + 1];
        dp[1] = 1;
        dp[2] = 3;
        for (int i=3; i<=N; i++) {
            dp[i] = (dp[i - 1] + (2 * dp[i - 2])) % DIV;
        }
        System.out.println(dp[N]);
    }
}
