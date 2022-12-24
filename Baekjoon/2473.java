/**
 * 백준 2473번 (골드 3)
 * 문제 이름 : 세 용액
 * 알고리즘 분류 : 이분 탐색, 투 포인터
 * 링크 : https://www.acmicpc.net/problem/2473
 */

import java.io.*;
import java.util.*;

public class Main {

    static long[] arr;
    static long[] result = new long[3];
    static long min = 3_000_000_001L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .toArray();

        Arrays.sort(arr);

        for (int i=0; i<N-2; i++) {
            selectTwoValue(i, N);
        }

        Arrays.sort(result);
        System.out.println(result[0] + " " + result[1] + " " + result[2]);
    }

    private static void selectTwoValue(int index, int N) {
        int sIndex = index + 1;
        int eIndex = N - 1;
        while (sIndex < eIndex) {
            long v = arr[sIndex] + arr[eIndex] + arr[index];
            long abs = Math.abs(v);
            if (min > abs) {
                min = abs;
                result[0] = arr[sIndex];
                result[1] = arr[index];
                result[2] = arr[eIndex];
            }
            if (v >= 0) {
                eIndex--;
            } else {
                sIndex++;
            }
        }
    }
}