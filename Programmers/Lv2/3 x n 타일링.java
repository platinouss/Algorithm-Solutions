/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 3 x n 타일링 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12902
 */

class Solution {

    static final int DIV = 1_000_000_007;

    static long[] dp = new long[5001];

    public int solution(int n) {
        dp[0] = 1L;
        dp[2] = 3L;
        for (int i=4; i<=n; i+=2) {
            dp[i] = ((dp[i - 2] * 4) % DIV - (dp[i - 4]) % DIV + DIV) % DIV;
        }
        return (int) dp[n];
    }
}