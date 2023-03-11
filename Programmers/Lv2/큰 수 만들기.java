/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 큰 수 만들기 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42883
 */

import java.util.*;

class Solution {

    static StringBuilder sb = new StringBuilder();

    public String solution(String number, int k) {
        int index = 0;
        int N = number.length() - k;
        while (N-- > 0) {
            int max = 0;
            for (int i=index; i<number.length() - N; i++) {
                int value = number.charAt(i) - '0';
                if (max < value) {
                    max = value;
                    index = i+1;
                }
            }
            sb.append(max);
        }
        return sb.toString();
    }
}