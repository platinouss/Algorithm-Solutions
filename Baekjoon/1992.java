import java.io.*;

class Main {

    static int[][] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        for (int i=0; i<N; i++) {
            char[] ch = br.readLine().toCharArray();
            for (int j=0; j<N; j++) {
                arr[i][j] = ch[j] - '0';
            }
        }

        compress(0, 0, N);
        System.out.println(sb);
    }

    private static void compress(int i, int j, int N) {
        if (isCompress(i, j, N)) {
            sb.append(arr[i][j]);
            return;
        }

        int half = N / 2;

        sb.append("(");
        compress(i, j, half);
        compress(i, j + half, half);
        compress(i + half, j, half);
        compress(i + half, j + half, half);
        sb.append(")");
    }

    private static boolean isCompress(int a, int b, int N) {
        int value = arr[a][b];

        for (int i=a; i<a+N; i++) {
            for (int j=b; j<b+N; j++) {
                if (value != arr[i][j]) { return false; }
            }
        }

        return true;
    }
}