/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : H-Index (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42747
 */

class Solution {
    public int solution(int[] citations) {
        int total = citations.length;
        int hIndex = 0;
        for (int i=0; i<=total; i++) {
            int count = 0;
            for (int v : citations) {
                if (v >= i) {
                    count++;
                }
            }
            if (count >= i) {
                hIndex = i;
            }
        }

        return hIndex;
    }
}