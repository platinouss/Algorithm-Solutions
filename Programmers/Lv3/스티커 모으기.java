/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 스티커 모으기 (Lv3)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12971
 */

class Solution {

    static int N;
    static int max;
    static int[] dp;

    public int solution(int[] sticker) {
        N = sticker.length;
        if (N == 1) {
            return sticker[0];
        }

        dp = new int[N + 2];
        for (int i=3; i<dp.length; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + sticker[i- 2]);
        }
        max = dp[dp.length - 1];

        for (int i=2; i<dp.length; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + sticker[i - 2]);
        }

        return Math.max(max, dp[dp.length - 2]);
    }
}