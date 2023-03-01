/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : [3차] n진수 게임 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/17687
 */

import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        int value = 0;
        while (sb.length() < (t * m)) {
            sb.append(Integer.toString(value++, n));
        }
        int index = p-1;
        StringBuilder result = new StringBuilder();
        for (int k=0; k<t; k++) {
            String str = String.valueOf(sb.charAt(index));
            result.append(str.toUpperCase());
            index += m;
        }

        return result.toString();
    }
}