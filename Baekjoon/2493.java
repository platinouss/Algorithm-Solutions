import java.util.*;
import java.io.*;

class Main {

    static class Node {
        int index, value;

        public Node(int i, int v) {
            this.index = i;
            this.value = v;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        int[] arr = new int[count + 1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i=1; i<=count; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Node> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i=1; i<arr.length; i++) {
            if (stack.isEmpty()) {
                stack.push(new Node(i, arr[i]));
                sb.append(0 + " ");
                continue;
            }

            while (!stack.isEmpty()) {
                if (stack.peek().value < arr[i]) { stack.pop(); continue; }
                if (stack.peek().value > arr[i]) { break; }
            }

            if (stack.size() == 0) {
                stack.push(new Node(i, arr[i]));
                sb.append(0 + " ");
                continue;
            }

            sb.append(stack.peek().index).append(" ");
            stack.push(new Node(i, arr[i]));
        }

        System.out.println(sb);
    }
}