/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 다단계 칫솔 판매 (Lv3)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/77486
 */

import java.util.*;

class Solution {

    static int N;
    static int[] boss;
    static Map<String, Integer> result = new HashMap<>();
    static Map<String, Integer> indexes = new HashMap<>();

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        N = enroll.length;
        indexes.put("-", -1);
        for (int i=0; i<N; i++) {
            result.put(enroll[i], 0);
            indexes.put(enroll[i], i);
        }
        boss = new int[N];
        for (int i=0; i<N; i++) {
            int idx = indexes.get(enroll[i]);
            boss[i] = indexes.get(referral[idx]);
        }

        for (int i=0; i<seller.length; i++) {
            calculate(seller[i], amount[i] * 100, enroll);
        }

        int[] answer = new int[N];
        for (int i=0; i<N; i++) {
            answer[i] = result.get(enroll[i]);
        }
        return answer;
    }

    private static void calculate(String person, int money, String[] enroll) {
        if (person.equals("-")) {
            return;
        }

        int divide = money / 10;
        result.put(person, (result.get(person) + (money - divide)));

        int myIndex = indexes.get(person);
        int bossIndex = boss[myIndex];
        if (bossIndex == -1 || divide == 0) {
            return;
        }
        calculate(enroll[bossIndex], divide, enroll);
    }
}