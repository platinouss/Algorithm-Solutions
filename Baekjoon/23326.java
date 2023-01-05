/**
 * 백준 23326번 (골드 3)
 * 문제 이름 : 홍익 투어리스트
 * 알고리즘 분류 : 이진 검색 트리
 * 링크 : https://www.acmicpc.net/problem/23326
 */

import java.util.*;
import java.io.*;

public class Main {

    static TreeSet<Integer> attractions = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<N; i++) {
            int v = Integer.parseInt(st.nextToken());
            if (v == 1) {
                attractions.add(i);
            }
        }

        int personIndex = 0;
        StringBuilder sb = new StringBuilder();
        while (K-- > 0) {
            String[] arr = br.readLine().split(" ");
            int command = Integer.parseInt(arr[0]);
            if (command == 1) {
                int idx = Integer.parseInt(arr[1]) - 1;
                if (attractions.contains(idx)) {
                    attractions.remove(idx);
                } else {
                    attractions.add(idx);
                }
            }
            if (command == 2) {
                int d = Integer.parseInt(arr[1]);
                d %= N;
                personIndex = (personIndex + d) % N;
            }
            if (command == 3) {
                int result = -1;
                if (attractions.size() == 0) {
                    sb.append(result).append("\n");
                    continue;
                }

                Integer attraction = attractions.ceiling(personIndex);
                if (attraction == null) {
                    attraction = attractions.ceiling(0);
                    result = attraction + (N - personIndex);
                } else {
                    result = attraction - personIndex;
                }
                sb.append(result).append("\n");
            }
        }
        System.out.println(sb);
    }
}