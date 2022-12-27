/**
 * 백준 2531번 (실버 1)
 * 문제 이름 : 회전 초밥
 * 알고리즘 분류 : 투 포인터
 * 링크 : https://www.acmicpc.net/problem/2531
 */

import java.io.*;
import java.util.*;

public class Main {

    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int dishCount = Integer.parseInt(st.nextToken());
        int sushiCount = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int couponNumber = Integer.parseInt(st.nextToken());

        int[] arr = new int[dishCount + (k - 1)];
        for (int i=0; i<dishCount; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int idx = 0;
        for (int i=dishCount; i<arr.length; i++) {
            arr[i] = arr[idx];
            idx++;
        }

        int count = 1;
        int[] visited = new int[sushiCount + 1];
        visited[couponNumber] = 3001;
        for (int i=0; i<k; i++) {
            if (++visited[arr[i]] == 1) {
                count++;
            }
        }
        for (int i=k; i<arr.length; i++) {
            if (--visited[arr[i - k]] == 0) {
                count--;
            }
            if (++visited[arr[i]] == 1) {
                count++;
            }
            max = Math.max(max, count);
            if (max == k + 1) {
                break;
            }
        }

        System.out.println(max);
    }
}