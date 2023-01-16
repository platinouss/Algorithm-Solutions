/**
 * 백준 1956번 (골드 4)
 * 문제 이름 : 운동
 * 알고리즘 분류 : 그래프, 플로이드 워셜
 * 링크 : https://www.acmicpc.net/problem/1956
 */

import java.util.*;
import java.io.*;

public class Main {

    static final int MAX_VALUE = 400 * 10000 + 1;

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
            for (int j=1; j<=N; j++) {
                if (i == j) {
                    arr[i][j] = 0;
                }
            }
        }
        while (K-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int sIndex = Integer.parseInt(st.nextToken());
            int eIndex = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            arr[sIndex][eIndex] = distance;
        }
        for (int k=1; k<=N; k++) {
            for (int i=1; i<=N; i++) {
                for (int j=1; j<=N; j++) {
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }
        int result = MAX_VALUE;
        for (int i=1; i<=N; i++) {
            for (int j=1; j<=N; j++) {
                if (i == j) {
                    continue;
                }
                if (arr[i][j] != MAX_VALUE && arr[j][i] != MAX_VALUE) {
                    result = Math.min(result, arr[i][j] + arr[j][i]);
                }
            }
        }
        if (result == MAX_VALUE) {
            result = -1;
        }
        System.out.println(result);
    }
}
