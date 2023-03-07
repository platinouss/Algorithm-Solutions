/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 모음사전 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/84512
 */

import java.util.*;

class Solution {

    static String condition = "AEIOU";
    static int[] memorization = {781, 156, 31, 6, 1};

    public int solution(String word) {
        int result = word.length();
        for (int i=0; i<word.length(); i++) {
            int idx = condition.indexOf(word.charAt(i));
            result += memorization[i] * idx;
        }
        return result;
    }
}