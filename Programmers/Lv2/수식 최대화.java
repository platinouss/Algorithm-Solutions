/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 수식 최대화 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/67257
 */

import java.util.*;

class Solution {

    static long answer = 0;
    static List<String> nums = new ArrayList<>();
    static List<String> opers = new ArrayList<>();

    static char[] operation = {'+', '-', '*'};
    static char[] priority = new char[3];
    static boolean[] visited;

    public long solution(String expression) {
        visited = new boolean[3];
        int index = 0;
        for (int i=0; i<expression.length(); i++) {
            char c = expression.charAt(i);
            if (!Character.isDigit(c)) {
                nums.add(expression.substring(index, i));
                opers.add(String.valueOf(c));
                index = i+1;
            }
        }
        nums.add(expression.substring(index, expression.length()));

        combination(0, expression);
        return answer;
    }

    private static void combination(int depth, String expression) {
        if (depth == 3) {
            calculate(expression);
            return;
        }

        for (int i=0; i<3; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            priority[depth] = operation[i];
            combination(depth + 1, expression);
            visited[i] = false;
        }
    }

    private static void calculate(String expression) {
        Deque<String> deque = new ArrayDeque<>();
        deque.addLast(nums.get(0));
        for (int i=0; i<opers.size(); i++) {
            deque.addLast(opers.get(i));
            deque.addLast(nums.get(i + 1));
        }
        for (int k=0; k<3; k++) {
            Deque<String> tmp = new ArrayDeque<>();
            while (!deque.isEmpty()) {
                String str = deque.removeFirst();
                if (str.charAt(0) == priority[k]) {
                    long v1 = Long.parseLong(tmp.removeLast());
                    long v2 = Long.parseLong(deque.removeFirst());
                    tmp.addLast(getResult(v1, v2, priority[k]));
                } else {
                    tmp.addLast(str);
                }
            }
            deque = tmp;
        }
        answer = Math.max(answer, Math.abs(Long.parseLong(deque.peek())));
    }

    private static String getResult(long v1, long v2, char c) {
        long result = 0;
        if (c == '+') {
            result = v1 + v2;
        }
        if (c == '-') {
            result = v1 - v2;
        }
        if (c == '*') {
            result = v1 * v2;
        }

        return String.valueOf(result);
    }
}