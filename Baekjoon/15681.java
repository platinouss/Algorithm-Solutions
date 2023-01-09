/**
 * 백준 15681번 (골드 5)
 * 문제 이름 : 트리와 쿼리
 * 알고리즘 분류 : 트리, DFS, DP
 * 링크 : https://www.acmicpc.net/problem/15681
 */

import java.util.*;
import java.io.*;

public class Main {

    static int[] dp;
    static boolean[] visited;
    static List<List<Integer>> list = new ArrayList<>();

    private static int dfs(int index) {
        if (dp[index] != 0) {
            return dp[index];
        }

        int count = 1;
        for (int v : list.get(index)) {
            if (!visited[v]) {
                visited[v] = true;
                count += dfs(v);
            }
        }
        return dp[index] = count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int rootNum = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for (int i=0; i<=N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i=1; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int sIndex = Integer.parseInt(st.nextToken());
            int eIndex = Integer.parseInt(st.nextToken());
            list.get(sIndex).add(eIndex);
            list.get(eIndex).add(sIndex);
        }

        dp = new int[N + 1];
        visited = new boolean[N + 1];
        visited[rootNum] = true;
        dfs(rootNum);

        while (K-- > 0) {
            int command = Integer.parseInt(br.readLine());
            sb.append(dp[command]).append("\n");
        }
        System.out.print(sb);
    }
}