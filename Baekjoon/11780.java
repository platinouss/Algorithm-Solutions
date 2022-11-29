import java.util.*;
import java.io.*;

class Main {

    static int MAX_VALUE = 100_001;
    static int[][] distance;
    static int[][] postCity;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cityCount = Integer.parseInt(br.readLine());
        int busCount = Integer.parseInt(br.readLine());

        postCity = new int[cityCount + 1][cityCount + 1];
        distance = new int[cityCount + 1][cityCount + 1];

        for (int i=1; i<=cityCount; i++) {
            Arrays.fill(distance[i], MAX_VALUE);
            distance[i][i] = 0;
        }

        StringTokenizer st;
        for (int i=0; i<busCount; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int startCity = Integer.parseInt(st.nextToken());
            int endCity = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            distance[startCity][endCity] = Math.min(distance[startCity][endCity], value);
            postCity[startCity][endCity] = endCity;
        }

        for (int k=1; k<=cityCount; k++) {
            for (int i=1; i<=cityCount; i++) {
                for (int j=1; j<=cityCount; j++) {
                    if (distance[i][j] > distance[i][k] + distance[k][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                        postCity[i][j] = postCity[i][k];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i=1; i<=cityCount; i++) {
            for (int j=1; j<=cityCount; j++) {
                if (distance[i][j] == MAX_VALUE) { sb.append("0 "); continue; }
                sb.append(distance[i][j] + " ");
            }
            sb.append("\n");
        }

        for (int i=1; i<=cityCount; i++) {
            for (int j=1; j<=cityCount; j++) {
                if (distance[i][j] == 0 || distance[i][j] == MAX_VALUE) {
                    sb.append("0\n");
                    continue;
                }
                sb.append(getRoute(i, j));
            }
        }

        System.out.println(sb.toString());
    }

    public static String getRoute(int start, int end) {
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        list.add(start);

        while (start != end) {
            start = postCity[start][end];
            list.add(start);
        }

        sb.append(list.size() + " ");
        for (int value : list) {
            sb.append(value + " ");
        }
        sb.append("\n");

        return sb.toString();
    }
}