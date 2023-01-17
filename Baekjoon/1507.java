/**
 * 백준 1507번 (궁금한 민호)
 * 문제 이름 : 궁금한 민호
 * 알고리즘 분류 : 그래프, 플로이드 워셜
 * 링크 : https://www.acmicpc.net/problem/1507
 */

import java.util.*;
import java.io.*;

public class Main {

    static int[][] arr;
    static int[][] tmp;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        tmp = new int[N][N];
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                tmp[i][j] = arr[i][j];
            }
        }
        for (int k=0; k<N; k++) {
            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    if (i == k  || j == k) {
                        continue;
                    }
                    if (arr[i][j] > arr[i][k] + arr[k][j]) {
                        System.out.println("-1");
                        return;
                    }
                    if (arr[i][j] == arr[i][k] + arr[k][j]) {
                        tmp[i][j] = 0;
                    }
                }
            }
        }
        int result = 0;
        visited = new boolean[N][N];
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (tmp[i][j] != 0 && !visited[i][j]) {
                    result += arr[i][j];
                    visited[i][j] = true;
                    visited[j][i] = true;
                }
            }
        }
        System.out.println(result);
    }
}