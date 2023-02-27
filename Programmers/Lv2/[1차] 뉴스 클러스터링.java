/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : [1차] 뉴스 클러스터링 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/17677
 */

import java.util.*;

class Solution {

    static Map<String, Integer> map1 = new HashMap<>();
    static Map<String, Integer> map2 = new HashMap<>();

    public int solution(String str1, String str2) {
        int str1Count = makeElement(str1.toLowerCase(), map1);
        int str2Count = makeElement(str2.toLowerCase(), map2);
        int sameCount = sameVocaCount();

        int div = str1Count + str2Count - sameCount;
        if (sameCount == 0 && div == 0) {
            return 65536;
        }

        double answer = (double) sameCount / div;
        return (int) Math.floor(answer * 65536);
    }

    private static int sameVocaCount() {
        int count = 0;
        for (String voca : map1.keySet()) {
            if (map2.containsKey(voca)) {
                count += Math.min(map1.get(voca), map2.get(voca));
            }
        }
        return count;
    }

    private static int makeElement(String str, Map<String, Integer> map) {
        int count = 0;
        for (int i=0; i<str.length() - 1; i++) {
            String voca = str.substring(i, i+2);
            if (!proofVoca(voca)) {
                continue;
            }
            count++;
            map.put(voca, map.getOrDefault(voca, 0) + 1);
        }

        return count;
    }

    private static boolean proofVoca(String voca) {
        for (char c : voca.toCharArray()) {
            if (!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }
}