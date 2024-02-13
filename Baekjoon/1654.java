/**
 * [Baekjoon] 1654. 랜선 자르기
 * https://www.acmicpc.net/problem/1654
 *
 * 접근 방식
 * 1) 케이블의 길이가 될 수 있는 최소와 최대 길이의 범위를 구한 다음, 문제에서 필요한 케이블 개수를 만족시키면서 최대 케이블 길이를 구한다.
 *    이때, 파라메트릭 서치 알고리즘을 사용하고 케이블 길이를 적절히 늘리거나 줄여가며 위 조건에 만족하는 케이블 길이를 반환한다.
 */

import java.util.*;
import java.io.*;

class Main {

    static int limit;
    static long maxLen;
    static List<Integer> cables;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        limit = Integer.parseInt(st.nextToken());
        cables = new ArrayList<>();
        while (N-- > 0) {
            int cable = Integer.parseInt(br.readLine());
            maxLen = Math.max(maxLen, cable);
            cables.add(cable);
        }
    }

    private static long getCount(long len) {
        long count = 0;
        for (int cable : cables) {
            count += cable / len;
        }
        return count;
    }

    public static void main (String[] args) throws IOException {
        input();
        long minLen = 1;
        while (minLen < maxLen) {
            long mid = (minLen + maxLen) / 2;
            if (limit <= getCount(mid)) {
                minLen = mid + 1;
            } else {
                maxLen = mid;
            }
        }
        if (getCount(minLen) == limit) {
            System.out.println(minLen);
            return;
        }
        System.out.println(minLen - 1);
    }
}
