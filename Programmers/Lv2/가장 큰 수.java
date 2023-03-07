/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 가장 큰 수 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42746
 */


import java.util.*;

class Solution {

    static String[] arr;

    public String solution(int[] numbers) {
        arr = new String[numbers.length];
        for (int i=0; i<numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(arr, (o1, o2) -> {
            return (o2 + o1).compareTo(o1 + o2);
        });

        if (arr[0].equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (String number : arr) {
            sb.append(number);
        }

        return sb.toString();
    }
}