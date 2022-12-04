import java.util.*;
import java.io.*;

class Main {

    static int[] arr;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = Integer.parseInt(st.nextToken());
        int condition = Integer.parseInt(st.nextToken());

        arr = new int[count];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<count; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        twoPointer(condition);

        if (result == Integer.MAX_VALUE) { result = 0; }
        System.out.println(result);
    }

    private static void twoPointer(int condition) {
        int sIndex = 0;
        int eIndex = 0;
        int sum = arr[0];

        while (sIndex < arr.length && eIndex < arr.length) {
            if (sum >= condition) {
                result = Math.min(result, eIndex - sIndex + 1);
                sum -= arr[sIndex];
                sIndex++;
                continue;
            }
            eIndex++;
            if (eIndex >= arr.length) { continue; }
            sum += arr[eIndex];
        }
    }
}