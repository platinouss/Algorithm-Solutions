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

    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};
    static List<Node> fires;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;
        int totalCount =  Integer.parseInt(br.readLine());
        for (int c=0; c<totalCount; c++) {
            st = new StringTokenizer(br.readLine(), " ");
            int jj = Integer.parseInt(st.nextToken());
            int ii = Integer.parseInt(st.nextToken());

            fires = new ArrayList<>();
            Node person = new Node(0, 0);
            char[][] arr = new char[ii][jj];
            for (int i=0; i<ii; i++) {
                char[] ch = br.readLine().toCharArray();
                for (int j=0; j<jj; j++) {
                    arr[i][j] = ch[j];
                    if (ch[j] == '*') { fires.add(new Node(i, j)); }
                    if (ch[j] == '@') { person = new Node(i, j); }
                }
            }

            int result = bfs(person, arr);
            if (result == -1) {
                sb.append("IMPOSSIBLE").append("\n");
                continue;
            }
            sb.append(result).append("\n");
        }

        System.out.print(sb);
    }

    private static int bfs(Node person, char[][] arr) {
        Queue<Node> fireQueue = new LinkedList<>(fires);
        Queue<Node> personQueue = new LinkedList<>();
        personQueue.add(person);

        boolean[][] visited = new boolean[arr.length][arr[0].length];
        visited[person.i][person.j] = true;

        int day = 0;
        while (!personQueue.isEmpty()) {
            day++;
            for (int count=0, max = fireQueue.size(); count < max; count++) {
                Node fire = fireQueue.remove();
                for (int k=0; k<di.length; k++) {
                    int a = fire.i + di[k];
                    int b = fire.j + dj[k];
                    if (isOutOfRange(a, b, arr) || arr[a][b] == '*' || arr[a][b] == '#') { continue; }
                    arr[a][b] = '*';
                    fireQueue.add(new Node(a, b));
                }
            }

            for (int count=0, max = personQueue.size(); count < max; count++) {
                Node p = personQueue.remove();
                for (int k=0; k<di.length; k++) {
                    int a = p.i + di[k];
                    int b = p.j + dj[k];
                    if (isOutOfRange(a, b, arr)) { return day; }
                    if (arr[a][b] == '*' || visited[a][b] || arr[a][b] == '#') { continue; }
                    visited[a][b] = true;
                    personQueue.add(new Node(a, b));
                }
            }
        }

        return -1;
    }

    private static boolean isOutOfRange(int i, int j, char[][] arr) {
        return i < 0 || j < 0 || i >= arr.length || j >= arr[0].length;
    }
}