import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int totalCount = Integer.parseInt(br.readLine());
        for (int i=0; i<totalCount; i++) {
            char[] operations = br.readLine().toCharArray();
            int count = Integer.parseInt(br.readLine());

            Deque<Integer> dq = new ArrayDeque<>();
            splitString(br.readLine(), dq);

            boolean error = false;
            boolean reverse = false;
            for (char oper : operations) {
                if (oper == 'D' && dq.size() == 0) { sb.append("error"); error = true; break; }
                if (oper == 'R') { reverse = !reverse; }
                if (oper == 'D') {
                    if (reverse) { dq.removeLast(); continue; }
                    dq.removeFirst();
                }
            }

            if (error) { sb.append("\n"); continue; }

            sb.append("[");
            if (reverse) {
                while (!dq.isEmpty()) {
                    sb.append(dq.removeLast());
                    if (dq.size() > 0) { sb.append(","); }
                }
            } else {
                while (!dq.isEmpty()) {
                    sb.append(dq.removeFirst());
                    if (dq.size() > 0) { sb.append(","); }
                }
            }
            sb.append("]");
            sb.append("\n");
        }

        System.out.print(sb);
    }

    private static void splitString(String s, Deque<Integer> dq) {
        s = s.substring(1, s.length() - 1);
        if (s.length() == 0) { return; }

        List<Integer> list = Arrays.stream(s.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        for (int value : list) { dq.addLast(value); }
    }
}