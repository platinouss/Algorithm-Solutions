import java.util.*;
import java.io.*;

class Main {

    static class Node implements Comparable<Node> {
        int index, value;

        public Node(int i, int v) {
            this.index = i;
            this.value = v;
        }

        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }
    }

    static int[] arr;
    static int MAX_VALUE = 10_000_000;
    static List<List<Node>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cityCount = Integer.parseInt(st.nextToken());
        int busCount = Integer.parseInt(st.nextToken());

        arr = new int[cityCount + 1];

        for (int i=0; i<=cityCount; i++) {
            list.add(new ArrayList<>());
        }
        for (int i=0; i<busCount; i++) {
            st = new StringTokenizer(br.readLine());
            int sIndex = Integer.parseInt(st.nextToken());
            int eIndex = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            list.get(sIndex).add(new Node(eIndex, value));
            list.get(eIndex).add(new Node(sIndex, value));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        System.out.println(getResult(1, cityCount, v1, v2));
    }

    private static int getResult(int start, int end, int v1, int v2) {
        int result1 = 0;
        int result2 = 0;
        int v1AndV2 = dijkstra(v1, v2);

        result1 += (dijkstra(start, v1) + v1AndV2 + dijkstra(v2, end));
        result2 += (dijkstra(start, v2) + v1AndV2 + dijkstra(v1, end));

        if (result1 >= MAX_VALUE && result2 >= MAX_VALUE) { return -1; }
        return Math.min(result1, result2);
    }

    private static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        Arrays.fill(arr, MAX_VALUE);
        arr[start] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.remove();
            for (Node n : list.get(node.index)) {
                if (arr[node.index] + n.value >= arr[n.index]) { continue; }
                arr[n.index] = arr[node.index] + n.value;
                pq.add(new Node(n.index, arr[n.index]));
            }
        }

        return arr[end];
    }
}