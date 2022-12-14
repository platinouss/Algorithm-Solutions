import java.util.*;
import java.io.*;

class Main {

    static int[] power;
    static int[] hp;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        power = new int[count];

        hp = new int[count];
        for (int i=0; i<count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            hp[i] = Integer.parseInt(st.nextToken());
            power[i] = Integer.parseInt(st.nextToken());
        }

        start(0, 0);

        System.out.println(result);
    }

    private static void start(int index, int count) {
        if (index >= hp.length) {
            result = Math.max(result, count);
            return;
        }

        if (hp[index] <= 0 || count == hp.length - 1) { start(index + 1, count); return; }

        for (int i=0; i<hp.length; i++) {
            if (i == index || hp[i] <= 0) { continue; }

            int tmp = 0;
            hp[i] -= power[index];
            if (hp[i] <= 0) { tmp++; }
            hp[index] -= power[i];
            if (hp[index] <= 0) { tmp++; }

            start(index + 1, count + tmp);

            hp[i] += power[index];
            hp[index] += power[i];
        }
    }
}