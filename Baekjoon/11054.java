/**
 * 백준 11054번 (골드 4)
 * 문제 이름 : 가장 긴 바이토닉 부분 수열
 * 알고리즘 분류 : DP
 * 링크 : https://www.acmicpc.net/problem/11054
 */

import java.util.*;
import java.io.*;

class Main {

    static int N;
    static int[] arr;
    static int[] ldp;
    static int[] rdp;

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        ldp = new int[N];
        rdp = new int[N];
        for (int i=0; i<N; i++) {
            LIS(i);
        }
        for (int i=N-1; i>=0; i--) {
            LDS(i);
        }

        int max = 0;
        for (int i=0; i<N; i++) {
            max = Math.max(max, ldp[i] + rdp[i]);
        }

        System.out.println(max - 1);
    }

    private static void LIS(int index) {
        rdp[index] = 1;
        for (int i=0; i<index; i++) {
            if (arr[i] < arr[index]) {
                rdp[index] = Math.max(rdp[index], rdp[i] + 1);
            }
        }
    }

    private static void LDS(int index) {
        ldp[index] = 1;
        for (int i=N-1; i>=0; i--) {
            if (arr[i] < arr[index]) {
                ldp[index] = Math.max(ldp[index], ldp[i] + 1);
            }
        }
    }
}
