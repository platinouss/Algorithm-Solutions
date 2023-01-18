/**
 * 백준 1719번 (골드 3)
 * 문제 이름 : 택배
 * 알고리즘 분류 : 그래프, 플로이드 워셜
 * 링크 : https://www.acmicpc.net/problem/1719
 */

import java.util.*;
import java.io.*;

public class Main {

    static final int MAX_VALUE = 200_001;

    static int[][] dp;
    static int[][] before;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        dp = new int[N + 1][N + 1];
        for (int[] d : dp) {
            Arrays.fill(d, MAX_VALUE);
        }
        before = new int[N + 1][N + 1];

        while (K-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int sIndex = Integer.parseInt(st.nextToken());
            int eIndex = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            dp[sIndex][eIndex] = distance;
            dp[eIndex][sIndex] = distance;
            before[sIndex][eIndex] = eIndex;
            before[eIndex][sIndex] = sIndex;
        }

        for (int k=1; k<=N; k++) {
            for (int i=1; i<=N; i++) {
                for (int j=1; j<=N; j++) {
                    if (dp[i][j] > dp[i][k] + dp[k][j]) {
                        dp[i][j] = dp[i][k] + dp[k][j];
                        before[i][j] = before[i][k];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i=1; i<=N; i++) {
            for (int j=1; j<=N; j++) {
                if (i == j) {
                    sb.append("-");
                } else {
                    sb.append(before[i][j]);
                }
                sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}