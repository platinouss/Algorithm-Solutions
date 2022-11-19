import java.io.*;
import java.util.*;

class Main {
    static int[][] arr;
    static int safeCount = 0;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int ii = Integer.parseInt(st.nextToken());
        int jj = Integer.parseInt(st.nextToken());

        arr = new int[ii][jj];
        for (int i=0; i<ii; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<jj; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);

        System.out.println(safeCount);
    }

    private static void dfs(int wallCount) {
        if (wallCount == 3) {
            bfs();
            return;
        }

        for (int i=0; i<arr.length; i++) {
            for (int j=0; j<arr[0].length; j++) {
                if (arr[i][j] == 0) {
                    arr[i][j] = 1;
                    dfs(wallCount + 1);
                    arr[i][j] = 0;
                }
            }
        }
    }

    private static void bfs() {
        int[][] tmp = new int[arr.length][arr[0].length];
        for (int i=0; i<arr.length; i++) {
            tmp[i] = arr[i].clone();
        }

        Queue<Node> q = new LinkedList<>();
        for (int i=0; i<tmp.length; i++) {
            for (int j=0; j<tmp[0].length; j++) {
                if (tmp[i][j] == 2) {
                    q.add(new Node(i, j));
                }
            }
        }

        while (!q.isEmpty()) {
            Node n = q.remove();
            for (int k=0; k<di.length; k++) {
                int ii = n.i + di[k];
                int jj = n.j + dj[k];

                if (ii < 0 || arr.length <= ii || jj < 0 || arr[0].length <= jj) {
                    continue;
                }

                if (tmp[ii][jj] == 0) {
                    tmp[ii][jj] = 2;
                    q.add(new Node(ii, jj));
                }
            }
        }

        getSafeGround(tmp);
    }

    private static void getSafeGround(int[][] tmp) {
        int count = 0;

        for (int i=0; i<tmp.length; i++) {
            for (int j=0; j<tmp[0].length; j++) {
                if (tmp[i][j] == 0) {
                    count++;
                }
            }
        }

        safeCount = Math.max(safeCount, count);
    }

    static class Node {
        public int i;
        public int j;

        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}