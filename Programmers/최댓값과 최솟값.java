/**
 * 프로그래머스 Lv2
 * 문제 이름 : 최댓값과 최솟값
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12939
 */

import java.util.*;

class Solution {
    public String solution(String s) {
        int[] numbers = Arrays.stream(s.split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
        return numbers[0] + " " + numbers[numbers.length - 1];
    }
}