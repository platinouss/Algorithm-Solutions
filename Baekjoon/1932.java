import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        int[][] arr = new int[count][count];
        for (int i=0; i<count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<i+1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
            for (int j=i+1; j<count; j++) {
                arr[i][j] = 0;
            }
        }

        int[][] dp = new int[count][count];
        for (int[] d : dp) {
            Arrays.fill(d, 0);
        }

        dp[0][0] = arr[0][0];
        for (int i=1; i<dp.length; i++) {
            for (int j=0; j<=i; j++) {
                setValue(i, j, arr, dp);
            }
        }

        int result = 0;
        for (int v : dp[count-1]) {
            result = Math.max(result, v);
        }

        System.out.println(result);
    }

    public static void setValue(int i, int j, int[][] arr, int[][] dp) {
        if (i == 1) {
            dp[i][j] = dp[i-1][0] + arr[i][j];
            return;
        }

        if (j == 0 || j == i) {
            if (j == 0) { dp[i][j] = dp[i-1][j] + arr[i][j]; }
            else { dp[i][j] = dp[i-1][j-1] + arr[i][j]; }
            return;
        }

        dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + arr[i][j];
    }
}