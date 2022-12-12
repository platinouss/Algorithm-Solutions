import java.util.*;
import java.io.*;

class Main {

    static class Node {
        int index, count;

        public Node(int i, int c) {
            this.index = i;
            this.count = c;
        }
    }

    static final int MAX_VALUE = 100_000;
    static boolean[] visited = new boolean[MAX_VALUE + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " " );

        int sIndex = Integer.parseInt(st.nextToken());
        int eIndex = Integer.parseInt(st.nextToken());

        System.out.println(bfs(sIndex, eIndex));
    }

    private static int bfs(int sIndex, int eIndex) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(sIndex, 0));
        visited[sIndex] = true;

        while (!q.isEmpty()) {
            Node n = q.remove();
            if (n.index == eIndex) { return n.count; }

            int index = n.index * 2;
            if (0 <= index && index < visited.length && !visited[index]) {
                q.add(new Node(index, n.count));
                visited[index] = true;
            }
            index = n.index - 1;
            if (0 <= index && index < visited.length && !visited[index]) {
                q.add(new Node(index, n.count + 1));
                visited[index] = true;
            }
            index = n.index + 1;
            if (0 <= index && index < visited.length && !visited[index]) {
                q.add(new Node(index, n.count + 1));
                visited[index] = true;
            }
        }
        return -1;
    }
}