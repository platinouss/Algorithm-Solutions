/**
 * 백준 1759번 (골드 5)
 * 문제 이름 : 암호 만들기
 * 알고리즘 분류 : 조합, 백트래킹
 * 링크 : https://www.acmicpc.net/problem/1759
 */

import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int K;
    static char[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new char[K];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<K; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr);

        getResult(0, 0, 0, "");
        System.out.print(sb);
    }

    private static void getResult(int depth, int index, int bitmask, String str) {
        if (depth == N) {
            if (isCorrectStr(str)) {
                sb.append(str).append("\n");
            }
            return;
        }
        for (int i=index; i<K; i++) {
            if ((bitmask & (1 << i)) == 0) {
                getResult(depth + 1, i, bitmask | (1 << i), str + arr[i]);
            }
        }
    }

    private static boolean isCorrectStr(String str) {
        int a = 0;
        int b = 0;
        for (int i=0; i<N; i++) {
            char c = str.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                a++;
                continue;
            }
            b++;
        }
        if (a >= 1 && b >= 2) {
            return true;
        }
        return false;
    }
}