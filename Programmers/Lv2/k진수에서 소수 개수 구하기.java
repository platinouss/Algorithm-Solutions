/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : k진수에서 소수 개수 구하기 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/92335
 */

import java.util.*;

class Solution {
    public int solution(int n, int k) {
        String str = Integer.toString(n, k);
        String[] numbers = str.split("0");

        int count = 0;
        for (String number : numbers) {
            if (number.equals("")) {
                continue;
            }
            long v = Long.parseLong(number);
            if (isPrime(v)) {
                count++;
            }
        }

        return count;
    }

    private boolean isPrime(long n) {
        if (n < 2) {
            return false;
        }
        for (long v=2; v<=Math.sqrt(n); v++) {
            if (n % v == 0) {
                return false;
            }
        }
        return true;
    }
}