import java.util.*;
import java.io.*;

class Main {
    static class Node {
        int i;
        int j;

        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    static int[][] fireArr;
    static int[][] personArr;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ii = Integer.parseInt(st.nextToken());
        int jj = Integer.parseInt(st.nextToken());
        fireArr = new int[ii][jj];
        personArr = new int[ii][jj];

        Node startNode = new Node(0, 0);
        List<Node> fireNodes = new ArrayList<>();
        for (int i=0; i<ii; i++) {
            char[] condition = br.readLine().toCharArray();
            for (int j=0; j<jj; j++) {
                if (condition[j] == '#') {
                    fireArr[i][j] = -1;
                    personArr[i][j] = -1;
                }
                if (condition[j] == 'J') {
                    personArr[i][j] = 1;
                    startNode = new Node(i, j);
                }
                if (condition[j] == 'F') {
                    fireNodes.add(new Node(i, j));
                }
            }
        }

        fireBFS(fireNodes);

        int result = personBFS(startNode);
        if (result == -1) {
            System.out.println("IMPOSSIBLE");
            return;
        }
        System.out.println(result);
    }

    public static void fireBFS(List<Node> fireNodes) {
        Queue<Node> q = new LinkedList<>();
        for (Node fireNode : fireNodes) {
            q.add(fireNode);
            fireArr[fireNode.i][fireNode.j] = 1;
        }
        while (!q.isEmpty()) {
            Node n = q.remove();
            for (int k=0; k<di.length; k++) {
                int ii = n.i + di[k];
                int jj = n.j + dj[k];
                if (isOutOfIndex(ii, jj) || fireArr[ii][jj] != 0) { continue; }
                q.add(new Node(ii, jj));
                fireArr[ii][jj] = fireArr[n.i][n.j] + 1;
            }
        }
    }

    public static int personBFS(Node personNode) {
        Queue<Node> q = new LinkedList<>();
        q.add(personNode);
        personArr[personNode.i][personNode.j] = 1;
        while (!q.isEmpty()) {
            Node n = q.remove();
            int value = personArr[n.i][n.j];
            for (int k=0; k<di.length; k++) {
                int ii = n.i + di[k];
                int jj = n.j + dj[k];
                if (isOutOfIndex(ii, jj)) { return value; }

                if ((fireArr[ii][jj] != 0 && fireArr[ii][jj] <= value + 1) || personArr[ii][jj] != 0) { continue; }
                q.add(new Node(ii, jj));
                personArr[ii][jj] = value + 1;
            }
        }

        return -1;
    }

    public static boolean isOutOfIndex(int ii, int jj) {
        if (ii < 0 || jj < 0 || ii >= fireArr.length || jj >= fireArr[0].length) {
            return true;
        }
        return false;
    }
}