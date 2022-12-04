import java.util.*;
import java.io.*;

class Main {

    static TreeMap<Integer, Integer> tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int totalCount = Integer.parseInt(br.readLine());

        for (int i=0; i<totalCount; i++) {
            tree = new TreeMap<>();
            int count = Integer.parseInt(br.readLine());
            for (int j=0; j<count; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                char c = st.nextToken().charAt(0);
                int value = Integer.parseInt(st.nextToken());

                if (c == 'I') { insert(value); }
                if (c == 'D' && tree.size() > 0) { delete(value); }
            }

            String result = "";
            if (tree.size() == 0) { result = "EMPTY"; }
            else { result = tree.lastKey() + " " + tree.firstKey(); }

            sb.append(result + "\n");
        }

        System.out.print(sb.toString());
    }

    private static void delete(int location) {
        int key = 0;
        int value = 0;
        if (location == -1) {
            key = tree.firstKey();
            value = tree.get(key);
        }
        if (location == 1) {
            key = tree.lastKey();
            value = tree.get(key);
        }

        if (value == 1) { tree.remove(key); return; }
        tree.put(key, value - 1);
    }

    private static void insert(int value) {
        tree.put(value, tree.getOrDefault(value, 0) + 1);
    }
}