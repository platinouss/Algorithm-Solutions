/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 표현 가능한 이진트리 (Lv3)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/150367
 */

import java.util.*;

class Solution {
    public int[] solution(long[] numbers) {
        int index = 0;
        int[] answer = new int[numbers.length];
        for (long number : numbers) {
            String binary = makeCorrectBinary(Long.toString(number, 2));
            answer[index++] = (isCorrect(binary)) ? 1 : 0;
        }
        return answer;
    }

    private static boolean isCorrect(String binary) {
        if (binary.length() == 1 || isAllZero(binary)) {
            return true;
        }
        int midIndex = binary.length() / 2;
        String left = binary.substring(0, midIndex);
        String right = binary.substring(midIndex + 1, binary.length());
        if (binary.charAt(midIndex) == '1' && isCorrect(left) && isCorrect(right)) {
            return true;
        }
        return false;
    }

    private static boolean isAllZero(String binary) {
        for (char c : binary.toCharArray()) {
            if (c != '0') {
                return false;
            }
        }
        return true;
    }

    private static String makeCorrectBinary(String binary) {
        int len = 2;
        while (true) {
            if (binary.length() <= len - 1) {
                break;
            }
            len *= 2;
        }
        String zero = "0";
        return zero.repeat(len - 1 - binary.length()) + binary;
    }
}