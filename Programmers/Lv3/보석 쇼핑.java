/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 보석 쇼핑 (Lv3)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/67258
 */

import java.util.*;

class Solution {

    static int sIndex;
    static int eIndex;
    static Map<String, Integer> map = new HashMap<>();

    public int[] solution(String[] gems) {
        Set<String> set = new HashSet<>();
        for (String gem : gems) {
            set.add(gem);
        }

        int left = 0;
        int right = 0;
        int distance = gems.length + 1;
        while (true) {
            if (map.size() == set.size()) {
                String gem = gems[left];
                map.put(gem, map.get(gem) - 1);
                if (map.get(gem) == 0) {
                    map.remove(gem);
                }
                left++;
            } else if (right == gems.length) {
                break;
            } else {
                String gem = gems[right];
                map.put(gem, map.getOrDefault(gem, 0) + 1);
                right++;
            }

            if (map.size() == set.size()) {
                if (distance > right - left) {
                    distance = right - left;
                    sIndex = left + 1;
                    eIndex = right;
                }
            }
        }

        int[] answer = {sIndex, eIndex};
        return answer;
    }
}