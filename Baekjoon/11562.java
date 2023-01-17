/**
 * 백준 11562번 (골드 3)
 * 문제 이름 : 백양로 브레이크
 * 알고리즘 분류 : 그래프, 플로이드 워셜
 * 링크 : https://www.acmicpc.net/problem/11562
 */

import java.util.*;
import java.io.*;

public class Main {

    static final int MAX_VALUE = 251;

    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        arr = new int[N + 1][N + 1];
        for (int[] ar : arr) {
            Arrays.fill(ar, MAX_VALUE);
        }
        for (int i=1; i<=N; i++) {
            arr[i][i] = 0;
        }
        while (K-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int sIndex = Integer.parseInt(st.nextToken());
            int eIndex = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr[sIndex][eIndex] = 0;
            if (v == 0) {
                arr[eIndex][sIndex] = 1;
            }
            if (v == 1) {
                arr[eIndex][sIndex] = 0;
            }
        }
        for (int k=1; k<=N; k++) {
            for (int i=1; i<=N; i++) {
                for (int j=1; j<=N; j++) {
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        K = Integer.parseInt(br.readLine());
        while (K-- > 0) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            sb.append(arr[s][e]).append("\n");
        }
        System.out.println(sb);
    }
}