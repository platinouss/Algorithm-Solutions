import java.util.*;
import java.io.*;

class Main {

    static class Line implements Comparable<Line> {
        int sIndex, eIndex, value;

        public Line(int s, int e, int v) {
            this.sIndex = s;
            this.eIndex = e;
            this.value = v;
        }

        @Override
        public int compareTo(Line o) {
            return this.value - o.value;
        }
    }

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        arr = new int[(count+1) + 1];
        for (int i=0; i<arr.length; i++) {
            arr[i] = i;
        }

        PriorityQueue<Line> pq = new PriorityQueue<>();
        for (int i=0; i<count; i++) {
            pq.add(new Line(i, count+1, Integer.parseInt(br.readLine())));
        }

        for (int i=0; i<count; i++) {
            String[] str = br.readLine().split(" ");
            for (int j=0; j<str.length; j++) {
                pq.add(new Line(i, j, Integer.parseInt(str[j])));
            }
        }

        int result = 0;
        int lineCount = 0;
        while (lineCount < (count+1) -1) {
            Line line = pq.remove();
            if (!isSameGroup(line.sIndex, line.eIndex)) {
                union(line.sIndex, line.eIndex);
                result += line.value;
                lineCount++;
            }
        }

        System.out.println(result);
    }

    private static boolean isSameGroup(int index1, int index2) {
        return find(index1) == find(index2);
    }

    private static int find(int index) {
        if (arr[index] == index) { return index; }

        return arr[index] = find(arr[index]);
    }

    private static void union(int index1, int index2) {
        int v1 = find(index1);
        int v2 = find(index2);

        if (v1 >= v2) { arr[v1] = v2; }
        else { arr[v2] = v1; }
    }
}