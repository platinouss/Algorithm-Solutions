/**
 * 백준 13144번 (골드 4)
 * 문제 이름 : List of Unique Numbers
 * 알고리즘 분류 : 투 포인터
 * 링크 : https://www.acmicpc.net/problem/13144
 */

import java.io.*;
import java.util.*;

public class Main {

    static long count = 0L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int eIndex = 0;
        int[] visited = new int[100_001];
        for (int sIndex = 0; sIndex < N; sIndex++) {
            if (sIndex > 0 && visited[arr[sIndex - 1]] > 0) {
                visited[arr[sIndex - 1]]--;
            }
            while (eIndex < N && visited[arr[eIndex]] <= 0) {
                visited[arr[eIndex]]++;
                eIndex++;
            }
            count += (eIndex - sIndex);
        }

        System.out.println(count);
    }
}