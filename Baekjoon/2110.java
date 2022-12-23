/**
 * 백준 2110번 (골드 4)
 * 문제 이름 : 공유기 설치
 * 알고리즘 분류 : 이분 탐색, Parametric Search
 * 문제 링크 : https://www.acmicpc.net/problem/2110
 */

package com.company;

import java.io.*;
import java.util.*;

public class Main {

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());

        arr = new int[N];
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        searchRange(N, count);
    }

    private static void searchRange(int N, int count) {
        int sValue = 1;
        int eValue = arr[N - 1] - arr[0];
        while (sValue < eValue) {
            int mid = (sValue + eValue + 1) / 2;
            if (getRouterCount(N, mid) < count) {
                eValue = mid - 1;
            } else {
                sValue = mid;
            }
        }
        System.out.println(sValue);
    }

    private static int getRouterCount(int N, int m) {
        int count = 1;
        int sIndex = arr[0];
        for (int i=1; i<N; i++) {
            if (arr[i] - sIndex >= m) {
                sIndex = arr[i];
                count++;
            }
        }
        return count;
    }
}