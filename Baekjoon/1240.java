/**
 * 백준 1240번 (골드 5)
 * 문제 이름 : 노드 사이의 거리
 * 알고리즘 분류 : 트리, DFS
 * 링크 : https://www.acmicpc.net/problem/1240
 */

import java.util.*;
import java.io.*;

public class Main {

    static class Node {
        int index, distance;

        public Node(int i, int d) {
            this.index = i;
            this.distance = d;
        }
    }

    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static List<List<Node>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for (int i=0; i<=N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int sIndex = Integer.parseInt(st.nextToken());
            int eIndex = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            list.get(sIndex).add(new Node(eIndex, distance));
            list.get(eIndex).add(new Node(sIndex, distance));
        }

        while (K-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            visited = new boolean[N + 1];
            visited[s] = true;
            dfs(s, e, 0);
        }
        System.out.print(sb);
    }

    private static void dfs(int s, int end, int d) {
        if (s == end) {
            sb.append(d).append("\n");
            return;
        }

        for (Node n : list.get(s)) {
            int i = n.index;
            int v = n.distance;
            if (!visited[i]) {
                visited[i] = true;
                dfs(i, end, d + v);
            }
        }
    }
}