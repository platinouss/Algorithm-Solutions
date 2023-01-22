/**
 * 백준 12851번 (골드 4)
 * 문제 이름 : 숨바꼭질 2
 * 알고리즘 분류 : 그래프, BFS
 * 링크 : https://www.acmicpc.net/problem/12851
 */

import java.util.*;
import java.io.*;

public class Main {

    static int[] arr = new int[150_001];

    static int sIndex;
    static int eIndex;
    static int totalCount = 0;
    static int minTime = Integer.MAX_VALUE;
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        sIndex = Integer.parseInt(st.nextToken());
        eIndex = Integer.parseInt(st.nextToken());

        if (sIndex == eIndex) {
            System.out.println(0);
            System.out.println(1);
            return;
        }

        arr[sIndex] = 1;
        bfs();

        System.out.println(minTime - 1);
        System.out.println(totalCount);
    }

    private static void bfs() {
        q.add(sIndex);
        while (!q.isEmpty()) {
            int idx = q.remove();
            if (arr[idx] > minTime) {
                break;
            }
            move1(idx);
            move2(idx);
            move3(idx);
        }
    }

    private static void move1(int idx) {
        if (idx + 1 >= arr.length) {
            return;
        }
        if (arr[idx + 1] != 0 && arr[idx] + 1 > arr[idx + 1]) {
            return;
        }
        arr[idx + 1] = arr[idx] + 1;
        if (idx + 1 == eIndex) {
            if (minTime == Integer.MAX_VALUE) {
                minTime = arr[idx + 1];
            }
            totalCount++;
        }
        q.add(idx + 1);
    }

    private static void move2(int idx) {
        if (idx - 1 < 0) {
            return;
        }
        if (arr[idx - 1] != 0 && arr[idx] + 1 > arr[idx - 1]) {
            return;
        }
        arr[idx - 1] = arr[idx] + 1;
        if (idx - 1 == eIndex) {
            if (minTime == Integer.MAX_VALUE) {
                minTime = arr[idx - 1];
            }
            totalCount++;
        }
        q.add(idx - 1);
    }

    private static void move3(int idx) {
        if (idx * 2 >= arr.length) {
            return;
        }
        if (arr[idx * 2] != 0 && arr[idx] + 1 > arr[idx * 2]) {
            return;
        }
        arr[idx * 2] = arr[idx] + 1;
        if (idx * 2 == eIndex) {
            if (minTime == Integer.MAX_VALUE) {
                minTime = arr[idx * 2];
            }
            totalCount++;
        }
        q.add(idx * 2);
    }
}
