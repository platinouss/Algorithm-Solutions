/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 괄호 변환 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/60058
 */

import java.util.*;

class Solution {
    public String solution(String p) {
        return backTracking(p);
    }

    private static String backTracking(String p) {
        if (p.equals("")) {
            return "";
        }
        int index = 0;
        int left = 0;
        int right = 0;
        while (index < p.length()) {
            if (left != 0 && left == right) {
                break;
            }
            char c = p.charAt(index++);
            if (c == '(') {
                left++;
            }
            if (c == ')') {
                right++;
            }
        }
        String u = p.substring(0, index);
        String v = p.substring(index, p.length());
        if (isCorrect(u)) {
            return u + backTracking(v);
        }
        String answer = "(";
        answer += backTracking(v);
        answer += ")";
        answer += repairString(u);
        return answer;
    }

    private static boolean isCorrect(String u) {
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<u.length(); i++) {
            char c = u.charAt(i);
            if (c == '(') {
                stack.push(c);
            }
            if (c == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }

    private static String repairString(String u) {
        StringBuilder sb = new StringBuilder();
        String repair = u.substring(1, u.length() - 1);
        for (int i=0; i<repair.length(); i++) {
            char c = repair.charAt(i);
            if (c == '(') {
                sb.append(')');
            }
            if (c == ')') {
                sb.append('(');
            }
        }
        return sb.toString();
    }
}