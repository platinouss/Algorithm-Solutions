/**
 * 백준 1102번 (플레티넘 5)
 * 문제 이름 : 발전소
 * 알고리즘 분류 : DP, 비트마스킹
 * 링크 : https://www.acmicpc.net/problem/1102
 */

import java.io.*;
import java.util.Arrays;

public class Main {

    private static int N;
    private static int[][] dp;
    private static int[][] arr;
    private static int totalCount;
    private static final int MAX_VALUE = 1000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i=0; i<N; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        dp = new int[N + 1][1 << N];
        for (int i=0; i<N+1; i++) {
            Arrays.fill(dp[i], -1);
        }

        int count = 0;
        int bitmask = 0;
        String condition = br.readLine();
        for (int i=0; i<condition.length(); i++) {
            if (condition.charAt(i) == 'Y') {
                bitmask |= (1 << i);
                count++;
            }
        }
        totalCount = Integer.parseInt(br.readLine());

        int price = turnOnPower(count, bitmask);
        if (price == MAX_VALUE) {
            price = -1;
        }
        System.out.println(price);
    }

    private static int turnOnPower(int count, int bitmask) {
        if (count >= totalCount) {
            return 0;
        }
        if (dp[count][bitmask] != -1) {
            return dp[count][bitmask];
        }

        dp[count][bitmask] = MAX_VALUE;
        for (int i=0; i<N; i++) {
            if ((bitmask & (1 << i)) == (1 << i)) {
                for (int j=0; j<N; j++) {
                    if (i == j || (bitmask & (1 << j)) == (1 << j)) {
                        continue;
                    }
                    dp[count][bitmask] = Math.min(dp[count][bitmask],
                            turnOnPower(count + 1, bitmask | (1 << j)) + arr[i][j]);
                }
            }
        }
        return dp[count][bitmask];
    }
}