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
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        count = Integer.parseInt(st.nextToken());
        length = Integer.parseInt(st.nextToken());

        arr = new int[count];
        visited = new boolean[count];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<count; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int beforeIndex = -1;
        for (int i=0; i<count; i++) {
            if (beforeIndex != -1 && arr[i] == arr[beforeIndex]) { continue; }
            visited[i] = true;
            select(1, String.valueOf(arr[i]));
            visited[i] = false;
            beforeIndex = i;
        }

        System.out.println(sb);
    }

    private static void select(int cnt, String s) {
        if (cnt == length) {
            sb.append(s).append("\n");
            return;
        }

        int beforeIndex = -1;
        for (int i=0; i<count; i++) {
            if (visited[i] || (beforeIndex != -1 && arr[i] == arr[beforeIndex])) { continue; }
            visited[i] = true;
            select(cnt + 1, s + " " + arr[i]);
            visited[i] = false;
            beforeIndex = i;
        }
    }
}