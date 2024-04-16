/**
 * [Baekjoon] 3109. 빵집
 * https://www.acmicpc.net/problem/3109
 *
 */

import java.io.*;
import java.util.*;

class Main {

    static int N, M, count;
    static char[][] arr;
    static int[] di = {-1, 0, 1};
    static int[] dj = {1, 1, 1};

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        count = 0;
        arr = new char[N][M];
        for (int i=0; i<N; i++) {
            arr[i] = br.readLine().toCharArray();
        }
    }

    private static boolean isOutOfRange(int a, int b) {
        return a < 0 || a >= N || b < 0 || b >= M;
    }

    private static boolean dfs(int a, int b) {
        if (b == M - 1) {
            count++;
            return true;
        }
        for (int k=0; k<di.length; k++) {
            int ii = a + di[k];
            int jj = b + dj[k];
            if (isOutOfRange(ii, jj) || arr[ii][jj] == 'x') {
                continue;
            }
            arr[ii][jj] = 'x';
            if (dfs(ii, jj)) {
                return true;
            }
        }
        return false;
    }

    public static void main (String[] args) throws IOException {
        input();
        for (int i=0; i<N; i++) {
            dfs(i, 0);
        }
        System.out.println(count);
    }
}

