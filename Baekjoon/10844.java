/**
 * [Baekjoon] 10844. 쉬운 계단 수
 * https://www.acmicpc.net/problem/10844
 *
 * 접근 방식
 * 1) 특정 숫자가 해당 자리 수에 위치할 수 있는 경우의 수를 저장한 dp 배열을 생성한다.
 * 2) 첫 번째 자리에는 모든 숫자가 들어갈 수 있으므로, dp[i][1] = 1로 초기화한다.
 * 3) 특정 자리의 숫자는 이전 자리 숫자와 1의 차이가 있어야 하므로, dp[i][j] = dp[i-1][j-1] + dp[i+1][j-1]라는 점화식이 만들어진다.
 *    여기서 0과 9 숫자는 한 가지의 경우만 발생하므로 예외 처리한다.
 * 4) 문제에서 1,000,000,000로 나눈 값을 요구하므로, 적절히 계산하여 최종 경우의 수를 반환한다.
 *
 */

import java.io.*;

class Main {

    static final int DIV = 1_000_000_000;

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] dp = new long[10][N + 1];
        for (int i=1; i<10; i++) {
            dp[i][1] = 1;
        }
        for (int j=2; j<=N; j++) {
            dp[0][j] = dp[1][j - 1];
            dp[9][j] = dp[8][j - 1];
            for (int i=1; i<=8; i++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i + 1][j - 1] % DIV;
            }
        }
        long total = 0;
        for (int i=0; i<=9; i++) {
            total += dp[i][N];
        }
        System.out.println(total % DIV);
    }
}

