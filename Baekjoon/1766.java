/**
 * 백준 1766번 (골드 2)
 * 문제 이름 : 문제집
 * 알고리즘 분류 : 위상 정렬, 우선순위 큐
 * 링크 : https://www.acmicpc.net/problem/1766
 */

import java.util.*;
import java.io.*;

public class Main {

    static int[] indegrees;
    static List<List<Integer>> list = new ArrayList<>();
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        indegrees = new int[N + 1];
        for (int i=0; i<=N; i++) {
            list.add(new ArrayList<>());
        }
        while (K-- > 0) {
            st = new StringTokenizer(br.readLine());
            int sIndex = Integer.parseInt(st.nextToken());
            int eIndex = Integer.parseInt(st.nextToken());
            list.get(sIndex).add(eIndex);
            indegrees[eIndex]++;
        }
        for (int i=1; i<=N; i++) {
            if (indegrees[i] == 0) {
                pq.add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int idx = pq.poll();
            for (int v : list.get(idx)) {
                indegrees[v]--;
                if (indegrees[v] == 0) {
                    pq.add(v);
                }
            }
            sb.append(idx).append(" ");
        }
        System.out.println(sb);
    }
}