import java.util.*;
import java.io.*;

class Main {
    static int[] result;
    static int length, count;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        count = Integer.parseInt(st.nextToken());
        length = Integer.parseInt(st.nextToken());
        result = new int[length];

        dfs(1, 0);

        bw.flush();
        bw.close();
    }

    public static void dfs(int index, int depth) throws IOException {
        if (depth == length) {
            for (int value : result) {
                bw.write(value + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i=index; i<=count; i++) {
            result[depth] = i;
            dfs(i+1, depth+1);
        }
    }
}