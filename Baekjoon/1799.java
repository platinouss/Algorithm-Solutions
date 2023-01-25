/**
 * 백준 1799번 (골드 1)
 * 문제 이름 : 비숍
 * 알고리즘 분류 : 백트래킹
 * 링크 : https://www.acmicpc.net/problem/1799
 */

import java.util.*;
import java.io.*;

public class Main {

    static class Node {
        int i, j;

        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    static int N;
    static int[][] arr;
    static List<Node>[] lists;
    static int blackMaxCount = 0;
    static int whiteMaxCount = 0;
    static int[] di = {-1, -1};
    static int[] dj = {-1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        lists = new ArrayList[2];
        for (int i=0; i<2; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    if (isBlack(i, j)) {
                        lists[0].add(new Node(i, j));
                    } else {
                        lists[1].add(new Node(i, j));
                    }
                }
            }
        }

        getResult(0, 0, 0);
        getResult(0, 0, 1);

        System.out.println(blackMaxCount + whiteMaxCount);
    }

    private static void getResult(int index, int count, int color) {
        for (int i=index; i<lists[color].size(); i++) {
            Node node = lists[color].get(i);
            if (isValid(node.i, node.j)) {
                arr[node.i][node.j] = 2;
                getResult(i + 1, count + 1, color);
                arr[node.i][node.j] = 1;
            }
        }

        if (color == 0) {
            blackMaxCount = Math.max(blackMaxCount, count);
        } else if (color == 1) {
            whiteMaxCount = Math.max(whiteMaxCount, count);
        }
    }

    private static boolean isValid(int i, int j) {
        for (int k=0; k<di.length; k++) {
            for (int a=1; a<=i; a++) {
                int ii = i + di[k] * a;
                int jj = j + dj[k] * a;
                if (isOutOfRange(ii, jj)) {
                    continue;
                }
                if (arr[ii][jj] == 2) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isOutOfRange(int i, int j) {
        return i < 0 || j < 0 || i >= N || j >= N;
    }

    private static boolean isBlack(int ii, int jj) {
        if (ii % 2 == 0 && jj % 2 == 0) {
            return true;
        }
        if (ii % 2 == 1 && jj % 2 == 1) {
            return true;
        }
        return false;
    }
}