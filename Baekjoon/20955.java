/**
 * 백준 20955번 (골드 4)
 * 문제 이름 : 민서의 응급 수술
 * 알고리즘 분류 : 트리, 유니온 파인드
 * 링크 : https://www.acmicpc.net/problem/20955
 */

import java.util.*;
import java.io.*;

public class Main {

    static int[] parents;
    static List<List<Integer>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        parents = new int[N + 1];
        Arrays.fill(parents, -1);

        int count = 0;
        while (K-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int sIndex = Integer.parseInt(st.nextToken());
            int eIndex = Integer.parseInt(st.nextToken());
            if (!union(sIndex, eIndex)) {
                count++;
            }
        }

        for (int i=1; i<=N; i++) {
            if (parents[i] == -1) {
                count++;
            }
        }

        System.out.println(count - 1);
    }

    private static boolean union(int sIndex, int eIndex) {
        int a = find(sIndex);
        int b = find(eIndex);
        if (a == b) {
            return false;
        }
        parents[b] = a;
        return true;
    }

    private static int find(int index) {
        if (parents[index] == -1) {
            return index;
        }
        return parents[index] = find(parents[index]);
    }
}