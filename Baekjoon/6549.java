/**
 * 백준 6549번 (플레티넘 5)
 * 문제 이름 : 히스토그램에서 가장 큰 직사각형
 * 알고리즘 분류 : 스택
 * 링크 : https://www.acmicpc.net/problem/6549
 */

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            if (N == 0) {
                break;
            }

            int[] heights = new int[N];
            for (int i=0; i<N; i++) {
                heights[i] = Integer.parseInt(st.nextToken());
            }

            long maxArea = 0L;
            Stack<Integer> stack = new Stack<>();
            for (int i=0; i<N; i++) {
                while ((!stack.isEmpty()) && heights[stack.peek()] >= heights[i]) {
                    int height = heights[stack.pop()];
                    int width = 0;
                    if (stack.isEmpty()) {
                        width = i;
                    } else {
                        width = i - stack.peek() - 1;
                    }
                    maxArea = Math.max(maxArea, (long) height * width);
                }
                stack.push(i);
            }

            while (!stack.isEmpty()) {
                int heigth = heights[stack.pop()];
                int width = 0;
                if (stack.isEmpty()) {
                    width = N;
                } else {
                    width = N - stack.peek() - 1;
                }
                maxArea = Math.max(maxArea, (long) width * heigth);
            }
            sb.append(maxArea).append("\n");
        }
        System.out.println(sb);
    }
}