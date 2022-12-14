import java.util.*;
import java.io.*;

class Main {

    static int length;
    static int totalCount;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        length = Integer.parseInt(st.nextToken());
        totalCount = Integer.parseInt(st.nextToken());
        visited = new boolean[length];

        for (int i=1; i<=length; i++) {
            select(i, 1, String.valueOf(i));
        }

        System.out.print(sb);
    }

    private static void select(int index, int count, String s) {
        if (count == totalCount) { sb.append(s).append("\n"); return; }

        for (int i=index; i<=length; i++) {
            select(i, count+1, s + " " + i);
        }
    }
}