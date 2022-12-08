import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray();

        int tmp = 1;
        int result = 0;
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<chars.length; i++) {
            char c = chars[i];
            if (c == '(' || c == '[') {
                stack.push(c);
                tmp *= (c == '(') ? 2 : 3;
                continue;
            }
            if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(') { result = 0; break; }
                if (chars[i-1] == '(') { result += tmp; }
                tmp /= 2;
                stack.pop();
            }
            if (c == ']') {
                if (stack.isEmpty() || stack.peek() != '[') { result = 0; break; }
                if (chars[i-1] == '[') { result += tmp; }
                tmp /= 3;
                stack.pop();
            }
        }

        if(!stack.isEmpty()) { result = 0; }
        System.out.println(result);
    }
}