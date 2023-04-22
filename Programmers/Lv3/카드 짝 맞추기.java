/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 카드 짝 맞추기 (Lv3)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/72415
 */

import java.util.*;

class Solution {

    static int[] orders;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    static List<Node> list = new ArrayList<>();

    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};

    public int solution(int[][] board, int r, int c) {
        setNodes(board);
        orders = new int[list.size()];
        visited = new boolean[list.size()];
        permutation(0, r, c, board);

        return min + list.size();
    }

    private static int bfs(Node start, Node end, int[][] board) {
        if (start.i == end.i && start.j == end.j) {
            return 0;
        }
        int[][] arr = new int[4][4];
        for (int i=0; i<4; i++) {
            Arrays.fill(arr[i], Integer.MAX_VALUE);
        }
        arr[start.i][start.j] = 0;

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(start.i, start.j));
        while (!q.isEmpty()) {
            Node node = q.remove();
            if (node.i == end.i && node.j == end.j) {
                return arr[end.i][end.j];
            }
            for (int k=0; k<4; k++) {
                int ii = node.i + di[k], jj = node.j + dj[k];
                if (isOutOfRange(ii, jj)) {
                    continue;
                }
                if (arr[ii][jj] <= arr[node.i][node.j] + 1) {
                    continue;
                }
                arr[ii][jj] = arr[node.i][node.j] + 1;
                q.add(new Node(ii, jj));
            }
            for (int k=0; k<4; k++) {
                int ii = node.i, jj = node.j;
                while (!isOutOfRange(ii + di[k], jj + dj[k])) {
                    if (board[ii + di[k]][jj + dj[k]] != 0) {
                        ii += di[k];
                        jj += dj[k];
                        break;
                    }
                    ii += di[k];
                    jj += dj[k];
                }
                if (arr[ii][jj] <= arr[node.i][node.j] + 1) {
                    continue;
                }
                arr[ii][jj] = arr[node.i][node.j] + 1;
                q.add(new Node(ii, jj));
            }
        }

        return arr[end.i][end.j];
    }

    private static int getResult(int r, int c, int[][] board) {
        int count = 0;
        int[][] arr = new int[4][4];
        for (int i=0; i<4; i++) {
            arr[i] = board[i].clone();
        }
        Node start = new Node(r, c);
        for (int idx : orders) {
            Node end = list.get(idx);
            count += bfs(start, end, arr);
            arr[end.i][end.j] = 0;
            start.i = end.i;
            start.j = end.j;
        }

        return count;
    }

    private static void permutation(int depth, int r, int c, int[][] board) {
        if (depth == list.size()) {
            min = Math.min(min, getResult(r, c, board));
            return;
        }
        for (int i=0; i<list.size(); i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            orders[depth] = i;
            if (i % 2 == 0) {
                visited[i + 1] = true;
                orders[depth + 1] = i + 1;
                permutation(depth + 2, r, c, board);
                visited[i + 1] = false;
            } else {
                visited[i - 1] = true;
                orders[depth + 1] = i - 1;
                permutation(depth + 2, r, c, board);
                visited[i - 1] = false;
            }
            visited[i] = false;
        }
    }

    private static void setNodes(int[][] board) {
        for (int i=0; i<4; i++) {
            for (int j=0; j<4; j++) {
                if (board[i][j] != 0) {
                    list.add(new Node(i, j, board[i][j]));
                }
            }
        }
        Collections.sort(list);
    }

    private static boolean isOutOfRange(int i, int j) {
        return i < 0 || i >= 4 || j < 0 || j >= 4;
    }
}

class Node implements Comparable<Node> {
    int i, j, num;

    public Node(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public Node(int i, int j, int num) {
        this.i = i;
        this.j = j;
        this.num = num;
    }

    @Override
    public int compareTo(Node n) {
        return this.num - n.num;
    }
}