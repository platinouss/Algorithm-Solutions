/**
 * 백준 14267번 (골드 4)
 * 문제 이름 : 회사 문화 1
 * 알고리즘 분류 : 트리, DFS, DP
 * 링크 : https://www.acmicpc.net/problem/14267
 */

import java.util.*;
import java.io.*;

public class Main {

    static int[] parents;
    static int[] scores;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        parents = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i=1; i<=N; i++) {
            parents[i] = Integer.parseInt(st.nextToken());
        }

        scores = new int[N + 1];
        while (K-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int index = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());
            scores[index] += score;
        }

        dp = new int[N + 1];
        Arrays.fill(dp, -1);

        StringBuilder sb = new StringBuilder();
        for (int i=1; i<=N; i++) {
            sb.append(dp[i] = getScore(i)).append(" ");
        }

        System.out.println(sb);
    }

    private static int getScore(int index) {
        if (parents[index] == -1) {
            return scores[index];
        }
        if (dp[parents[index]] != -1) {
            return dp[parents[index]] + scores[index];
        }

        return getScore(parents[index]) + scores[index];
    }
}