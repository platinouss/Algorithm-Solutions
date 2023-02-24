/**
 * 프로그래머스 Lv2
 * 문제 이름 : JadenCase 문자열 만들기
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12951
 */

import java.util.*;

class Solution {
    public String solution(String s) {
        boolean isSpace = false;
        char[] arr = s.toCharArray();
        if ('a' <= arr[0] && arr[0] <= 'z') {
            arr[0] = Character.toUpperCase(arr[0]);
        } else if (arr[0] == ' ') {
            isSpace = true;
        }
        for (int i=1; i<arr.length; i++) {
            char c = arr[i];
            if (c == ' ') {
                isSpace = true;
                continue;
            }
            if (isSpace) {
                isSpace = false;
                if (Character.isLetter(c)) {
                    arr[i] = Character.toUpperCase(c);
                }
            } else if (Character.isLetter(c)) {
                arr[i] = Character.toLowerCase(c);
            }
        }

        return String.valueOf(arr);
    }
}