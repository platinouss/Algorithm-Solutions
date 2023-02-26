/**
 * 프로그래머스 Lv2
 * 문제 이름 : 숫자의 표현
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12924
 */

class Solution {
    public int solution(int n) {
        int count = 0;
        for (int i=1; i<=n; i++) {
            int tmp = 0;
            int v = i;
            while (tmp < n) {
                tmp += v;
                v++;
            }
            if (tmp == n) {
                count++;
            }
        }
        return count;
    }
}