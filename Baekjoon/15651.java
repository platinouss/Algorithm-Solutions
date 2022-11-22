import java.util.*;
import java.io.*;

class Main {
    static int count;
    static int length;
    static int[] arr;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        count = Integer.parseInt(st.nextToken());
        length = Integer.parseInt(st.nextToken());

        arr = new int[length];
        dfs(0);

        bw.flush();
        bw.close();
    }

    public static void dfs(int depth) throws IOException {
        if (depth == length) {
            for (int value : arr) {
                bw.write(value + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i=1; i<=count; i++) {
            arr[depth] = i;
            dfs(depth + 1);
        }
    }
}