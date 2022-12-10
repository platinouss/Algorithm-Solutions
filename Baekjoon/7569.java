import java.util.*;
import java.io.*;

class Main {

    static class Node {
        int i, j, k;

        public Node(int i, int j, int k) {
            this.i = i;
            this.j = j;
            this.k = k;
        }
    }

    static int result = Integer.MAX_VALUE;
    static int[][][] arr;
    static List<Node> list = new ArrayList<>();
    static int[][] dir = {{-1, 0, 0}, {1, 0, 0}, {0, -1, 0}, {0, 1, 0}, {0, 0, -1}, {0, 0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int j = Integer.parseInt(st.nextToken());
        int i = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        arr = new int[i][j][k];
        for (int c=0; c<k; c++) {
            for (int a=0; a<i; a++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int b=0; b<j; b++) {
                    arr[a][b][c] = Integer.parseInt(st.nextToken());
                    if (arr[a][b][c] == 1) { list.add(new Node(a, b, c)); }
                }
            }
        }

        bfs();

        if (!isSuccess(i, j, k)) { result = -1; }
        System.out.println(result);
    }

    private static void bfs() {
        Queue<Node> q = new LinkedList<>(list);

        int count = 0;
        while (!q.isEmpty()) {
            Node n = q.remove();
            for (int k=0; k<dir.length; k++) {
                int ii = n.i + dir[k][0];
                int jj = n.j + dir[k][1];
                int kk = n.k + dir[k][2];

                if (isOutOfRange(ii, jj, kk) || arr[ii][jj][kk] != 0) { continue; }
                arr[ii][jj][kk] = arr[n.i][n.j][n.k] + 1;
                q.add(new Node(ii, jj, kk));
            }
            count = arr[n.i][n.j][n.k] - 1;
        }

        result = count;
    }

    private static boolean isSuccess(int ii, int jj, int kk) {
        for (int k=0; k<kk; k++) {
            for (int i=0; i<ii; i++) {
                for (int j=0; j<jj; j++) {
                    if (arr[i][j][k] == 0) { return false; }
                }
            }
        }

        return true;
    }

    private static boolean isOutOfRange(int i, int j, int k) {
        return i < 0 || i >= arr.length || j < 0 || j >= arr[0].length ||
                k < 0 || k >= arr[0][0].length;
    }
}