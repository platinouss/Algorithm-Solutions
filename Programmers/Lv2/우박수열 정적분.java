/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 우박수열 정적분 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/134239
 */

import java.util.*;

class Solution {

    static double[] sum;
    static List<Double> list = new ArrayList<>();

    public double[] solution(int k, int[][] ranges) {
        double value = k;
        list.add(value);
        while (value > 1) {
            if (value % 2 == 0) {
                value = value / 2;
            } else {
                value = (value * 3) + 1;
            }
            list.add(value);
        }
        sum = new double[list.size()];
        for (int i=1; i<list.size(); i++) {
            sum[i] = sum[i - 1] + getArea(list.get(i - 1), list.get(i));
        }

        int index = 0;
        double[] answer = new double[ranges.length];
        for (int[] range : ranges) {
            int left = range[0];
            int right = sum.length - 1 + range[1];
            if (left > right) {
                answer[index++] = -1.0;
                continue;
            }
            answer[index++] = sum[right] - sum[left];
        }

        return answer;
    }

    private static double getArea(double len1, double len2) {
        return (len1 + len2) / 2;
    }
}