/**
 * 백준 10942번 (골드 4)
 * 문제 이름 : 팰린드롬?
 * 알고리즘 분류 : DP
 * 링크 : https://www.acmicpc.net/problem/10942
 */

import java.io.*;
import java.util.*;

public class Main {

    static int[] numbers;
    static boolean[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int numberCount = Integer.parseInt(br.readLine());
        numbers = new int[numberCount + 1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i=1; i<=numberCount; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        dp = new boolean[numberCount + 1][numberCount + 1];
        setPalindrome(numberCount);

        int count = Integer.parseInt(br.readLine());
        for (int i=0; i<count; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int sIndex = Integer.parseInt(st.nextToken());
            int eIndex = Integer.parseInt(st.nextToken());

            if (dp[sIndex][eIndex]) { sb.append("1").append("\n"); }
            else { sb.append("0").append("\n"); }
        }

        System.out.println(sb);
    }

    private static void setPalindrome(int N) {
        for (int i=1; i<=N; i++) { dp[i][i] = true; }
        for (int i=1; i<N; i++) {
            if (numbers[i] == numbers[i + 1]) { dp[i][i + 1] = true; }
        }

        for (int j=2; j<N; j++) {
            for (int i=1; i<=N-j; i++) {
                if (numbers[i] == numbers[i + j] && dp[i+1][i + j - 1]) {
                    dp[i][i + j] = true;
                }
            }
        }
    }
}