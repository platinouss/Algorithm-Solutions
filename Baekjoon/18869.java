/**
 * 백준 18869번 (골드 5)
 * 문제 이름 : 멀티버스 Ⅱ
 * 알고리즘 분류 : 값 / 좌표 압축, 정렬
 * 링크 : https://www.acmicpc.net/problem/18869
 */

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int universeCount = Integer.parseInt(st.nextToken());
        int planetCount = Integer.parseInt(st.nextToken());

        int[][] arr = new int[universeCount][planetCount];
        for (int i=0; i<universeCount; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }
        for (int i=0; i<universeCount; i++) {
            compression(arr[i]);
        }
        int count = 0;
        for (int i=0; i<universeCount-1; i++) {
            for (int j=i+1; j<universeCount; j++) {
                if (arr[i].length == arr[j].length) {
                    boolean check = true;
                    for (int k=0; k<arr[i].length; k++) {
                        if (arr[i][k] != arr[j][k]) {
                            check = false;
                            break;
                        }
                    }
                    if (check) {
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }

    private static void compression(int[] arr) {
        int[] tmp = Arrays.copyOf(arr, arr.length);
        tmp = Arrays.stream(tmp).distinct().sorted().toArray();

        int N = arr.length;
        for (int i=0; i<N; i++) {
            int v = lowerBound(tmp, arr[i]);
            arr[i] = v;
        }
    }

    private static int lowerBound(int[] tmp, int value) {
        int sIndex = 0;
        int eIndex = tmp.length - 1;
        while (sIndex < eIndex) {
            int mid = (sIndex + eIndex) / 2;
            if (tmp[mid] < value) {
                sIndex = mid + 1;
            }
            if (tmp[mid] >= value) {
                eIndex = mid;
            }
        }

        return sIndex;
    }
}