import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        int[] arr = new int[count + 1];
        int[] dp = new int[count + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=1; i<=count; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[1] = arr[1];
        for (int i=2; i<=count; i++) {
            for (int j=1; j<=i; j++) {
                dp[i] = Math.max(dp[i], dp[i-j] + arr[j]);
            }
        }

        System.out.println(dp[count]);
    }
}