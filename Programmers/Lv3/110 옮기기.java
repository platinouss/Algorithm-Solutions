/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 110 옮기기 (Lv3)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/77886
 */

import java.util.*;

class Solution {

    static int index;
    static String[] answer;
    static char[] specificNumber = {'1', '1', '0'};

    public String[] solution(String[] s) {
        answer = new String[s.length];
        for (String str : s) {
            getResult(str);
        }
        return answer;
    }

    private static void getResult(String str) {
        Deque<Character> dq = new ArrayDeque<>();

        int count = 0;
        for (int i=0; i<str.length(); i++) {
            char number = str.charAt(i);
            dq.addLast(number);
            if (isSpecificNumber(dq)) {
                count++;
            }
        }

        int idx = dq.size();
        boolean flag = false;
        StringBuilder sb = new StringBuilder();
        while (!dq.isEmpty()) {
            char c = dq.removeLast();
            if (c == '0') {
                flag = true;
            }
            if (!flag && c == '1') {
                idx--;
            }
            sb.insert(0, c);
        }
        for (int i=0; i<count; i++) {
            sb.insert(idx, "110");
        }
        answer[index++] = sb.toString();
    }

    private static boolean isSpecificNumber(Deque<Character> dq) {
        if (dq.size() < 3) {
            return false;
        }
        int K = 3;
        Iterator<Character> ir = dq.descendingIterator();
        for(int i=1; i<=K; i++) {
            char c = ir.next();
            if (specificNumber[3 - i] != c) {
                return false;
            }
        }
        while (K-- > 0) {
            dq.removeLast();
        }
        return true;
    }
}