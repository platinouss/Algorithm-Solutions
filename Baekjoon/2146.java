import java.util.*;
import java.io.*;

class Main {

    static class Node {
        int i, j, group, count;

        public Node(int i, int j, int g, int c) {
            this.i = i;
            this.j = j;
            this.group = g;
            this.count = c;
        }
    }

    static int[][] arr;
    static int wall;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};
    static List<Node> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        StringTokenizer st;
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) { list.add(new Node(i, j, 0, 0)); }
            }
        }

        grouping(N);

        System.out.println(bfs(N));
    }

    private static void grouping(int N) {
        Queue<Node> q = new LinkedList<>();

        wall = 2;
        for (Node node : list) {
            if (arr[node.i][node.j] != 1) { continue; }
            arr[node.i][node.j] = wall;
            q.add(node);

            while (!q.isEmpty()) {
                Node n = q.remove();
                for (int k=0; k<di.length; k++) {
                    int ii = n.i + di[k];
                    int jj = n.j + dj[k];
                    if (isOutOfRange(ii, jj, N) || arr[ii][jj] == 0 || arr[ii][jj] == wall) { continue; }
                    arr[ii][jj] = wall;
                    q.add(new Node(ii, jj, 0, 0));
                }
            }
            wall++;
        }
    }

    private static int bfs(int N) {
        boolean[][][] visited = new boolean[N][N][wall];
        Queue<Node> q = new LinkedList<>();
        for (Node n : list) {
            q.add(new Node(n.i, n.j, arr[n.i][n.j], 0));
        }

        while (!q.isEmpty()) {
            Node n = q.remove();
            int groupId = n.group;
            for (int k=0; k<di.length; k++) {
                int ii = n.i + di[k];
                int jj = n.j + dj[k];
                if (isOutOfRange(ii, jj, N) || arr[ii][jj] == groupId || visited[ii][jj][groupId]) {
                    continue;
                }
                if (arr[ii][jj] != 0 && arr[ii][jj] != groupId) { return n.count; }

                visited[ii][jj][groupId] = true;
                q.add(new Node(ii, jj, groupId,n.count + 1));
            }
        }

        return -1;
    }

    private static boolean isOutOfRange(int i, int j, int N) {
        return i < 0 || j < 0 || i >= N || j >= N;
    }
}