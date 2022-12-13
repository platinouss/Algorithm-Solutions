import java.io.*;
import java.util.*;

class Main {

    static class Node {
        int i, j, count;

        public Node(int i, int j, int c) {
            this.i = i;
            this.j = j;
            this.count = c;
        }
    }

    static int[][] arr;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};
    static int[] da = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] db = {-1, 1, -2, 2, -2, 2, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) { arr[i][j] = -1; }
            }
        }

        System.out.println(bfs(N, M, K));
    }

    private static int bfs(int N, int M, int count) {
        if (N == 1 && M == 1) { return 0; }

        boolean[][][] visited = new boolean[N][M][count + 1];
        visited[0][0][0] = true;
        arr[0][0] = 1;

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 0));
        while (!q.isEmpty()) {
            Node n = q.remove();
            int value = arr[n.i][n.j];
            if (n.count < count) {
                for (int k=0; k<da.length; k++) {
                    int a = n.i + da[k];
                    int b = n.j + db[k];
                    if (a == N -1 && b == M - 1) { return value; }
                    if (a < 0 || a >= N || b < 0 || b >= M) { continue; }
                    if (visited[a][b][n.count + 1] || arr[a][b] == -1) { continue; }
                    q.add(new Node(a, b, n.count + 1));
                    arr[a][b] = value + 1;
                    visited[a][b][n.count + 1] = true;
                }
            }

            for (int k=0; k<di.length; k++) {
                int a = n.i + di[k];
                int b = n.j + dj[k];
                if (a == N -1 && b == M - 1) { return value; }
                if (a < 0 || a >= N || b < 0 || b >= M) { continue; }
                if (visited[a][b][n.count] || arr[a][b] == -1) { continue; }
                q.add(new Node(a, b, n.count));
                arr[a][b] = value + 1;
                visited[a][b][n.count] = true;
            }
        }
        return -1;
    }
}