import java.util.*;
import java.io.*;

class Main {

    static class Jewel implements Comparable<Jewel> {
        int weight, value;

        public Jewel(int w, int v) {
            this.weight = w;
            this.value = v;
        }

        @Override
        public int compareTo(Jewel o) {
            return this.weight - o.weight;
        }
    }

    static int[] bags;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int jewelCount = Integer.parseInt(st.nextToken());
        int bagCount = Integer.parseInt(st.nextToken());

        PriorityQueue<Jewel> jewels = new PriorityQueue<>();
        for (int i=0; i<jewelCount; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            jewels.add(new Jewel(w, v));
        }

        bags = new int[bagCount];
        for (int i=0; i<bagCount; i++) {
            int bagWeight = Integer.parseInt(br.readLine());
            bags[i] = bagWeight;
        }
        Arrays.sort(bags);

        long result = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int bagWeight : bags) {
            while (!jewels.isEmpty()) {
                int jewelWeight = jewels.peek().weight;
                if (bagWeight < jewelWeight) { break; }
                pq.add(jewels.remove().value);
            }
            if (pq.isEmpty()) { continue; }
            result += pq.remove();
        }

        System.out.println(result);
    }
}