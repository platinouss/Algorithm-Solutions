/**
 * 백준 7453번 (골드 2)
 * 문제 이름 : 합이 0인 네 정수
 * 알고리즘 분류 : 정렬, 이분 탐색 / 투 포인터
 * 링크 : https://www.acmicpc.net/problem/7453
 */

import java.io.*;
import java.util.*;

public class Main {

    static long result = 0L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][4];
        for (int i=0; i<N; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }
        int count = 0;
        int[][] sums = new int[2][N * N];
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                sums[0][count] = arr[i][0] + arr[j][1];
                sums[1][count] = arr[i][2] + arr[j][3];
                count++;
            }
        }
        Arrays.sort(sums[0]);
        Arrays.sort(sums[1]);

        int sIndex = 0;
        int eIndex = sums[1].length - 1;
        while (sIndex < sums[0].length && eIndex >= 0) {
            int sum = sums[0][sIndex] + sums[1][eIndex];
            if (sum == 0) {
                int l = 1;
                int r = 1;
                while (sIndex < (N * N) - 1 && sums[0][sIndex] == sums[0][sIndex + 1]) {
                    sIndex++;
                    l++;
                }
                while (0 < eIndex && sums[1][eIndex] == sums[1][eIndex - 1]) {
                    eIndex--;
                    r++;
                }
                result += ((long) l * r);
            }
            if (sum > 0) {
                eIndex--;
            } else {
                sIndex++;
            }
        }
        System.out.println(result);
    }
}