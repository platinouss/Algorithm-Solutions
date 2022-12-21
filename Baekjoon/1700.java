/**
 * 백준 1700번 (골드 1)
 * 문제 이름 : 멀티탭 스케줄링
 * 알고리즘 분류 : 그리디
 * 링크 : https://www.acmicpc.net/problem/1700
 */

import java.io.*;
import java.util.*;

public class Main {

    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int plugCount = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        boolean[] used = new boolean[N + 1];

        int count = 0;
        int result = 0;
        for (int i=0; i<N; i++) {
            int v = arr[i];
            if (!used[v]) {
                if (count < plugCount) { used[v] = true; count++; }
                else {
                    list.clear();
                    for (int j=i; j<N; j++) {
                        if (used[arr[j]] && !list.contains(arr[j])) { list.add(arr[j]); }
                    }
                    if (list.size() != plugCount) {
                        for (int j=0; j<=N; j++) {
                            if (used[j] && !list.contains(j)) { used[j] = false; break; }
                        }
                    } else {
                        int idx = list.get(list.size() - 1);
                        used[idx] = false;
                    }
                    used[v] = true;
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}