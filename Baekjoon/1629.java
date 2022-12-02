import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long value = Long.parseLong(st.nextToken());
        long e = Long.parseLong(st.nextToken());
        long d = Long.parseLong(st.nextToken());

        System.out.println(cal(value, e, d) % d);
    }

    private static long cal(long value, long e, long d) {
        if (e == 0) { return 1; }
        if (e == 1) { return value; }

        long v = cal(value, e/2, d) % d;
        if (e % 2 == 1) { return ((v * v) % d) * value % d; }

        return v * v % d;
    }
}