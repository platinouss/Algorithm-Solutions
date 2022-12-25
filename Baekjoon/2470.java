/**
 * 백준 2470 (골드 5)
 * 문제 이름 : 두 용액
 * 알고리즘 분류 : 이분 탐색, 투 포인터
 * 링크 : https://www.acmicpc.net/problem/2470
 */

import java.io.*;
import java.util.*;

public class Main {

    static int[] arr;
    static int[] result = new int[2];
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Arrays.sort(arr);

        int sIndex = 0;
        int eIndex = N - 1;
        while (sIndex < eIndex) {
            int v = arr[sIndex] + arr[eIndex];
            int abs = Math.abs(v);
            if (min > abs) {
                min = abs;
                result[0] = arr[sIndex];
                result[1] = arr[eIndex];
            }
            if (0 <= v) {
                eIndex--;
            } else {
                sIndex++;
            }
        }

        System.out.println(result[0] + " " + result[1]);
    }
}