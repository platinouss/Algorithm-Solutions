import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long size = Long.parseLong(st.nextToken());
        long ii = Long.parseLong(st.nextToken());
        long jj = Long.parseLong(st.nextToken());

        System.out.println(getResult(size, ii, jj));
    }

    public static long getResult(long size, long ii, long jj) {
        if (size == 0) { return 0; }

        long half = (long)Math.pow(2, size-1);
        if (ii < half && jj < half) { return getResult(size-1, ii, jj); }
        if (ii < half && jj >= half) { return (half*half) + getResult(size-1, ii, jj - half); }
        if (ii >= half && jj < half) { return 2*(half*half) + getResult(size-1, ii - half, jj); }
        return 3*(half*half) + getResult(size-1, ii - half, jj - half);
    }
}