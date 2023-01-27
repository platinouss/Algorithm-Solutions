/**
 * 벡준 15988번 (실버 2)
 * 문제 이름 : 1, 2, 3 더하기 3
 * 알고리즘 분류 : DP
 * 링크 : https://www.acmicpc.net/problem/15988
 */

import java.util.*;
import java.io.*;

class Main {

    static final int DIV = 1_000_000_009;

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int max = 0;
        List<Integer> list = new ArrayList<>();
        while (N-- > 0) {
            int v = Integer.parseInt(br.readLine());
            max = Math.max(max, v);
            list.add(v);
        }

        long[] dp = new long[max + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i=4; i<=max; i++) {
            dp[i] = (dp[i-1] + dp[i-2] + dp[i-3]) % DIV;
        }

        for (int v : list) {
            sb.append(dp[v]).append("\n");
        }

        System.out.println(sb);
    }
}

