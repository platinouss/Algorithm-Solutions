import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int count = Integer.parseInt(br.readLine());

        int[][] dp = new int[count][3];
        int[][] arr = new int[count][3];
        for (int i=0; i<count; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (i == 0) { dp[i][j] = arr[i][j]; }
            }
        }

        for (int i=1; i<count; i++) {
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + arr[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + arr[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + arr[i][2];
        }

        System.out.println(Math.min(dp[count-1][0], Math.min(dp[count-1][1], dp[count-1][2])));
    }
}