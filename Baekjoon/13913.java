/**
 * 백준 13913번 (골드 4)
 * 문제 이름 : 숨바꼭질 4
 * 알고리즘 분류 : 그래프, BFS
 * 링크 : https://www.acmicpc.net/problem/13913
 */

import java.util.*;
import java.io.*;

public class Main {

    static int[] before;
    static int[] counts;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int sIndex = Integer.parseInt(st.nextToken());
        int eIndex = Integer.parseInt(st.nextToken());
        if (sIndex == eIndex) {
            System.out.println("0");
            System.out.println(sIndex);
            return;
        }
        int tmp = Math.max(sIndex, eIndex);
        before = new int[tmp * 2 + 1];
        counts = new int[tmp * 2 + 1];

        before[sIndex] = -1;
        counts[sIndex] = 1;
        bfs(sIndex, eIndex);

        System.out.println(counts[eIndex] - 1);
        System.out.println(sb);
    }

    private static void bfs(int sIndex, int eIndex) {
        Queue<Integer> q = new LinkedList<>();
        q.add(sIndex);
        while (!q.isEmpty()) {
            int idx = q.remove();
            for (int k=0; k<3; k++) {
                int index = idx;
                if (k == 0) { index += 1; }
                if (k == 1) { index -= 1; }
                if (k == 2) { index *= 2; }
                if (!isOutOfRange(index) || before[index] != 0 || counts[index] != 0) {
                    continue;
                }
                before[index] = idx;
                counts[index] = counts[idx] + 1;
                if (index == eIndex) {
                    getResult(index);
                    return;
                }
                q.add(index);
            }
        }
    }

    private static void getResult(int idx) {
        sb.append(idx).append(" ");
        while (before[idx] != -1) {
            sb.insert(0, before[idx] + " ");
            idx = before[idx];
        }
    }

    private static boolean isOutOfRange(int idx) {
        return idx >= 0 && idx < before.length;
    }
}