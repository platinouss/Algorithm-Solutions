/**
 * 백준 1086번 (플레티넘 5)
 * 문제 이름 : 박성원
 * 알고리즘 분류 : 비트마스킹, DP
 * 링크 : https://www.acmicpc.net/problem/1086
 */

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int K;
    static int maxBitMask;
    static String[] arr;
    static long[][] dp;
    static int[][] mods;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        maxBitMask = (1 << N) - 1;
        arr = new String[N];
        for (int i=0; i<N; i++) {
            arr[i] = br.readLine();
        }
        K = Integer.parseInt(br.readLine());
        dp = new long[1 << N][K];
        for (long[] d : dp) {
            Arrays.fill(d, -1);
        }
        mods = new int[N][K];
        for (int[] mod : mods) {
            Arrays.fill(mod, -1);
        }
    }

    private static long memorization(int bitmask, int remainder) {
        if (dp[bitmask][remainder] != -1) {
            return dp[bitmask][remainder];
        }
        if (bitmask == maxBitMask) {
            if (remainder == 0) {
                return 1;
            }
            return 0;
        }

        long count = 0;
        for (int i=0; i<N; i++) {
            int mask = 1 << i;
            if ((bitmask & mask) == 0) {
                count += memorization(bitmask | mask, getRemainder(i, remainder));
            }
        }
        return dp[bitmask][remainder] = count;
    }

    private static long gcd(long v1, long v2) {
        if (v2 == 0) {
            return v1;
        }
        return gcd(v2, v1 % v2);
    }

    private static int getRemainder(int index, int remainder) {
        if (mods[index][remainder] != -1) {
            return mods[index][remainder];
        }

        int tmp = remainder;
        for (char c : arr[index].toCharArray()) {
            tmp *= 10;
            tmp += (c - '0');
            tmp %= K;
        }
        return mods[index][remainder] = tmp;
    }

    public static void main(String[] args) throws IOException {
        input();
        long result = memorization(0, 0);
        if (result == 0) {
            System.out.println("0/1");
            return;
        }
        long factorial = 1L;
        for (int i=2; i<=N; i++) {
            factorial *= i;
        }
        long gcdValue = gcd(factorial, result);
        System.out.println(result/gcdValue + "/" + factorial/gcdValue);
    }
}