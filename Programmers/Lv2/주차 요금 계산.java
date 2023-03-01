/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 주차 요금 계산 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/92341
 */

import java.util.*;

class Solution {

    static Map<Integer, Integer> carIn = new HashMap<>();
    static Map<Integer, Integer> result = new HashMap<>();

    public int[] solution(int[] fees, String[] records) {
        int defaultTime = fees[0];
        int defaultFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];

        for (String record : records) {
            String[] arr = record.split(" ");
            String[] time = arr[0].split(":");
            int hour = Integer.parseInt(time[0]);
            int min = Integer.parseInt(time[1]);
            int number = Integer.parseInt(arr[1]);

            if (arr[2].equals("IN")) {
                carIn.put(number, hour*60 + min);
            }
            if (arr[2].equals("OUT")) {
                int useTime = (hour * 60 + min) - carIn.get(number);
                result.put(number, result.getOrDefault(number, 0) + useTime);
                carIn.remove(number);
            }
        }

        for (int number : carIn.keySet()) {
            int useTime = (23 * 60 + 59) - carIn.get(number);
            result.put(number, result.getOrDefault(number, 0) + useTime);
        }

        List<Integer> carNumber = new LinkedList<>(result.keySet());
        Collections.sort(carNumber);

        int[] answer = new int[carNumber.size()];
        for (int i=0; i<answer.length; i++) {
            answer[i] = defaultFee;
            double totalTime = (double) result.get(carNumber.get(i));
            int sumFee = 0;
            if (totalTime > defaultTime) {
                sumFee = (int) (Math.ceil((totalTime - defaultTime) / unitTime) * unitFee);
            }
            answer[i] += sumFee;
        }
        return answer;
    }
}