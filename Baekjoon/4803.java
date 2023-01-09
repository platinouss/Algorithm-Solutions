/**
 * 백준 4803번 (골드 4)
 * 문제 이름 : 트리
 * 알고리즘 분류 : 트리, DFS
 * 링크 : https://www.acmicpc.net/problem/4803
 */

import java.util.*;
import java.io.*;

public class Main {

    static boolean check;
    static boolean[] visited;
    static List<List<Integer>> list;

    private static void dfs(int index, int root) {
        for (int v : list.get(index)) {
            if (visited[v]) {
                if (v != root) {
                    check = true;
                }
            } else {
                visited[v] = true;
                dfs(v, index);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = 1;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int nodeCount = Integer.parseInt(st.nextToken());
            int lineCount = Integer.parseInt(st.nextToken());
            if (nodeCount == 0 && lineCount == 0) {
                break;
            }

            visited = new boolean[nodeCount + 1];
            Arrays.fill(visited, false);

            list = new ArrayList<>();
            for (int i=0; i<=nodeCount; i++) {
                list.add(new ArrayList<>());
            }

            for (int i=0; i<lineCount; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int sIndex = Integer.parseInt(st.nextToken());
                int eIndex = Integer.parseInt(st.nextToken());
                list.get(sIndex).add(eIndex);
                list.get(eIndex).add(sIndex);
            }

            int treeCount = 0;
            for (int i=1; i<=nodeCount; i++) {
                check = false;
                if (!visited[i]) {
                    visited[i] = true;
                    dfs(i, 0);
                    if (!check) {
                        treeCount++;
                    }
                }
            }

            sb.append("Case ").append(N).append(": ");
            if (treeCount > 1) {
                sb.append("A forest of ").append(treeCount).append(" trees.");
            } else if (treeCount == 1) {
                sb.append("There is one tree.");
            } else {
                sb.append("No trees.");
            }
            sb.append("\n");
            N++;
        }
        System.out.println(sb);
    }
}