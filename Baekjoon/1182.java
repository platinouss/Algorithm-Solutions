/**
 * 백준 1182번 (실버 2)
 * 문제 이름 : 부분수열의 합
 * 알고리즘 분류 : 백트래킹
 * 링크 : https://www.acmicpc.net/problem/1182
 */

import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int condition;
    static int[] arr;
    static int result;
    static boolean[] check;

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        condition = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        result = 0;
        check = new boolean[N + 1];
        for (int n=1; n<=N; n++) {
            getList(n, 0, 0);
        }

        System.out.println(result);
    }

    private static void getList(int finish, int length, int index) {
        if (length == finish) {
            calSum();
        }
        for (int i=index; i<N; i++) {
            check[i] = true;
            getList(finish, length + 1, i + 1);
            check[i] = false;
        }
    }

    public static void calSum() {
        int sum = 0;
        for (int i=0; i<N; i++) {
            if (check[i]) {
                sum += arr[i];
            }
        }
        if (sum == condition) {
            result++;
        }
    }
}