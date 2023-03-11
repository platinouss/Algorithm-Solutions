/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 124 나라의 숫자 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12899
 */

import java.util.*;

class Solution {

    static int[] arr = {4, 1, 2};
    static StringBuilder sb = new StringBuilder();

    public String solution(int n) {
        while (n > 0) {
            sb.insert(0, arr[n % 3]);
            n = (n - 1) / 3;
        }

        return sb.toString();
    }
}