import java.util.*;
import java.io.*;

class Main {
    static class Node implements Comparable<Node> {
        int index;
        int value;

        public Node(int e, int v) {
            this.index = e;
            this.value = v;
        }

        @Override
        public int compareTo(Node n) {
            return this.value - n.value;
        }
    }

    static int[] costs;
    static int[] preCity;
    static StringBuilder sb = new StringBuilder();
    static List<List<Node>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cityCount = Integer.parseInt(br.readLine());
        int busCount = Integer.parseInt(br.readLine());
        for(int i=0; i<=cityCount; i++) {
            list.add(new ArrayList<>());
        }

        costs = new int[cityCount + 1];
        Arrays.fill(costs, Integer.MAX_VALUE);
        preCity = new int[cityCount + 1];

        StringTokenizer st;
        for (int i=0; i<busCount; i++) {
            st = new StringTokenizer(br.readLine());
            int sIndex = Integer.parseInt(st.nextToken());
            int eIndex = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            list.get(sIndex).add(new Node(eIndex, value));
        }

        st = new StringTokenizer(br.readLine());
        int startCity = Integer.parseInt(st.nextToken());
        int endCity = Integer.parseInt(st.nextToken());
        preCity[startCity] = 0;
        costs[startCity] = 0;

        dijkstra(startCity, endCity);

        sb.append(costs[endCity]);
        sb.append("\n");
        getRoute(startCity, endCity);

        System.out.println(sb.toString());
    }

    public static void getRoute(int startCity, int endCity) {
        StringBuilder tmp = new StringBuilder();

        int count = 1;
        int city = endCity;
        tmp.append(endCity);
        while (true) {
            if (city == startCity) { break; }
            city = preCity[city];
            tmp.insert(0, city + " ");
            count++;
        }

        sb.append(count);
        sb.append("\n");
        sb.append(tmp.toString());
    }

    public static void dijkstra(int startCity, int endCity) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(startCity, 0));
        while (!pq.isEmpty()) {
            Node node = pq.remove();
            if (node.index == endCity) { break; }
            for (Node n : list.get(node.index)) {
                int value = n.value + costs[node.index];
                if (costs[n.index] > value) {
                    pq.add(new Node(n.index, value));
                    costs[n.index] = value;
                    preCity[n.index] = node.index;
                }
            }
        }
    }
}