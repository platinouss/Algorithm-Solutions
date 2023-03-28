/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 숫자 카드 나누기 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/135807
 */

import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        List<Integer> list1 = getDivNumber(arrayA);
        List<Integer> list2 = getDivNumber(arrayB);
        int max1 = 0;
        int max2 = 0;
        for (int i=list1.size() - 1; i>=0; i--) {
            if (isCorrectNumber(list1.get(i), arrayB)) {
                max1 = list1.get(i);
            }
            if (max1 != 0) {
                break;
            }
        }
        for (int i=list2.size() - 1; i>=0; i--) {
            if (isCorrectNumber(list2.get(i), arrayA)) {
                max2 = list2.get(i);
            }
            if (max2 != 0) {
                break;
            }
        }
        return Math.max(max1, max2);
    }

    private static boolean isCorrectNumber(int v, int[] array) {
        for (int number : array) {
            if (number % v == 0) {
                return false;
            }
        }
        return true;
    }

    private static List<Integer> getDivNumber(int[] arr) {
        int number = 0;
        Arrays.sort(arr);
        List<Integer> list = new ArrayList<>();
        for (int k=2; k<=arr[0]; k++) {
            boolean check = true;
            for (int v : arr) {
                if (v % k != 0) {
                    check = false;
                    break;
                }
            }
            if (check) {
                list.add(k);
            }
        }
        return list;
    }
}