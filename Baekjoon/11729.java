import java.util.*;
import java.io.*;

class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        sb.append((int)Math.pow(2, N) - 1 + "\n");

        hanoi(N, 1, 3);

        System.out.println(sb.toString());
    }

    public static void hanoi(int N, int start, int end) {
        if (N == 1) {
            sb.append(start + " " + end + "\n");
            return;
        }

        hanoi(N - 1, start, 6-start-end);
        sb.append(start + " " + end + "\n");
        hanoi(N - 1, 6-start-end, end);
    }
}