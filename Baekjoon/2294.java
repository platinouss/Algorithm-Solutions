/**
 * 백준 2294번 (골드 5)
 * 문제 이름 : 동전 2
 * 알고리즘 분류 : DP
 * 링크 : https://www.acmicpc.net/problem/2294
 */

import java.util.*;
import java.io.*;

public class Main {

    static final int MAX_VALUE = 100_001;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int value = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[value + 1];
        Arrays.fill(dp, MAX_VALUE);

        dp[0] = 0;
        for (int i=0; i<N; i++) {
            for (int j=arr[i]; j<=value; j++) {
                dp[j] = Math.min(dp[j], dp[j - arr[i]] + 1);
            }
        }

        int result = dp[value];
        if (result == MAX_VALUE) { result = -1; }

        System.out.println(result);
    }
}