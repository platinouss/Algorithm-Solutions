import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int index = Integer.parseInt(br.readLine());

        int sIndex = 1;
        int eIndex = index;
        while (sIndex < eIndex) {
            int count = 0;
            int mid = (sIndex + eIndex) / 2;
            for (int i=1; i<=N; i++) {
                count += Math.min(mid / i, N);
            }

            if (count < index) {
                sIndex = mid + 1;
            } else {
                eIndex = mid;
            }
        }

        System.out.println(sIndex);
    }
}