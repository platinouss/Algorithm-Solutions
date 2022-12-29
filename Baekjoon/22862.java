/**
 * 백준 22862번 (골드 5)
 * 문제 이름 : 가장 긴 짝수 연속한 부분 수열 (large)
 * 알고리즘 분류 : 투 포인터
 * 링크 : https://www.acmicpc.net/problem/22862
 */

import java.io.*;
import java.util.*;

public class Main {

    static long result = 0L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int sIndex = 0;
        int eIndex = -1;
        int count = 0;
        while (eIndex + 1 < N) {
            if (count < k) {
                if (arr[++eIndex] % 2 != 0) {
                    count++;
                }
            } else {
                if (arr[eIndex + 1] % 2 != 0) {
                    if (arr[sIndex] % 2 != 0) {
                        count--;
                    }
                    sIndex++;
                } else {
                    eIndex++;
                }
            }
            result = Math.max(result, (eIndex - sIndex + 1) - count);
        }
        System.out.println(result);
    }
}