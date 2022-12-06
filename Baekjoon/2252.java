import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int personCount = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());

        List<List<Integer>> frontPersons = new ArrayList<>();
        for (int i=0; i<=personCount; i++) {
            frontPersons.add(new ArrayList<>());
        }

        int[] indegree = new int[personCount + 1];
        for (int i=0; i<count; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int front = Integer.parseInt(st.nextToken());
            int back = Integer.parseInt(st.nextToken());

            indegree[front]++;
            frontPersons.get(back).add(front);
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i=1; i<=personCount; i++) {
            if (indegree[i] == 0) { q.add(i); }
        }

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            int index = q.remove();
            sb.insert(0, index + " ");
            for (int front : frontPersons.get(index)) {
                indegree[front]--;
                if (indegree[front] == 0) { q.add(front); }
            }
        }

        System.out.println(sb.toString());
    }
}