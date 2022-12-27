/**
 * 백준 20922번 (실버 1)
 * 문제 이름 : 겹치는 건 싫어
 * 알고리즘 분류 : 투 포인터
 * 링크 : https://www.acmicpc.net/problem/20922
 */

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int condition = Integer.parseInt(st.nextToken());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int count = 0;
        int sIndex = 0;
        int eIndex = 0;
        int[] counts = new int[100_001];
        while (eIndex < arr.length) {
            while (eIndex < arr.length && counts[arr[eIndex]] + 1 <= condition) {
                counts[arr[eIndex]]++;
                eIndex++;
            }
            count = Math.max(count, (eIndex - sIndex));
            counts[arr[sIndex]]--;
            sIndex++;
        }
        System.out.println(count);
    }
}