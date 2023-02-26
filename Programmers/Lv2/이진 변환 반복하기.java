/**
 * 프로그래머스 Lv2
 * 문제 이름 : 이진 변환 반복하기
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/70129
 */

import java.util.*;

class Solution {

    static int zeroCount;

    public int[] solution(String s) {
        int count = 0;
        zeroCount = 0;
        while (s.length() > 1) {
            zeroCount += s.length();
            s = s.replace("0", "");
            zeroCount -= s.length();
            s = Integer.toString(s.length(), 2);
            count++;
        }

        int[] answer = {count, zeroCount};
        return answer;
    }
}