/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 시소 짝꿍 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/152996
 */

import java.util.*;

class Solution {

    static long count = 0;
    static int[][] combination = {{1, 1}, {1, 2}, {2, 3}, {3, 4}};

    static Map<Double, Integer> map = new HashMap<>();

    public long solution(int[] weights) {
        Arrays.sort(weights);
        for (int weight : weights) {
            getResult(weight);
        }
        return count;
    }

    private static void getResult(int weight) {
        for (int[] combi : combination) {
            double value = (double) (weight * combi[0]) / combi[1];
            if (map.containsKey(value)) {
                count += map.get(value);
            }
        }
        map.put((double) weight, map.getOrDefault((double) weight, 0) + 1);
    }
}