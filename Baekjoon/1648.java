/**
 * 백준 1648번 (플레티넘 3)
 * 문제 이름 : 격자판 채우기
 * 알고리즘 분류 : DP, 비트마스킹
 * 링크 : https://www.acmicpc.net/problem/1648
 */

import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int M;
    static int[][] dp;

    static final int MOD = 9901;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dp = new int[N * M + 1][1 << M];
        for (int i=0; i<N*M+1; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(fillOutThePlate(0, 0));
    }

    private static int fillOutThePlate(int index, int bitmask) {
        if (index == N*M && bitmask == 0) {
            return 1;
        }
        if (index >= N*M) {
            return 0;
        }
        if (dp[index][bitmask] != -1) {
            return dp[index][bitmask];
        }

        int tmp = 0;
        if ((bitmask & 1) == 1) {
            tmp = fillOutThePlate(index + 1, bitmask >> 1);
        } else {
            tmp = fillOutThePlate(index + 1, (bitmask >> 1) | (1 << (M - 1)));
            if ((bitmask & 2) == 0 && (index % M != M - 1)) {
                tmp += fillOutThePlate(index + 2, bitmask >> 2);
            }
        }

        return dp[index][bitmask] = tmp % MOD;
    }
}