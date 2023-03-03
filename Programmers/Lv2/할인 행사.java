/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 할인 행사 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/131127
 */

import java.util.*;

class Solution {

    static int result;
    static int[] arr;
    static Map<String, Integer> indexes = new HashMap<>();

    public int solution(String[] want, int[] number, String[] discount) {
        for (int i=0; i<want.length; i++) {
            indexes.put(want[i], i);
        }

        arr = new int[number.length];
        for (int i=0; i<10; i++) {
            String food = discount[i];
            if (indexes.containsKey(food)) {
                arr[indexes.get(food)]++;
            }
        }

        if (isSignDay(number, arr)) {
            result++;
        }

        for (int i=10; i<discount.length; i++) {
            String beforeFood = discount[i-10];
            String nowFood = discount[i];
            if (indexes.containsKey(beforeFood)) {
                arr[indexes.get(beforeFood)]--;
            }
            if (indexes.containsKey(nowFood)) {
                arr[indexes.get(nowFood)]++;
            }
            if (isSignDay(number, arr)) {
                result++;
            }
        }

        return result;
    }

    private static boolean isSignDay(int[] number, int[] arr) {
        for (int i=0; i<number.length; i++) {
            if (number[i] > arr[i]) {
                return false;
            }
        }
        return true;
    }
}