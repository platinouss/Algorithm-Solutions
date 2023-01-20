/**
 * 백준 20183번 (골드 2)
 * 문제 이름 : 골목 대장 호석 - 효율성 2
 * 알고리즘 분류 : 그래프, 다익스트라
 * 링크 : https://www.acmicpc.net/problem/20183
 */

import java.util.*;
import java.io.*;

public class Main {

    static class Node implements Comparable<Node> {
        int index;
        long distance;

        public Node(int i, long d) {
            this.index = i;
            this.distance = d;
        }

        @Override
        public int compareTo(Node n) {
            if (this.index < n.index) {
                return -1;
            }
            return 1;
        }
    }

    static class City implements Comparable<City> {
        int index;
        long price, maxPrice;

        public City(int i, long p, long m) {
            this.index = i;
            this.price = p;
            this.maxPrice = m;
        }

        @Override
        public int compareTo(City c) {
            if (this.maxPrice == c.maxPrice) {
                if (this.price < c.price) {
                    return -1;
                } else {
                    return 1;
                }
            }
            if (this.maxPrice < c.maxPrice) {
                return -1;
            } else {
                return 1;
            }
        }
    }

    static List<List<Node>> list = new ArrayList<>();
    static PriorityQueue<City> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        long totalPrice = Long.parseLong(st.nextToken());

        for (int i=0; i<=N; i++) {
            list.add(new ArrayList<>());
        }
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int sIndex = Integer.parseInt(st.nextToken());
            int eIndex = Integer.parseInt(st.nextToken());
            long distance = Long.parseLong(st.nextToken());
            list.get(sIndex).add(new Node(eIndex, distance));
            list.get(eIndex).add(new Node(sIndex, distance));
        }

        long maxDistance = Long.MAX_VALUE;
        pq.add(new City(start, 0, 0));
        long[] visited = new long[N + 1];
        Arrays.fill(visited, Long.MAX_VALUE);
        while (!pq.isEmpty()) {
            City city = pq.remove();
            if (city.index == end) {
                maxDistance = city.maxPrice;
                break;
            }
            if (visited[city.index] <= city.maxPrice) {
                continue;
            }
            visited[city.index] = city.maxPrice;
            for (Node n : list.get(city.index)) {
                long nodePrice = city.price + n.distance;
                long maxPrice = Math.max(city.maxPrice, n.distance);
                if (nodePrice > totalPrice || visited[n.index] <= maxPrice) {
                    continue;
                }
                pq.add(new City(n.index, nodePrice, maxPrice));
            }
        }
        if (maxDistance == Long.MAX_VALUE) {
            maxDistance = -1;
        }
        System.out.println(maxDistance);
    }
}