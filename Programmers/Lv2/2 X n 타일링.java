/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 2 X n 타일링 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12900
 */

class Solution {

    static final int DIV = 1_000_000_007;

    static int[] dp;

    public int solution(int n) {
        if (n == 1) {
            return 1;
        }
        dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i=3; i<=n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % DIV;
        }
        return dp[n];
    }
}
