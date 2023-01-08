/**
 * 백준 1043번 (골드 4)
 * 문제 이름 : 거짓말
 * 알고리즘 분류 : 그래프, 유니온 파인드
 * 링크 : https://www.acmicpc.net/problem/1043
 */

import java.util.*;
import java.io.*;

public class Main {

    static int[] arr;
    static List<Integer> persons = new ArrayList<>();
    static List<List<Integer>> parties = new ArrayList<>();

    private static void union(int v1, int v2) {
        int a = find(v1);
        int b = find(v2);

        if (a != b) {
            arr[b] = a;
        }
    }

    private static int find(int n) {
        if (arr[n] != n) {
            return arr[n] = find(arr[n]);
        }
        return arr[n];
    }

    private static boolean isTruth(List<Integer> party) {
        for (int v : party) {
            for (int person : persons) {
                if (find(v) == find(person)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int cnt = Integer.parseInt(st.nextToken());
        if (cnt > 0) {
            while (cnt-- > 0) {
                persons.add(Integer.parseInt(st.nextToken()));
            }
        }

        arr = new int[N + 1];
        for (int i=1; i<=N; i++) {
            arr[i] = i;
        }

        for (int i=0; i<K; i++) {
            parties.add(new ArrayList<>());
            st = new StringTokenizer(br.readLine(), " ");
            cnt = Integer.parseInt(st.nextToken());

            List<Integer> party = parties.get(i);
            int before = Integer.parseInt(st.nextToken());
            party.add(before);
            cnt--;
            while (cnt-- > 0) {
                int v = Integer.parseInt(st.nextToken());
                union(before, v);
                party.add(v);
            }
        }

        int result = 0;
        for (List<Integer> party : parties) {
            if (!isTruth(party)) {
                result++;
            }
        }

        System.out.println(result);
    }
}