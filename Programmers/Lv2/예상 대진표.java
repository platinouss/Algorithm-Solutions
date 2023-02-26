/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 예상 대진표 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12985
 */

class Solution {
    public int solution(int n, int a, int b) {
        int count = 0;
        while (a != b) {
            if (a % 2 == 1) {
                a++;
            }
            if (b % 2 == 1) {
                b++;
            }
            a = a >> 1;
            b = b >> 1;
            count++;
        }

        return count;
    }
}