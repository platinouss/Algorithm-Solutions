/**
 * 백준 2623번 (골드 3)
 * 문제 이름 : 음악 프로그램
 * 알고리즘 분류 : 그래프, 위상 정렬
 * 링크 : https://www.acmicpc.net/problem/2623
 */

import java.util.*;
import java.io.*;

public class Main {

    static int[] indegrees;
    static StringBuilder sb = new StringBuilder();
    static List<List<Integer>> list = new ArrayList<>();

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
            st = new StringTokenizer(br.readLine(), " ");
            int cnt = Integer.parseInt(st.nextToken());
            int before = Integer.parseInt(st.nextToken());
            cnt--;

            while (cnt-- > 0) {
                int index = Integer.parseInt(st.nextToken());
                list.get(before).add(index);
                indegrees[index]++;
                before = index;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i=1; i<=N; i++) {
            if (indegrees[i] == 0) {
                q.add(i);
            }
        }

        int count = 0;
        while (!q.isEmpty()) {
            int index = q.poll();
            sb.append(index).append("\n");
            count++;

            for (int idx : list.get(index)) {
                indegrees[idx]--;
                if (indegrees[idx] == 0) {
                    q.add(idx);
                }
            }
        }

        if (count != N) {
            System.out.println(0);
            return;
        }

        System.out.print(sb);
    }
}