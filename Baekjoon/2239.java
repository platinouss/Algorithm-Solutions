/**
 * 백준 2239번 (골드 4)
 * 문제 이름 : 스도쿠
 * 알고리즘 분류 : 백트래킹, 구현
 * 링크 : https://www.acmicpc.net/problem/2239
 */

import java.io.*;
import java.util.*;

public class Main {

    static int[][] arr;
    static boolean isFinished = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[9][9];
        for (int i=0; i<9; i++) {
            arr[i] = Arrays.stream(br.readLine().split(""))
                    .mapToInt(v -> v.charAt(0) - '0')
                    .toArray();
        }
        dfs(0);

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int depth) {
        if (depth == 81) {
            isFinished = true;
            return;
        }
        int a = depth / 9;
        int b = depth % 9;
        if (arr[a][b] != 0) {
            dfs(depth + 1);
        } else {
            for (int i=1; i<10; i++) {
                if (!isValid(a, b, i)) {
                    continue;
                }
                arr[a][b] = i;
                dfs(depth + 1);
                if (isFinished) {
                    return;
                }
                arr[a][b] = 0;
            }
        }
    }

    private static boolean isValid(int a, int b, int v) {
        for (int k=0; k<9; k++) {
            if (arr[a][k] == v || arr[k][b] == v) {
                return false;
            }
        }
        int ii = (a / 3) * 3;
        int jj = (b / 3) * 3;
        for (int i=ii; i<ii+3; i++) {
            for (int j=jj; j<jj+3; j++) {
                if (arr[i][j] == v) {
                    return false;
                }
            }
        }
        return true;
    }
}