/**
 * 백준 9461번 (실버 3)
 * 문제 이름 : 파도반 수열
 * 알고리즘 분류 : DP
 * 링크 : https://www.acmicpc.net/problem/9461
 */

import java.util.*;
import java.io.*;

class Main {

    static Long[] dp = new Long[101];

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp[0] = 0L;
        dp[1] = 1L;
        dp[2] = 1L;
        dp[3] = 1L;

        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            int idx = Integer.parseInt(br.readLine());
            sb.append(getResult(idx)).append("\n");
        }
        System.out.println(sb);
    }

    private static long getResult(int index) {
        if (dp[index] == null) {
            dp[index] = getResult(index - 2) + getResult(index - 3);
        }
        return dp[index];
    }
}
