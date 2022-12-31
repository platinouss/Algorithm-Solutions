/**
 * 백준 12738번 (골드 2)
 * 문제 이름 : 가장 긴 증가하는 부분 수열 3
 * 알고리즘 분류 : 이분 탐색
 * 링크 : https://www.acmicpc.net/problem/12738
 */

import java.io.*;
import java.util.*;

public class Main {

    static int[] arr;
    static int[] tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int tmpLength = 0;
        tmp = new int[N];
        tmp[0] = arr[0];
        tmpLength++;

        for (int i=1; i<N; i++) {
            int value = arr[i];
            if (tmp[tmpLength - 1] < value) {
                tmp[tmpLength] = value;
                tmpLength++;
            } else {
                int index = getIndex(value, tmpLength - 1);
                tmp[index] = value;
            }
        }
        System.out.println(tmpLength);
    }

    private static int getIndex(int value, int eIndex) {
        int sIndex = 0;
        while (sIndex < eIndex) {
            int mid = (sIndex + eIndex) / 2;
            if (tmp[mid] >= value) {
                eIndex = mid;
            } else {
                sIndex = mid + 1;
            }
        }
        return sIndex;
    }
}