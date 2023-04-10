/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 두 원 사이의 정수 쌍 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/181187
 */

class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        for (int x=1; x<r2; x++) {
            if (x < r1) {
                answer += getY(r2, x, false) - getY(r1, x, true);
            } else {
                answer += getY(r2, x, false);
            }
        }
        answer *= 4;
        answer += (r2 - r1 + 1) * 4;
        return answer;
    }

    private static long getY(int r, int x, boolean check) {
        double y1 = Math.sqrt(Math.pow(r, 2) - Math.pow(x, 2));
        long y2 = (long) y1;
        if (check && y2 - y1 == 0) {
            return y2 - 1;
        }
        return y2;
    }
}