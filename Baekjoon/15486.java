/**
 * 백준 15486번 (골드 5)
 * 문제 이름 : 퇴사 2
 * 알고리즘 분휴 : DP
 * 링크 : https://www.acmicpc.net/problem/15486
 */

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 2];
        int[][] arr = new int[N + 2][2];

        StringTokenizer st;
        for (int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for (int i=1; i<N + 2; i++) {
            max = Math.max(max, dp[i]);

            int index = i + arr[i][0];
            if (index < N + 2) {
                dp[index] = Math.max(dp[index], max + arr[i][1]);
            }
        }

        System.out.println(dp[N + 1]);
    }
}