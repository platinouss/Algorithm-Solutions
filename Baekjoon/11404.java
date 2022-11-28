import java.io.*;
import java.util.*;

public class Main {
    static int[][] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int citySize = Integer.parseInt(br.readLine());
        int lineSize = Integer.parseInt(br.readLine());

        distance = new int[citySize+1][citySize+1];
        for(int i=1; i<=citySize; i++) {
            for(int j=1; j<=citySize; j++) {
                if(i==j) {
                    distance[i][j] = 0;
                } else {
                    distance[i][j] = 10000001;
                }
            }
        }

        for(int i=0; i<lineSize; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int index1 = Integer.parseInt(st.nextToken());
            int index2 = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            if(distance[index1][index2] > d)    { distance[index1][index2] = d; }
        }

        for(int k=1; k<=citySize; k++) {
            for(int i=1; i<=citySize; i++) {
                for(int j=1; j<=citySize; j++) {
                    distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                }
            }
        }

        for(int i=1; i<=citySize; i++) {
            for(int j=1; j<=citySize; j++) {
                if(distance[i][j] == 10000001) { bw.write("0 "); }
                else { bw.write(distance[i][j] + " "); }
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}