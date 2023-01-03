/**
 * 백준 20166번 (골드 5)
 * 문제 이름 : 문자열 지옥에 빠진 호석
 * 알고리즘 분류 : 그래프 탐색, 깊이 우선 탐색, 해시
 * 링크 : https://www.acmicpc.net/problem/20166
 */

import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int M;
    static char[][] arr;
    static int[] di = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dj = {-1, 0, 1, -1, 1, -1, 0, 1};
    static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new char[N][M];
        for (int i=0; i<N; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        String[] condition = new String[K];
        for (int i=0; i<K; i++) {
            condition[i] = br.readLine();
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                dfs(i, j, 1, String.valueOf(arr[i][j]));
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String s : condition) {
            sb.append(map.getOrDefault(s, 0)).append("\n");
        }

        System.out.print(sb);
    }

    private static void dfs(int a, int b, int depth, String s) {
        if (depth > 5) {
            return;
        }
        map.put(s, map.getOrDefault(s, 0) + 1);

        for (int k=0; k<di.length; k++) {
            int ii = a + di[k];
            int jj = b + dj[k];

            if (ii < 0) { ii = N - 1; }
            if (jj < 0) { jj = M - 1; }
            if (ii >= N) { ii = 0; }
            if (jj >= M) { jj = 0; }

            dfs(ii, jj, depth + 1, s + arr[ii][jj]);
        }
    }
}