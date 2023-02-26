/**
 * 프로그래머스 Lv2
 * 문제 이름 : 피보나치 수
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12945
 */

class Solution {

    static int[] dp;
    static final int DIV = 1234567;

    public int solution(int n) {
        dp = new int[n + 1];
        dp[1] = 1;
        for (int i=2; i<=n; i++) {
            dp[i] = (dp[i-2] + dp[i-1]) % DIV;
        }
        return dp[n];
    }
}