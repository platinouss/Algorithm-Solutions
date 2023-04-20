/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 공 이동 시뮬레이션 (Lv3)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/87391
 */

class Solution {
    public long solution(int n, int m, int x, int y, int[][] queries) {
        int i1 = x, j1 = y;
        int i2 = x, j2 = y;
        for (int i=queries.length-1; i>=0; i--) {
            int[] query = queries[i];
            // 상으로 움직임
            if (query[0] == 3) {
                i1 = (0 <= i1 - query[1]) ? i1 - query[1] : 0;
                if (i2 != n-1) { i2 -= query[1]; }
                if (i2 < 0) { return 0; }
            }
            // 하
            if (query[0] == 2) {
                if (i1 != 0) { i1 += query[1]; }
                i2 = (i2 + query[1] <= n-1) ? i2 + query[1] : n-1;
                if (n <= i1) { return 0; }
            }
            // 좌
            if (query[0] == 1) {
                j1 = (0 <= j1 - query[1]) ? j1 - query[1] : 0;
                if (j2 != m-1) { j2 -= query[1]; }
                if (j2 < 0) { return 0; }
            }
            // 우
            if (query[0] == 0) {
                if (j1 != 0) { j1 += query[1]; }
                j2 = (j2 + query[1] <= m-1) ? j2 + query[1] : m-1;
                if (m <= j1) { return 0; }
            }
        }
        long distance1 = (i2 - i1) + 1;
        long distance2 = (j2 - j1) + 1;
        return distance1 * distance2;
    }
}