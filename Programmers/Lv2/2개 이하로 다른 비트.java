/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 2개 이하로 다른 비트 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/77885
 */

import java.util.*;

class Solution {
    public long[] solution(long[] numbers) {
        int N = numbers.length;
        long[] answer = new long[N];
        for (int i=0; i<N; i++) {
            answer[i] = getResult(numbers[i]);
        }
        return answer;
    }

    private static long getResult(long number) {
        String binary = Long.toString(number, 2);
        if (binary.charAt(binary.length() - 1) == '0') {
            return number + 1;
        }
        int zeroIdx = binary.lastIndexOf('0');
        if (zeroIdx != -1) {
            return Long.parseLong(binary.substring(0, zeroIdx) +
                    "10" + binary.substring(zeroIdx + 2), 2);
        }
        return Long.parseLong("10" + binary.substring(1, binary.length()), 2);
    }

    private static boolean isAllOne(String binary) {
        for (char c : binary.toCharArray()) {
            if (c == '0') {
                return false;
            }
        }
        return true;
    }
}