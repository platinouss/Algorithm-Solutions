package com.company;

import java.io.*;
import java.util.*;

class Main {

    static int result;
    static int[] arr;
    static boolean[] visited;
    static boolean[] finished;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int totalCount = Integer.parseInt(br.readLine());
        for (int k=0; k<totalCount; k++) {
            int count = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            arr = new int[count + 1];
            visited = new boolean[count + 1];
            finished = new boolean[count + 1];

            for (int i=1; i<=count; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            result = 0;
            for (int i=1; i<=count; i++) {
                dfs(i);
            }
            sb.append(count - result).append("\n");
        }
        System.out.print(sb);
    }

    private static void dfs(int index) {
        if (visited[index]) { return; }
        visited[index] = true;
        int nextIndex = arr[index];
        if (!visited[nextIndex]) { dfs(nextIndex); }
        else {
            if (!finished[nextIndex]) {
                for (int i=nextIndex; i != index; i=arr[i]) { result++; }
                result++;
            }
        }
        finished[index] = true;
    }
}