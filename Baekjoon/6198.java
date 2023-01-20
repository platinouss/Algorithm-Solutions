/**
 * 백준 6198번 (골드 5)
 * 문제 이름 : 옥상 정원 꾸미기
 * 알고리즘 분류 : 스택
 * 링크 : https://www.acmicpc.net/problem/6198
 */

import java.util.*;
import java.io.*;

public class Main {

    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long total = 0;
        while (N-- > 0) {
            int height = Integer.parseInt(br.readLine());
            while (!stack.isEmpty() && stack.peek() <= height) {
                stack.pop();
            }
            total += stack.size();
            stack.push(height);
        }
        System.out.println(total);
    }
}

