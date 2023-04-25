/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 퍼즐 조각 채우기 (Lv3)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/84021
 */

import java.util.*;

class Solution {

    static int N, M;
    static boolean[] finishBlock;
    static boolean[][] visited;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};

    static List<List<int[]>> emptyList = new ArrayList<>();
    static List<List<int[]>> blockList = new ArrayList<>();

    public int solution(int[][] game_board, int[][] table) {
        N = game_board.length;
        M = game_board[0].length;
        visited = new boolean[N][M];
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (game_board[i][j] == 0 && !visited[i][j]) {
                    visited[i][j] = true;
                    bfs(i, j, 0, game_board, emptyList);
                }
            }
        }
        visited = new boolean[N][M];
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (table[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;
                    bfs(i, j, 1, table, blockList);
                }
            }
        }
        finishBlock = new boolean[blockList.size()];
        return getResult();
    }

    private static int getResult() {
        int count = 0;
        for (int i=0; i<emptyList.size(); i++) {
            List<int[]> emptyBlocks = emptyList.get(i);
            for (int j=0; j<blockList.size(); j++) {
                List<int[]> blocks = blockList.get(j);
                if (isSame(emptyBlocks, blocks) && !finishBlock[j]) {
                    count += emptyBlocks.size();
                    finishBlock[j] = true;
                    break;
                }
            }
        }
        return count;
    }

    private static boolean isSame(List<int[]> emptyBlocks, List<int[]> blocks) {
        if (emptyBlocks.size() != blocks.size()) {
            return false;
        }

        Collections.sort(emptyBlocks, (o1, o2) -> {
            if (o1[0] == o2[0]) { return o1[1] - o2[1]; }
            return o1[0] - o2[0];
        });

        boolean check = false;
        for (int k=0; k<4; k++) {
            Collections.sort(blocks, (o1, o2) -> {
                if (o1[0] == o2[0]) { return o1[1] - o2[1]; }
                return o1[0] - o2[0];
            });

            int baseI = blocks.get(0)[0];
            int baseJ = blocks.get(0)[1];
            for (int i=0; i<blocks.size(); i++) {
                blocks.get(i)[0] -= baseI;
                blocks.get(i)[1] -= baseJ;
            }

            boolean isFinish = true;
            for (int i=0; i<blocks.size(); i++) {
                int[] empty = emptyBlocks.get(i);
                int[] block = blocks.get(i);
                if (empty[0] != block[0] || empty[1] != block[1]) {
                    isFinish = false;
                    break;
                }
            }

            if (!isFinish) {
                for (int i=0; i<blocks.size(); i++) {
                    int tmp = blocks.get(i)[0];
                    blocks.get(i)[0] = blocks.get(i)[1];
                    blocks.get(i)[1] = -tmp;
                }
            } else {
                check = true;
                break;
            }
        }
        return check;
    }

    private static void bfs(int a, int b, int value, int[][] arr, List<List<int[]>> list) {
        List<int[]> tmpList = new ArrayList<>();
        visited[a][b] = true;
        tmpList.add(new int[]{0, 0});

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{a, b});
        while (!q.isEmpty()) {
            int[] tmp = q.remove();
            for (int k=0; k<4; k++) {
                int ii = tmp[0] + di[k];
                int jj = tmp[1] + dj[k];
                if (isOutOfRange(ii, jj) || visited[ii][jj]) {
                    continue;
                }
                if (arr[ii][jj] != value) {
                    continue;
                }
                visited[ii][jj] = true;
                q.add(new int[]{ii, jj});
                tmpList.add(new int[]{ii - a, jj - b});
            }
        }
        list.add(tmpList);
    }

    private static boolean isOutOfRange(int i, int j) {
        return i < 0 || i >= N || j < 0 || j >= M;
    }
}