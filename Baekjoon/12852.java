import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int[] dp = new int[num+1];
        int[] pre = new int[num+1];

        for (int i=2; i<=num; i++) {
            dp[i] = dp[i-1] + 1;
            pre[i] = i-1;

            if (i % 2 == 0 && dp[i] > dp[i/2] + 1) {
                dp[i] = dp[i/2] + 1;
                pre[i] = i/2;
            }

            if (i % 3 == 0 && dp[i] > dp[i/3] + 1) {
                dp[i] = dp[i/3] + 1;
                pre[i] = i/3;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(dp[num] + "\n");

        int tmp = num;
        while (num != 1) {
            sb.append(num + " ");
            num = pre[num];
        }
        sb.append("1");

        System.out.println(sb.toString());
    }
}