/**
 * 백준 1311번 (골드 1)
 * 문제 이름 : 할 일 정하기 1
 * 알고리즘 분류 : DP, 비트마스킹
 * 링크 : https://www.acmicpc.net/problem/1311
 */

import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[][] dp;
    static int[][] arr;
    static int maxBitMask;

    static final int MAX_VALUE = 200_001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        maxBitMask = (1 << N) - 1;

        arr = new int[N][N];
        for (int i=0; i<N; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        dp = new int[N][1 << N];
        for (int i=0; i<N; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(setWork(0, 0));
    }

    private static int setWork(int ii, int bitmask) {
        if (ii == N) {
            return 0;
        }
        if (dp[ii][bitmask] != -1) {
            return dp[ii][bitmask];
        }

        dp[ii][bitmask] = MAX_VALUE;
        for (int j=0; j<N; j++) {
            if ((bitmask & (1 << j)) == 0) {
                dp[ii][bitmask] = Math.min(dp[ii][bitmask],
                        setWork(ii + 1, bitmask | (1 << j)) + arr[ii][j]);
            }
        }

        return dp[ii][bitmask];
    }
}