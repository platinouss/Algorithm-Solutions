import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        int[] arr = new int[count];
        for(int i=0; i<count; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int index = 0;
        int[] twoList = new int[count * (count-1)];
        for (int i=0; i<count; i++) {
            for (int j=i; j<count; j++) {
                twoList[index] = arr[i] + arr[j];
                index++;
            }
        }

        twoList = Arrays.stream(twoList).sorted().toArray();

        for (int i=count-1; i>0; i--) {
            for (int j=0; j<i; j++) {
                int value = arr[i] - arr[j];
                if (Arrays.binarySearch(twoList, value) > 0) {
                    System.out.println(arr[i]);
                    return;
                }
            }
        }
    }
}