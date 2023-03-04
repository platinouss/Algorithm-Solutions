/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 스킬트리 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/49993
 */

import java.util.*;

class Solution {

    static Map<Character, Integer> map = new HashMap<>();

    public int solution(String skill, String[] skill_trees) {
        for (int i=0; i<skill.length(); i++) {
            map.put(skill.charAt(i), i+1);
        }
        int result = 0;
        for (String skillTree : skill_trees) {
            if (isCorrect(skill.length(), skillTree)) {
                result++;
            }
        }
        return result;
    }

    private static boolean isCorrect(int N, String str) {
        boolean[] elements = new boolean[N + 1];
        elements[0] = true;
        for (char c : str.toCharArray()) {
            if (!map.containsKey(c)) {
                continue;
            }
            int idx = map.get(c);
            if (!elements[idx - 1]) {
                return false;
            }
            elements[idx] = true;
        }
        return true;
    }
}