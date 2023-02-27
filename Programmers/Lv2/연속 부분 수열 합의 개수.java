/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 연속 부분 수열 합의 갸수 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/131701
 */

import java.util.*;

class Solution {

    static Set<Integer> set = new HashSet<>();

    public int solution(int[] elements) {
        for (int idx=0; idx<elements.length; idx++) {
            getSum(idx, elements);
        }

        return set.size();
    }

    private static void getSum(int index, int[] elements) {
        int total = 0;
        for (int i=1; i<=elements.length; i++) {
            total += elements[(index + i) % elements.length];
            set.add(total);
        }
    }
}