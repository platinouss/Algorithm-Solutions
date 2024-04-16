/**
 * [Baekjoon] 11660. 구간 합 구하기 5
 * https://www.acmicpc.net/problem/11660
 *
 */

import java.io.*;
import java.util.*;

class Main {

    static class Node {
        int i, j;

        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    static int N, K;
    static int[][] arr;
    static Node[][] questions;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N + 1][N + 1];
        for (int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=1; j<=N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        questions = new Node[K][2];
        for (int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            Node start = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            Node end = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            questions[i][0] = start;
            questions[i][1] = end;
        }
    }

    public static void main (String[] args) throws IOException {
        input();
        int[][] sum = new int[N + 1][N + 1];
        for (int i=1; i<=N; i++) {
            for (int j=1; j<=N; j++) {
                sum[i][j] = arr[i][j] + sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1];
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Node[] question : questions) {
            Node start = question[0];
            Node end = question[1];
            sb.append(sum[end.i][end.j] - sum[start.i-1][end.j] - sum[end.i][start.j-1] + sum[start.i-1][start.j-1]).append("\n");
        }
        System.out.println(sb);
    }
}

