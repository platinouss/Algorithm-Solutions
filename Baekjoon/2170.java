/**
 * 백준 2170번 (골드 5)
 * 문제 이름 : 선 긋기
 * 알고리즘 분류 : 스위핑, 정렬
 * 링크 : https://www.acmicpc.net/problem/2170
 */

import java.io.*;
import java.util.*;

public class Main {

    static class Data implements Comparable<Data> {
        long i, j;

        public Data(long i, long j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public int compareTo(Data d) {
            if (this.i == d.i) {
                long v = this.j - d.j;
                return (int) v;
            }
            long v = this.i - d.i;
            return (int) v;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Data> pq = new PriorityQueue<>();
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            pq.add(new Data(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken())));
        }

        Data d = pq.remove();
        long di = d.i;
        long dj = d.j;
        long sum = dj - di;
        while (!pq.isEmpty()) {
            d = pq.remove();
            if (di <= d.i && d.j <= dj) { continue; }
            if (d.i <= dj) {
                sum += (d.j - dj);
                dj = d.j;
            }
            if (d.i > dj) {
                sum += d.j - d.i;
                dj = d.j;
            }
        }

        System.out.println(sum);
    }
}