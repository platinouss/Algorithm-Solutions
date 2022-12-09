import java.util.*;
import java.io.*;

class Main {

    static class Node {
        int i, j, count;

        public Node(int i, int j, int c) {
            this.i = i;
            this.j = j;
            this.count = c;
        }
    }

    static int MAX_VALUE;
    static int[] di = { -2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dj = { -1, 1, -2, 2, -2, 2, -1, 1};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int count = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<count; i++) {
            int N = Integer.parseInt(br.readLine());
            MAX_VALUE = N * N + 1;

            st = new StringTokenizer(br.readLine(), " ");
            Node startNode = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
            st = new StringTokenizer(br.readLine(), " ");
            Node endNode = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);

            sb.append(getCount(N, startNode, endNode)).append("\n");
        }

        System.out.print(sb);
    }

    private static int getCount(int N, Node startNode, Node endNode) {
        if (startNode.i == endNode.i && startNode.j == endNode.j) { return 0; }

        boolean[][] arr = new boolean[N][N];
        arr[startNode.i][startNode.j] = true;

        Queue<Node> q = new LinkedList<>();
        q.add(startNode);
        while(!q.isEmpty()) {
            Node n = q.remove();
            for (int k=0; k<di.length; k++) {
                int ii = n.i + di[k];
                int jj = n.j + dj[k];
                if (endNode.i == ii && endNode.j == jj) { return n.count + 1; }

                if (isOutOfRange(ii, jj, N) || arr[ii][jj]) { continue; }
                arr[ii][jj] = true;
                q.add(new Node(ii, jj, n.count +1));
            }
        }

        return -1;
    }

    private static boolean isOutOfRange(int i, int j, int N) {
        return i < 0 || j < 0 || i >= N || j >= N;
    }
}