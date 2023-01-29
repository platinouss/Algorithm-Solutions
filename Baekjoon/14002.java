/**
 * 백준 14002번 (골드 4)
 * 문제 이름 : 가장 긴 증가하는 부분 수열 4
 * 알고리즘 분류 : DP
 * 링크 : https://www.acmicpc.net/problem/14002
 */

import java.util.*;
import java.io.*;

class Main {

    static int[] arr;
    static int[] before;
    static int[] dp;

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        before = new int[N + 1];
        dp = new int[N + 1];

        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        int lastIndex = 0;
        for (int i=1; i<=N; i++) {
            for (int j=0; j<i; j++) {
                if (arr[i] > arr[j]) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        before[i] = j;
                    }
                }
            }
            if (count < dp[i]) {
                count = dp[i];
                lastIndex = i;
            }
        }

        sb.append(count).append("\n");

        Stack<Integer> stack = new Stack<>();
        stack.add(lastIndex);
        while (count-- > 1) {
            stack.add(before[lastIndex]);
            lastIndex = before[lastIndex];
        }

        while (!stack.isEmpty()) {
            sb.append(arr[stack.pop()]).append(" ");
        }

        System.out.println(sb);
    }
}
