/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 괄호 회전하기 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/76502
 */

import java.util.*;

class Solution {

    static int N;
    static StringBuilder sb = new StringBuilder();

    public int solution(String s) {
        N = s.length();
        sb.append(s).append(s);
        int result = 0;
        for (int i=0; i<N; i++) {
            if (isCorrect(i)) {
                result++;
            }
        }

        return result;
    }

    private static boolean isCorrect(int sIndex) {
        Stack<Character> stack = new Stack<>();
        for (int i=sIndex; i<sIndex + N; i++) {
            char c = sb.charAt(i);
            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
                continue;
            }
            if (c == ')' && stack.peek() != '(') {
                return false;
            }
            if (c == ']' && stack.peek() != '[') {
                return false;
            }
            if (c == '}' && stack.peek() != '{') {
                return false;
            }
            stack.pop();
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}