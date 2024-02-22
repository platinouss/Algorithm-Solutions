/**
 * [Baekjoon] 2156. 포도주 시식
 * https://www.acmicpc.net/problem/2156
 *
 * 접근 방식
 * 1) 연속으로 놓여있는 3잔을 마실 수 없기 때문에, 가능한 경우의 수를 모두 고려한다.
 *    이때, 특정 인덱스에서 최대 포도주 양을 저장해 둘 dp 배열을 생성한다.
 *  1-1) 인덱스 i에 놓여있는 포도주를 마시지 않는다. -> dp[i - 1]
 *  1-2) (i - 3), (i - 2), (i) 에 놓여 있는 포도주를 마신다. -> dp[i - 3] + arr[i - 1] + arr[i]
 *  1-3) (i - 2), (i)에 놓여 있는 포도주를 마신다. -> dp[i - 2] + arr[i]
 * 2) dp 배열의 마지막 원소를 반환한다.
 */

import java.io.*;

class Main {

    static int N;
    static int[] arr;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        for (int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
    }

    public static void main (String[] args) throws IOException {
        input();
        int[] dp = new int[N + 1];
        dp[1] = arr[1];
        if (N > 1) {
            dp[2] = arr[1] + arr[2];
        }
        for (int i=3; i<=N; i++) {
            dp[i] = Math.max(dp[i-1], Math.max(dp[i-3] + arr[i-1] + arr[i], dp[i-2] + arr[i]));
        }
        System.out.println(dp[N]);
    }
}
