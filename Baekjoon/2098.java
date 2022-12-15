/**
 * 백준 2098번 (골드 1)
 * 문제 이름 : 외판원 순회
 * 알고리즘 분류 : DP, 비트마스킹, 외판원 순회
 * 링크 : https://www.acmicpc.net/problem/2098
 */

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] dp;
    static int[][] arr;
    static final int NOT_CYCLE = 16 * 1_000_000 + 1;
    static final int NOT_VISIT = NOT_CYCLE * 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[N][(1 << N)];
        for (int[] d : dp) { Arrays.fill(d, NOT_VISIT); }

        System.out.println(dfs(0, 1));
    }

    private static int dfs(int index, int bitmask) {
        if (bitmask == ((1 << N) - 1)) {
            if (arr[index][0] == 0) { return NOT_CYCLE; }
            return arr[index][0];
        }

        if (dp[index][bitmask] != NOT_VISIT) { return dp[index][bitmask]; }

        for (int k=0; k<N; k++) {
            if (arr[index][k] != 0 && (bitmask & (1 << k)) == 0) {
                dp[index][bitmask] = Math.min(dp[index][bitmask], dfs(k, bitmask | (1 << k)) + arr[index][k]);
            }
        }

        return dp[index][bitmask];
    }
}