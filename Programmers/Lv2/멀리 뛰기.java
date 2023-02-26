/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 멀리 뛰기 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12914
 */

class Solution {

    static final int DIV = 1234567;

    static int[] dp = new int[2001];

    public long solution(int n) {
        dp[1] = 1;
        if (n == 1) {
            return dp[1];
        }
        dp[2] = 2;
        for (int i=3; i<=n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % DIV;
        }

        return dp[n];
    }
}