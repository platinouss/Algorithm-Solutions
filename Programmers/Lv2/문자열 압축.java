/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 문자열 압축 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/60057
 */

import java.util.*;

class Solution {

    static int min;

    public int solution(String s) {
        min = s.length();
        if (s.length() == 1) {
            return 1;
        }
        for (int i=1; i<=s.length()/2; i++) {
            int len = 0;
            int total = 0;
            int count = 1;
            int index = i;
            String condition = s.substring(0, i);
            while (index + i <= s.length()) {
                if (condition.equals(s.substring(index, index + i))) {
                    count++;
                    len += i;
                } else {
                    if (len > 0) {
                        total += (len - (Integer.toString(count).length()));
                        len = 0;
                    }
                    condition = s.substring(index, index + i);
                    count = 1;
                }
                index += i;
            }
            if (len > 0) {
                total += (len - (Integer.toString(count).length()));
            }
            min = Math.min(min, s.length() - total);
        }
        return min;
    }
}