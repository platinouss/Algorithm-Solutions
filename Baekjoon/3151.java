/**
 * 백준 3151번 (골드 4)
 * 문제 이름 : 합이 0
 * 알고리즘 분류 : 이분탐색, 투 포인터
 * 링크 : https://www.acmicpc.net/problem/3151
 */

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] arr;
    static long count = 0L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
        for (int i=0; i<N-2; i++) {
            if (arr[i] > 0) {
                break;
            }
            getResult(i, N);
        }

        System.out.println(count);
    }

    private static void getResult(int index, int N) {
        int sIndex = index + 1;
        int eIndex = N - 1;
        while (sIndex < eIndex) {
            int sum = arr[index] + arr[sIndex] + arr[eIndex];
            if (0 == sum) {
                int l = 1;
                int r = 1;
                if (arr[sIndex] == arr[eIndex]) {
                    long n = eIndex - sIndex + 1;
                    count += (n * (n-1) / 2);
                    break;
                }
                while (arr[sIndex] == arr[sIndex + 1]) {
                    l++;
                    sIndex++;
                }
                while (arr[eIndex] == arr[eIndex - 1]) {
                    r++;
                    eIndex--;
                }
                count += ((long) l * r);
            }
            if (0 >= sum) {
                sIndex++;
            } else {
                eIndex--;
            }
        }
    }
}