import java.util.*;
import java.io.*;

class Main {

    static char[][] arr;
    static int[] indexI;
    static int[] indexJ;
    static int totalCount = 0;

    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new char[5][5];
        indexI = new int[25];
        indexJ = new int[25];

        for (int i=0; i<5; i++) {
            char[] ch = br.readLine().toCharArray();
            for (int j=0; j<5; j++) {
                arr[i][j] = ch[j];
            }
        }
        for (int k=0; k<25; k++) {
            indexI[k] = k / 5;
            indexJ[k] = k % 5;
        }

        combination(new int[7], 0, 0, 7);

        System.out.println(totalCount);
    }

    private static void combination(int[] answer, int index, int depth, int count) {
        if (count == 0) { bfs(answer); return; }
        if (depth == 25) { return; }

        answer[index] = depth;
        combination(answer, index+1, depth+1, count-1);
        combination(answer, index, depth+1, count);
    }

    private static void bfs(int[] answer) {
        boolean[] visited = new boolean[7];
        Queue<Integer> q = new LinkedList<>();
        q.add(answer[0]);
        visited[0] = true;

        int count = 1;
        int sCount = 0;
        while (!q.isEmpty()) {
            int value = q.remove();
            if (arr[indexI[value]][indexJ[value]] == 'S') { sCount++; }

            for (int k=0; k<di.length; k++) {
                for (int idx=1; idx<7; idx++) {
                    if (visited[idx]) { continue; }
                    if (indexI[value] + di[k] == indexI[answer[idx]] && indexJ[value] + dj[k] == indexJ[answer[idx]]) {
                        visited[idx] = true;
                        q.add(answer[idx]);
                        count++;
                    }
                }
            }

        }

        if (count == 7 && sCount >= 4) { totalCount++; }
    }
}