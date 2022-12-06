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

    static int[] group;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodeCount = Integer.parseInt(st.nextToken());
        int lineCount = Integer.parseInt(st.nextToken());

        group = new int[nodeCount + 1];
        for (int i=0; i<=nodeCount; i++) {
            group[i] = i;
        }

        PriorityQueue<Line> pq = new PriorityQueue<>();
        for (int i=0; i<lineCount; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int sIdx = Integer.parseInt(st.nextToken());
            int eIdx = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            pq.add(new Line(sIdx, eIdx, v));
        }

        int total = 0;
        int count = 0;
        while (count < nodeCount - 1) {
            Line line = pq.remove();
            if (!isSameGroup(line.sIndex, line.eIndex)) {
                union(line.sIndex, line.eIndex);
                total += line.value;
                count++;
            }
        }

        System.out.println(total);
    }

    private static boolean isSameGroup(int index1, int index2) {
        return find(index1) == find(index2);
    }

    private static void union(int index1, int index2) {
        int v1 = find(index1);
        int v2 = find(index2);

        if (v1 <= v2) { group[v2] = v1; }
        else { group[v1] = v2; }
    }

    private static int find(int index) {
        if (index == group[index]) { return index; }

        return group[index] = find(group[index]);
    }
}