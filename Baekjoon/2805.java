import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = Integer.parseInt(st.nextToken());
        long condition = Integer.parseInt(st.nextToken());

        long[] arr = new long[count];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<count; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        long sIndex = 0;
        long eIndex = 1_000_000_000;

        while (sIndex < eIndex) {
            long value = 0;
            long mid = (sIndex + eIndex + 1) / 2;
            for (int i=0; i<arr.length; i++) {
                if (arr[i] > mid) { value += arr[i] - mid; }
            }
            if (condition > value) {
                eIndex = mid - 1;
            } else {
                sIndex = mid;
            }
        }

        System.out.println(sIndex);
    }
}