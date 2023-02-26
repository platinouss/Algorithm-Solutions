/**
 * 프로그래머스 Lv2
 * 문제 이름 : 짝지어 제거하기
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12973
 */

import java.util.*;

class Solution {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty() || stack.peek() != c) {
                stack.push(c);
                continue;
            }
            if (stack.peek() == c) {
                stack.pop();
            }
        }
        if (stack.size() != 0) {
            return 0;
        }
        return 1;
    }
}