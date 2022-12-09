import java.util.*;
import java.io.*;

class Main {

    static class Node {
        int i, j;

        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    static char[][] arr;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        arr = new char[N][N];
        for (int i=0; i<N; i++) {
            char[] c = br.readLine().toCharArray();
            for (int j=0; j<N; j++) {
                arr[i][j] = c[j];
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(getCount(N)).append(" ");
        sb.append(getSpecialCount(N));

        System.out.println(sb);
    }

    private static int getCount(int N) {
        int count = 0;
        Queue<Node> q = new LinkedList<>();
        boolean[][] check = new boolean[N][N];
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if(!check[i][j]) {
                    q.add(new Node(i, j));
                    check[i][j] = true;
                    while (!q.isEmpty()) {
                        Node n = q.remove();
                        for (int k=0; k<di.length; k++) {
                            int ii = n.i + di[k];
                            int jj = n.j + dj[k];
                            if (isOutOfRange(ii, jj, N) || check[ii][jj]) { continue; }
                            if (arr[ii][jj] != arr[i][j]) { continue; }
                            q.add(new Node(ii, jj));
                            check[ii][jj] = true;
                        }
                    }
                    count++;
                }
            }
        }

        return count;
    }

    private static int getSpecialCount(int N) {
        int count = 0;
        Queue<Node> q = new LinkedList<>();
        boolean[][] check = new boolean[N][N];
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if(!check[i][j]) {
                    q.add(new Node(i, j));
                    check[i][j] = true;
                    while (!q.isEmpty()) {
                        Node n = q.remove();
                        for (int k=0; k<di.length; k++) {
                            int ii = n.i + di[k];
                            int jj = n.j + dj[k];
                            if (isOutOfRange(ii, jj, N) || check[ii][jj]) { continue; }
                            if (arr[i][j] == 'B' && arr[ii][jj] != 'B') { continue; }
                            if (arr[i][j] == 'R' && arr[ii][jj] == 'B') { continue; }
                            if (arr[i][j] == 'G' && arr[ii][jj] == 'B') { continue; }
                            q.add(new Node(ii, jj));
                            check[ii][jj] = true;
                        }
                    }
                    count++;
                }
            }
        }

        return count;
    }

    private static boolean isOutOfRange(int i, int j, int N) {
        if (i < 0 || j < 0 || i >= N || j >= N) { return true; }
        return false;
    }
}