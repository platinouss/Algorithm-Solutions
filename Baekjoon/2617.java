/**
 * 백준 2617번 (골드 4)
 * 문제 이름 : 구슬 찾기
 * 알고리즘 분류 : 그래프, 플로이드 워셜
 * 링크 : https://www.acmicpc.net/problem/2617
 */

import java.util.*;
import java.io.*;

public class Main {

    static final int MAX_VALUE = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][N];
        for (int[] ar : arr) {
            Arrays.fill(ar, MAX_VALUE);
        }
        while (K-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int big = Integer.parseInt(st.nextToken());
            int small = Integer.parseInt(st.nextToken());
            arr[big - 1][small - 1] = 1;
        }

        for (int k=0; k<N; k++) {
            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }

        int[] bigCount = new int[N];
        int[] smallCount = new int[N];
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (i == j || arr[i][j] == MAX_VALUE) {
                    continue;
                }
                bigCount[i]++;
                smallCount[j]++;
            }
        }

        int result = 0;
        int m = N / 2 + 1;
        for (int k=0; k<N; k++) {
            if (bigCount[k] >= m) {
                result++;
            }
            if (smallCount[k] >= m) {
                result++;
            }
        }

        System.out.println(result);
    }
}