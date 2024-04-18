/**
 * [Baekjoon] 1520. 내리막 길
 * https://www.acmicpc.net/problem/1520
 *
 */

import java.io.*;
import java.util.*;

class Main {

    static int N, M;
    static int[][] arr, dp;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp = new int[N][M];
        for (int i=0; i<N; i++) {
            Arrays.fill(dp[i], -1);
        }
    }

    private static boolean isOutOfRange(int a, int b) {
        return a < 0 || a >= N || b < 0 || b >= M;
    }

    private static int dfs(int a, int b) {
        if (a == N-1 && b == M-1) {
            return 1;
        }
        if (dp[a][b] != -1) {
            return dp[a][b];
        }
        dp[a][b] = 0;
        for (int k=0; k<di.length; k++) {
            int ii = a + di[k];
            int jj = b + dj[k];
            if (isOutOfRange(ii, jj) || arr[a][b] <= arr[ii][jj]) {
                continue;
            }
            dp[a][b] += dfs(ii, jj);
        }
        return dp[a][b];
    }

    public static void main (String[] args) throws IOException {
        input();
        System.out.println(dfs(0, 0));
    }
}

