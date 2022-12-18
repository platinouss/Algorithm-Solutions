/**
 * 백준 2011번 (골드 5)
 * 문제 이름 : 암호코드
 * 알고리즘 분류 : DP
 * 링크 : https://www.acmicpc.net/problem/2011
 */

import java.io.*;

public class Main {

    static final int DIV = 1_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();
        int N = num.length();
        int[] dp = new int[num.length()];

        if (N == 0 || num.charAt(0) == '0') { System.out.println(0); return; }

        dp[0] = 1;
        for (int i = 1; i < N; i++) {
            if (num.charAt(i) == '0') {
                if (num.charAt(i - 1) == '1' || num.charAt(i - 1) == '2') { dp[i] = dp[i - 1] % DIV; }
                else { System.out.println(0); return; }
            } else {
                if (num.charAt(i - 1) == '0') {
                    dp[i] = dp[i - 1];
                } else if (i + 1 < N && num.charAt(i + 1) == '0') {
                    int k = Integer.parseInt(num.substring(i, i + 2));
                    if (k <= 26) { dp[i] = dp[i - 1] % DIV; }
                    else { System.out.println(0); return; }
                } else {
                    int k = Integer.parseInt(num.substring(i - 1, i + 1));
                    if (k <= 26) {
                        if (i - 2 >= 0) { dp[i] = (dp[i - 1] + dp[i - 2]) % DIV; }
                        else { dp[i] = (dp[i - 1] + 1) % DIV; }
                    } else {
                        dp[i] = dp[i - 1] % DIV;
                    }
                }
            }
        }

        System.out.println(dp[N - 1]);
    }
}
