import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = Integer.parseInt(st.nextToken());
        int maxWeight = Integer.parseInt(st.nextToken());
        int[][] dp = new int[count+1][maxWeight+1];
        int[] weights = new int[count + 1];
        int[] values = new int[count + 1];
        for (int i=1; i<=count; i++) {
            st = new StringTokenizer(br.readLine());
            weights[i] = Integer.parseInt(st.nextToken());
            values[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=1; i<=count; i++) {
            for (int j=1; j<=maxWeight; j++) {
                if (j >= weights[i]) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weights[i]] + values[i]);
                    continue;
                }
                dp[i][j] = dp[i-1][j];
            }
        }

        System.out.println(dp[count][maxWeight]);
    }
}