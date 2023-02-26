/**
 * 프로그래머스 Lv2
 * 문제 이름 : 다음 큰 숫자
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12911
 */

import java.util.*;

class Solution {
    public int solution(int n) {
        int limit = getOneCount(n);
        int value = n;
        while (true) {
            n++;
            if (limit == getOneCount(n)) {
                break;
            }
        }
        return n;
    }

    private static int getOneCount(int n) {
        int count = 0;
        for (char c : Integer.toString(n, 2).toCharArray()) {
            if (c == '1') {
                count++;
            }
        }
        return count;
    }
}