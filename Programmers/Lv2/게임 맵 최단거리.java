/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 게임 맵 최단거리 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/1844
 */

import java.util.*;

class Solution {

    static int[][] arr;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};

    public int solution(int[][] maps) {
        int N = maps.length;
        int M = maps[0].length;
        arr = new int[N][M];

        return bfs(maps, N, M);
    }

    private static int bfs(int[][] maps, int N, int M) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0));
        arr[0][0] = 1;
        while (!q.isEmpty()) {
            Node node = q.remove();
            if (node.i == N-1 && node.j == M-1) {
                return arr[node.i][node.j];
            }
            for (int k=0; k<4; k++) {
                int ii = node.i + di[k];
                int jj = node.j + dj[k];
                if (isOutOfRange(ii, jj) || maps[ii][jj] == 0) {
                    continue;
                }
                if (arr[ii][jj] != 0) {
                    continue;
                }
                arr[ii][jj] = arr[node.i][node.j] + 1;
                q.add(new Node(ii, jj));
            }
        }
        return -1;
    }

    private static boolean isOutOfRange(int i, int j) {
        return i < 0 || i >= arr.length || j < 0 || j >= arr[0].length;
    }
}

class Node {
    int i, j;

    public Node(int i, int j) {
        this.i = i;
        this.j = j;
    }
}