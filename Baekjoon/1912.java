/**
 * [Baekjoon] 1912. 연속합
 * https://www.acmicpc.net/problem/1912
 *
 * 접근 방식
 * 1) 문제에서 연속된 원소의 합 중 가장 큰 합을 구하라 했으므로, 특정 인덱스의 최대 합을 저장해 둘 dp 배열을 생성한다.
 * 2) dp 배열의 각 원소는 해당 인덱스의 최대 합이므로, dp[i] = Math.max(dp[i], dp[i - 1] + arr[i])로 인덱스 i까지의 최대 합을 구할 수 있다.
 * 3) dp 배열의 원소 중 최대 값을 반환한다.
 *
 */

import java.io.*;
import java.util.*;

class Main {

    static int N;
    static int[] arr, dp;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void main (String[] args) throws IOException {
        input();
        dp[0] = arr[0];
        int max = arr[0];
        for (int i=1; i<N; i++) {
            dp[i] = Math.max(arr[i], dp[i-1] + arr[i]);
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}
