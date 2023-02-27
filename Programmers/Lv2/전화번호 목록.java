/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 전화번호 목록 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42577
 */

import java.util.*;

class Solution {

    static Set<String> set = new HashSet<>();

    public boolean solution(String[] phone_book) {
        boolean answer = true;
        for (String number : phone_book) {
            set.add(number);
        }

        for (String number : phone_book) {
            for (int i=1; i<number.length(); i++) {
                if (set.contains(number.substring(0, i))) {
                    return false;
                }
            }
        }

        return answer;
    }
}