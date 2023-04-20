/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 카운트 다운 (Lv3)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/131129
 */

import java.util.*;

class Solution {

    static final int MAX_VALUE = 100_001;

    static List<Integer> otherScores = new ArrayList<>();
    static List<Integer> singleAndBall = new ArrayList<>();
    static int[][] dp = new int[100_001][2];

    public int[] solution(int target) {
        for (int i=0; i<dp.length; i++) {
            dp[i][0] = MAX_VALUE;
        }
        for (int i=1; i<=20; i++) {
            otherScores.add(i * 2);
            otherScores.add(i * 3);
        }
        singleAndBall.add(50);
        for (int i=1; i<=20; i++) {
            singleAndBall.add(i);
        }
        getResult(target);
        return dp[target];
    }

    private static int[] getResult(int target) {
        if (target == 0) {
            return new int[] {0, 0};
        }
        if (target < 0) {
            return new int[] {MAX_VALUE, 0};
        }
        if (dp[target][0] != MAX_VALUE) {
            return dp[target];
        }
        int[] result = new int[] {Integer.MAX_VALUE, 0};
        for (int i=0; i<singleAndBall.size(); i++) {
            int[] tmp = getResult(target - singleAndBall.get(i));
            setScore(result, new int[]{tmp[0] + 1, tmp[1] + 1});
        }
        for (int i=0; i<otherScores.size(); i++) {
            int[] tmp = getResult(target - otherScores.get(i));
            setScore(result, new int[]{tmp[0] + 1, tmp[1]});
        }
        dp[target][0] = result[0];
        dp[target][1] = result[1];
        return dp[target];
    }

    private static void setScore(int[] result, int[] tmp) {
        if (result[0] > tmp[0]) {
            result[0] = tmp[0];
            result[1] = tmp[1];
        } else if (result[0] == tmp[0] && result[1] < tmp[1]) {
            result[1] = tmp[1];
        }
    }
}