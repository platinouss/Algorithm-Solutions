/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 무인도 여행 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/154540
 */

import java.util.*;

class Solution {

    static int N;
    static int M;
    static int[][] arr;
    static boolean[][] visited;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};
    static List<Integer> list = new ArrayList<>();

    public int[] solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        arr = new int[N][M];
        visited = new boolean[N][M];
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (maps[i].charAt(j) == 'X') {
                    arr[i][j] = -1;
                    continue;
                }
                arr[i][j] = maps[i].charAt(j) - '0';
            }
        }
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (!visited[i][j] && arr[i][j] != -1) {
                    bfs(i, j);
                }
            }
        }
        if (list.size() == 0) {
            return new int[] {-1};
        }

        int[] answer = new int[list.size()];
        for (int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }

    private static void bfs(int i, int j) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(i, j));

        int count = arr[i][j];
        visited[i][j] = true;
        while (!q.isEmpty()) {
            Node node = q.remove();
            for (int k=0; k<4; k++) {
                int ii = node.i + di[k];
                int jj = node.j + dj[k];
                if (isOutOfRange(ii, jj) || arr[ii][jj] == -1) {
                    continue;
                }
                if (visited[ii][jj]) {
                    continue;
                }
                count += arr[ii][jj];
                visited[ii][jj] = true;
                q.add(new Node(ii, jj));
            }
        }
        list.add(count);
    }

    private static boolean isOutOfRange(int i, int j) {
        return i < 0 || j < 0 || i >= N || j >= M;
    }
}

class Node {
    int i, j;

    public Node(int i, int j) {
        this.i = i;
        this.j = j;
    }
}