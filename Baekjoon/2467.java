/**
 * 백준 2467번 (골드 5)
 * 문제 이름 : 용액
 * 알고리즘 분류 : 이분 탐색, 투 포인터
 * 링크 : https://www.acmicpc.net/problem/2467
 */

import java.io.*;
import java.util.*;

public class Main {

    static int[] result = new int[2];
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int sIndex = 0;
        int eIndex = N - 1;
        while (sIndex < eIndex) {
            int v1 = arr[sIndex];
            int v2 = arr[eIndex];
            int abs = Math.abs(v1 + v2);
            if (min > abs) {
                min = abs;
                result[0] = v1;
                result[1] = v2;
            }
            if (v1 + v2 >= 0) {
                eIndex--;
            } else {
                sIndex++;
            }
        }

        System.out.println(result[0] + " " + result[1]);
    }
}