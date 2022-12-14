import java.io.*;

class Main {

    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new char[N][N];

        draw(0, 0, N, false);

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void draw(int a, int b, int N, boolean check) {
        if (check) {
            for (int i=a; i<a+N; i++) {
                for (int j=b; j<b+N; j++) {
                    arr[i][j] = ' ';
                }
            }
            return;
        }

        if (N == 1) { arr[a][b] = '*'; return; }

        int d = N / 3;
        int count = 0;
        for (int i=a; i<a+N; i+=d) {
            for (int j=b; j<b+N; j+=d) {
                count++;
                if (count == 5) { draw(i, j, d, true); continue; }
                draw(i, j, d, false);
            }
        }
    }
}