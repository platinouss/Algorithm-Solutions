/**
 * 백준 9084번 (골드 5)
 * 문제 이름 : 동전
 * 알고리즘 분휴 : DP
 * 링크 : https://www.acmicpc.net/problem/9084
 */

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int totalCount = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (totalCount-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            int value = Integer.parseInt(br.readLine());

            int[] dp = new int[value + 1];
            dp[0] = 1;
            for (int v : arr) {
                for (int i=v; i<=value; i++) { dp[i] += dp[i - v]; }
            }

            sb.append(dp[value]).append("\n");
        }

        System.out.println(sb);
    }
}