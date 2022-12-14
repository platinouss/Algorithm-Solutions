import java.util.*;
import java.io.*;

class Main {

    static int count;
    static int length;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        count = Integer.parseInt(st.nextToken());
        length = Integer.parseInt(st.nextToken());

        arr = new int[count];
        visited = new boolean[count];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<count; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for (int i=0; i<count; i++) {
            visited[i] = true;
            select(1, String.valueOf(arr[i]));
            visited[i] = false;
        }

        System.out.println(sb);
    }

    private static void select(int c, String s) {
        if (c == length) { sb.append(s).append("\n"); return; }

        for (int i=0; i<count; i++) {
            if (visited[i]) { continue; }
            visited[i] = true;
            select(c+1, s + " " + arr[i]);
            visited[i] = false;
        }
    }
}