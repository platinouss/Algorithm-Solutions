/**
 * 백준 14938번 (골드 4)
 * 문제 이름 : 서강그라운드
 * 알고리즘 분류 : 그래프, 플로이드 워셜
 */

import java.util.*;
import java.io.*;

public class Main {

    static final int MAX_VALUE = 100_001;

    static int[] items;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int limit = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        items = new int[N + 1];
        for (int i=1; i<=N; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }
        arr = new int[N + 1][N + 1];
        for (int[] ar: arr) {
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
            arr[eIndex][sIndex] = distance;
        }
        for (int k=1; k<=N; k++) {
            for (int i=1; i<=N; i++) {
                for (int j=1; j<=N; j++) {
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }
        int max = 0;
        for (int i=1; i<=N; i++) {
            int tmp = 0;
            for (int j=1; j<=N; j++) {
                if (arr[i][j] <= limit) {
                    tmp += items[j];
                }
            }
            max = Math.max(max, tmp);
        }
        System.out.println(max);
    }
}