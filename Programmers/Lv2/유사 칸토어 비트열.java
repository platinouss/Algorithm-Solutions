/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 유사 칸토어 비트열 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/148652
 */

class Solution {
    public int solution(int n, long l, long r) {
        long total = (r - l) + 1;
        for (long idx=l-1; idx<r; idx++) {
            long value = idx;
            while (value >= 1) {
                long d = value / 5;
                long m = value % 5;
                if (d == 2 || m == 2) {
                    total -= 1;
                    break;
                }
                value = d;
            }
        }
        return (int) total;
    }
}