/**
 * 백준 1655번 (골드 2)
 * 문제 이름 : 가운데를 말해요
 * 알고리즘 분류 : 우선순위 큐
 * 링크 : https://www.acmicpc.net/problem/1655
 */

import java.util.*;
import java.io.*;

public class Main {

    static PriorityQueue<Integer> upperMid = new PriorityQueue<>();
    static PriorityQueue<Integer> lowerMid = new PriorityQueue<>(Comparator.reverseOrder());

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        lowerMid.add(Integer.parseInt(br.readLine()));
        sb.append(lowerMid.peek()).append("\n");

        for (int k=1; k<N; k++) {
            int value = Integer.parseInt(br.readLine());
            if (lowerMid.size() == upperMid.size()) {
                lowerMid.add(value);
                if (!upperMid.isEmpty() && lowerMid.peek() > upperMid.peek()) {
                    upperMid.offer(lowerMid.poll());
                    lowerMid.offer(upperMid.poll());
                }
            } else {
                upperMid.add(value);
                if (lowerMid.peek() > upperMid.peek()) {
                    upperMid.offer(lowerMid.poll());
                    lowerMid.offer(upperMid.poll());
                }
            }
            sb.append(lowerMid.peek()).append("\n");
        }
        System.out.println(sb);
    }
}