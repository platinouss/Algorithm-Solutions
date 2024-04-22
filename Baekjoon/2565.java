/**
 * [Baekjoon] 2565. 전깃줄
 * https://www.acmicpc.net/problem/2565
 *
 */

import java.io.*;
import java.util.*;

class Main {

    static class Node {
        int start, end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    static int N;
    static int[] dp;
    static List<Node> list;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N];
        list = new ArrayList<>();
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new Node(start, end));
        }
        Collections.sort(list, (o1, o2) -> o1.start- o2.start);
    }

    private static int getCount(int index) {
        if (dp[index] != 0) {
            return dp[index];
        }
        dp[index] = 1;
        for (int i=index + 1; i<N; i++) {
            if (list.get(index).end < list.get(i).end) {
                dp[index] = Math.max(dp[index], getCount(i) + 1);
            }
        }
        return dp[index];
    }

    public static void main (String[] args) throws IOException {
        input();
        int max = 0;
        for (int i=0; i<list.size(); i++) {
            max = Math.max(max, getCount(i));
        }
        System.out.println(N - max);
    }
}
