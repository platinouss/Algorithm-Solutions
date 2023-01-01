/**
 * 백준 1029번 (골드 1)
 * 문제 이름 : 그림 교환
 * 알고리즘 분류 : DP, 비트마스킹
 * 링크 : https://www.acmicpc.net/problem/1029
 */

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] arr;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i=0; i<N; i++) {
            arr[i] = Arrays.stream(br.readLine().split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        dp = new int[1 << N][15][10];
        for (int[][] d : dp) {
            for (int[] p : d) {
                Arrays.fill(p, -1);
            }
        }
        System.out.println(getResult(1, 0, 0));
    }

    private static int getResult(int bitmask, int index, int price) {
        if (dp[bitmask][index][price] != -1) {
            return dp[bitmask][index][price];
        }
        int tmp = 0;
        for (int i=1; i<N; i++) {
            if ((bitmask & (1 << i)) == 0 && arr[index][i] >= price) {
                tmp = Math.max(tmp, getResult(bitmask | (1 << i), i, arr[index][i]));
            }
        }
        return dp[bitmask][index][price] = tmp + 1;
    }
