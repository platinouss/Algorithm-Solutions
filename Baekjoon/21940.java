/**
 * 백준 21940번 (골드 4)
 * 문제 이름 : 가운데에서 만나기
 * 알고리즘 분류 : 그래프, 플로이드 워셜
 * 링크 : https://www.acmicpc.net/problem/21940
 */

import java.util.*;
import java.io.*;

public class Main {

    static final int MAX_VALUE = 100_001;

    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        arr = new int[N + 1][N + 1];
        for (int[] ar : arr) {
            Arrays.fill(ar, MAX_VALUE);
        }
        for (int i=1; i<=N; i++) {
            for (int j=1; j<=N; j++) {
                if (i == j) {
                    arr[i][j] = 0;
                }
            }
        }
        while (K-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int sIndex = Integer.parseInt(st.nextToken());
            int eIndex = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            arr[sIndex][eIndex] = distance;
        }
        for (int k=1; k<=N; k++) {
            for (int i=1; i<=N; i++) {
                for (int j=1; j<=N; j++) {
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }
        List<Integer> tmp = new ArrayList<>();
        K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        while (K-- > 0) {
            tmp.add(Integer.parseInt(st.nextToken()));
        }
        int answer = MAX_VALUE;
        List<Integer> list = new ArrayList<>();
        for (int k=1; k<=N; k++) {
            int result = 0;
            for (int v : tmp) {
                result = Math.max(result, arr[v][k] + arr[k][v]);
            }
            if (answer > result) {
                list = new ArrayList<>();
                list.add(k);
                answer = result;
            } else if (answer == result) {
                list.add(k);
            }
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (int idx : list) {
            sb.append(idx).append(" ");
        }
        System.out.println(sb);
    }
}