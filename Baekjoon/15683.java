import java.util.*;
import java.io.*;

class Main {
    static class Node {
        int i;
        int j;

        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    static int[][] arr;
    static int[][] result;
    static int[] di = {0, -1, 0, 1};
    static int[] dj = {-1, 0, 1, 0};
    static List<Node> cctvs = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ii = Integer.parseInt(st.nextToken());
        int jj = Integer.parseInt(st.nextToken());

        arr = new int[ii][jj];
        result = new int[ii][jj];
        for (int i=0; i<ii; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<jj; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] != 0 && arr[i][j] != 6) { cctvs.add(new Node(i, j)); }
            }
        }

        System.out.println(getMaxTotalCount());
    }

    public static int getMaxTotalCount() {
        if(cctvs.size() == 0) {
            int zeroCount = 0;
            for (int i=0; i<arr.length; i++) {
                for (int j=0; j<arr[0].length; j++) {
                    if (arr[i][j] == 0) { zeroCount++; }
                }
            }
            return zeroCount;
        }

        int minTotalCount = 100;
        for (int k=0; k<(1<<(2*cctvs.size())); k++) {
            for (int i=0; i<arr.length; i++) {
                System.arraycopy(arr[i], 0, result[i], 0, arr[0].length);
            }
            int[] b = new int[cctvs.size()];
            String bi = Integer.toString(k, 4);
            for (int i=bi.length()-1; i>=0; i--) {
                b[i] = bi.charAt(i) - '0';
            }
            for (int d=0; d<cctvs.size(); d++) {
                int dir = b[d];
                setCctvAllSight(d, dir);
            }

            int sum = 0;
            for (int ii=0; ii<result.length; ii++) {
                for (int jj=0; jj<result[0].length; jj++) {
                    if (result[ii][jj] == 0) { sum++; }
                }
            }
            minTotalCount = Math.min(sum, minTotalCount);
        }

        return minTotalCount;
    }

    public static void setCctvAllSight(int d, int dir) {
        Node cctv = cctvs.get(d);
        int i = cctv.i;
        int j = cctv.j;

        if (arr[i][j] == 1) {
            setCctvSight(i, j, dir);
        }
        if (arr[i][j] == 2) {
            setCctvSight(i, j, dir);
            setCctvSight(i, j, dir+2);
        }
        if (arr[i][j] == 3) {
            setCctvSight(i, j, dir);
            setCctvSight(i, j, dir+1);
        }
        if (arr[i][j] == 4) {
            setCctvSight(i, j, dir);
            setCctvSight(i, j, dir+1);
            setCctvSight(i, j, dir+2);
        }
        if (arr[i][j] == 5) {
            setCctvSight(i, j, dir);
            setCctvSight(i, j, dir+1);
            setCctvSight(i, j, dir+2);
            setCctvSight(i, j, dir+3);
        }
    }

    public static void setCctvSight(int i, int j, int d) {
        d %= 4;
        while (true) {
            i += di[d];
            j += dj[d];

            if (isOutOfRange(i, j) || result[i][j] == 6) { return; }
            if (result[i][j] != 0) { continue; }
            result[i][j] = 7;
        }
    }

    public static boolean isOutOfRange(int i, int j) {
        if (i < 0 || j < 0 || i >= arr.length || j >= arr[0].length) {
            return true;
        }
        return false;
    }
}