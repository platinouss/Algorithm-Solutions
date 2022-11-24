import java.util.*;
import java.io.*;

class Main {
    static class Node {
        public int i;
        int j;

        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    static int[][] arr;
    static boolean[][] visited;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};
    static int count = 0;
    static int maxLength = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int ii = Integer.parseInt(st.nextToken());
        int jj = Integer.parseInt(st.nextToken());

        arr = new int[ii][jj];
        visited = new boolean[ii][jj];
        for (int i=0; i<ii; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<jj; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();
        System.out.println(count);
        System.out.println(maxLength);
    }

    public static void bfs() {
        Queue<Node> q = new LinkedList<>();
        for (int i=0; i<arr.length; i++) {
            for (int j=0; j<arr[0].length; j++) {
                if (arr[i][j] == 0 || visited[i][j]) {
                    visited[i][j] = true;
                    continue;
                }
                int length = 0;
                q.add(new Node(i, j));
                visited[i][j] = true;
                count++;
                while(!q.isEmpty()) {
                    length++;
                    Node n = q.remove();
                    for (int k=0; k<di.length; k++) {
                        int ii = n.i + di[k];
                        int jj = n.j + dj[k];
                        if (ii < 0 || jj < 0 || ii >= arr.length || jj >= arr[0].length) {
                            continue;
                        }
                        if (arr[ii][jj] == 1 && !visited[ii][jj]) {
                            visited[ii][jj] = true;
                            q.add(new Node(ii, jj));
                        }
                    }
                }
                maxLength = Math.max(maxLength, length);
            }
        }
    }
}