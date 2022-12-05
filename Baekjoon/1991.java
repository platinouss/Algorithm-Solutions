import java.util.*;
import java.io.*;

class Main {

    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        arr = new int[26][3];
        for (int i=0; i<count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            char[] c = {st.nextToken().charAt(0), st.nextToken().charAt(0), st.nextToken().charAt(0)};
            int node = c[0] - 'A';

            if (c[1] == '.') { arr[node][1] = -1; }
            else { arr[node][1] = c[1] - 'A'; }

            if (c[2] == '.') { arr[node][2] = -1; }
            else { arr[node][2] = c[2] - 'A'; }
        }

        StringBuilder sb = new StringBuilder();
        preOrder(0, sb);
        sb.append("\n");
        inOrder(0, sb);
        sb.append("\n");
        postOrder(0, sb);

        System.out.println(sb.toString());
    }

    private static void preOrder(int value, StringBuilder sb) {
        if (value == -1) { return; }

        sb.append((char) ('A' + value));
        preOrder(arr[value][1], sb);
        preOrder(arr[value][2], sb);
    }

    private static void inOrder(int value, StringBuilder sb) {
        if (value == -1) { return; }

        inOrder(arr[value][1], sb);
        sb.append((char) ('A' + value));
        inOrder(arr[value][2], sb);
    }

    private static void postOrder(int value, StringBuilder sb) {
        if (value == -1) { return; }

        postOrder(arr[value][1], sb);
        postOrder(arr[value][2], sb);
        sb.append((char) ('A' + value));
    }
}