/**
 * [Baekjoon] 2812. 크게 만들기
 * https://www.acmicpc.net/problem/2812
 *
 */

import java.io.*;
import java.util.*;

class Main {

    static int N, K;
    static Deque<Character> dq;
    static String number;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        number = br.readLine();
        dq = new ArrayDeque<>();
    }

    public static void main (String[] args) throws IOException {
        input();
        for (int i=0; i<number.length(); i++) {
            while (!dq.isEmpty() && K > 0 && dq.getLast() < number.charAt(i)) {
                dq.pollLast();
                K--;
            }
            dq.add(number.charAt(i));
        }
        while (K-- > 0) {
            dq.pollLast();
        }
        StringBuilder result = new StringBuilder();
        while (!dq.isEmpty()) {
            result.append(dq.pollFirst());
        }
        System.out.println(result);
    }
}

