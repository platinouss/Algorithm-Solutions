/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 롤케이크 자르기 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/132265
 */

import java.util.*;

class Solution {

    static Map<Integer, Integer> man1 = new HashMap<>();
    static Map<Integer, Integer> man2 = new HashMap<>();

    public int solution(int[] topping) {
        int answer = 0;
        man1.put(topping[0], 1);
        for (int i=1; i<topping.length; i++) {
            man2.put(topping[i], man2.getOrDefault(topping[i], 0) + 1);
        }

        for (int i=1; i<topping.length - 1; i++) {
            if(isFair(i, topping)) {
                answer++;
            }
        }
        return answer;
    }

    private static boolean isFair(int index, int[] topping) {
        int v = topping[index];
        man1.put(v, man1.getOrDefault(v, 0) + 1);
        man2.put(v, man2.get(v) - 1);
        if (man2.get(v) == 0) {
            man2.remove(v);
        }
        if (man1.size() == man2.size()) {
            return true;
        }
        return false;
    }
}