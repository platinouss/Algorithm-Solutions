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
        for (int i=0; i<count; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        twoPointer(condition);
        System.out.println(result);
    }

    private static void twoPointer(int condition) {
        int sIndex = 0;
        int eIndex = 0;
        while (sIndex < arr.length-1 && eIndex < arr.length) {
            int d = arr[eIndex] - arr[sIndex];
            if (d >= condition) {
                result = Math.min(result, d);
                sIndex++;
            }
            else { eIndex++; }
        }
    }
}