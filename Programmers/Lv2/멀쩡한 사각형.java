/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 멀쩡한 사각형 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/62048
 */

class Solution {
    public long solution(int w, int h) {
        long v1 = w;
        long v2 = h;
        return (v1 * v2) - (v1 + v2 - gdc(v1, v2));
    }

    private static long gdc(long w, long h) {
        long max = Math.max(w, h);
        long min = Math.min(w, h);

        while (min != 0) {
            long d = max % min;
            max = min;
            min = d;
        }

        return max;
    }
}