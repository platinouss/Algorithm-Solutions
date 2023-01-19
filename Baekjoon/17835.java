/**
 * 백준 17835번 (골드 2)
 * 문제 이름 : 면접보는 승범이네
 * 알고리즘 분류 : https://www.acmicpc.net/problem/17835
 * 링크 : https://www.acmicpc.net/problem/17835
 */

import java.util.*;
import java.io.*;

public class Main {

    static class Node implements Comparable<Node> {
        int index;
        long distance;

        public Node(int i, long distance) {
            this.index = i;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node n) {
            if (this.distance < n.distance) {
                return -1;
            }
            return 1;
        }
    }

    static final long MAX_VALUE = 10_000_000_000L;

    static long[] arr;
    static boolean[] visited;
    static List<List<Node>> list = new ArrayList<>();
    static PriorityQueue<Node> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int testAreaCount = Integer.parseInt(st.nextToken());
        for (int i=0; i<=N; i++) {
            list.add(new ArrayList<>());
        }
        while (K-- > 0) {
            st = new StringTokenizer(br.readLine());
            int sIndex = Integer.parseInt(st.nextToken());
            int eIndex = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            list.get(eIndex).add(new Node(sIndex, distance));
        }

        visited = new boolean[N + 1];
        arr = new long[N + 1];
        Arrays.fill(arr, MAX_VALUE);

        st = new StringTokenizer(br.readLine(), " ");
        while (testAreaCount-- > 0) {
            int idx = Integer.parseInt(st.nextToken());
            arr[idx] = 0;
            pq.add(new Node(idx, arr[idx]));
        }

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if (visited[node.index]) {
                continue;
            }
            visited[node.index] = true;
            for (Node n : list.get(node.index)) {
                if (!visited[n.index] && arr[node.index] + n.distance < arr[n.index]) {
                    arr[n.index] = arr[node.index] + n.distance;
                    pq.add(new Node(n.index, arr[n.index]));
                }
            }
        }

        int minIndex = 0;
        long maxDistance = Long.MIN_VALUE;
        for (int i=1; i<=N; i++) {
            if (visited[i] && arr[i] > maxDistance) {
                maxDistance = arr[i];
                minIndex = i;
            }
        }

        System.out.println(minIndex);
        System.out.println(maxDistance);
    }
}


