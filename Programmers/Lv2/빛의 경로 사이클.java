/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 빛의 경로 사이클 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/86052
 */

import java.util.*;

class Solution {

    static int N, M;
    static boolean[][][] visited;
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};
    static List<Integer> answer = new ArrayList<>();

    public int[] solution(String[] grid) {
        N = grid.length;
        M = grid[0].length();
        visited = new boolean[N][M][4];
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                for (int k=0; k<4; k++) {
                    if (!visited[i][j][k]) {
                        answer.add(start(i, j, k, grid));
                    }
                }
            }
        }
        return answer.stream().sorted().mapToInt(v -> v).toArray();
    }

    private static int start(int a, int b, int k, String[] grid) {
        int count = 0;
        while (!visited[a][b][k]) {
            visited[a][b][k] = true;
            if (grid[a].charAt(b) == 'L') {
                k = ((k - 1) + 4) % 4;
            }
            if (grid[a].charAt(b) == 'R') {
                k = ((k + 1) + 4) % 4;
            }
            a = (a + di[k] + N) % N;
            b = (b + dj[k] + M) % M;
            count++;
        }
        return count;
    }
}