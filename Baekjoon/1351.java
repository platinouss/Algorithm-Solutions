/**
 * 백준 1351번 (골드 5)
 * 문제 이름 : 무한 수열
 * 알고리즘 분류 : DP, 해시
 * 링크 : https://www.acmicpc.net/problem/1351
 */

import java.io.*;
import java.util.*;

public class Main {

    static long P;
    static long Q;
    static Map<Long, Long> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long N = Long.parseLong(st.nextToken());
        P = Long.parseLong(st.nextToken());
        Q = Long.parseLong(st.nextToken());

        map.put(0L, 1L);
        System.out.println(getResult(N));
    }

    private static long getResult(long value) {
        if (map.containsKey(value)) {
            return map.get(value);
        }
        long result = getResult(value / P) + getResult(value / Q);
        map.put(value, result);

        return result;
    }
}