/**
 * [Baekjoon] 1931. 회의실 배정
 * https://www.acmicpc.net/problem/1931
 *
 * 접근 방식
 * 1) 주어진 회의 상세 내역을 끝나는 시간을 기점으로 오름차순 정렬한다.
 * 2) 해당 회의 내역을 순회할 때, 회의 종료 시각이 회의 시작 시간과 같거나 작을 때 카운트 해준다.
 * 3) 카운트 수를 반환한다.
 */

import java.util.*;
import java.io.*;

class Main {

    static int N;
    static int[][] arr;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];
        int index = 0;
        while (index < N) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr[index][0] = Integer.parseInt(st.nextToken());
            arr[index][1] = Integer.parseInt(st.nextToken());
            index++;
        }
        Arrays.sort(arr, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });
    }

    public static void main (String[] args) throws IOException {
        input();
        int count = 0, end = 0;
        for (int[] range : arr) {
            if (range[0] >= end) {
                end = range[1];
                count++;
            }
        }
        System.out.println(count);
    }
}
