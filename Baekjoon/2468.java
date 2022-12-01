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

    static boolean[][] check;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};
    static List<List<Node>> list = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i=0; i<=100; i++) {
            list.add(new ArrayList<>());
        }

        check = new boolean[N][N];

        int maxHeight = 0;
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                int value = Integer.parseInt(st.nextToken());

                list.get(value).add(new Node(i, j));
                maxHeight = Math.max(maxHeight, value);
            }
        }

        int result = 1;
        for (int i=1; i<=maxHeight; i++) {
            for (Node n : list.get(i)) {
                check[n.i][n.j] = true;
            }
            result = Math.max(result, bfs(N));
        }

        System.out.println(result);
    }

    private static int bfs(int N) {
        boolean[][] tmp = new boolean[N][N];
        for (int i=0; i<N; i++) {
            System.arraycopy(check[i], 0, tmp[i], 0, N);
        }

        int count = 0;
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (!tmp[i][j]) {
                    Queue<Node> q = new LinkedList<>();
                    q.add(new Node(i, j));
                    tmp[i][j] = true;
                    while (!q.isEmpty()) {
                        Node n = q.remove();
                        for (int k=0; k<di.length; k++) {
                            int ii = n.i + di[k];
                            int jj = n.j + dj[k];
                            if (isOutOfRange(ii, jj)) { continue; }
                            if (!tmp[ii][jj]) {
                                q.add(new Node(ii, jj));
                                tmp[ii][jj] = true;
                            }
                        }
                    }
                    count++;
                }
            }
        }

        return count;
    }

    private static boolean isOutOfRange(int i, int j) {
        if (i < 0 || j < 0 || i >= check.length || j >= check[0].length) {
            return true;
        }
        return false;
    }
}