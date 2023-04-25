/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 숫자 타자 대회 (Lv3)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/136797
 */

import java.util.*;

class Solution {

    static final int[][] costs = {
            { 1, 7, 6, 7, 5, 4, 5, 3, 2, 3 },
            { 7, 1, 2, 4, 2, 3, 5, 4, 5, 6 },
            { 6, 2, 1, 2, 3, 2, 3, 5, 4, 5 },
            { 7, 4, 2, 1, 5, 3, 2, 6, 5, 4 },
            { 5, 2, 3, 5, 1, 2, 4, 2, 3, 5 },
            { 4, 3, 2, 3, 2, 1, 2, 3, 2, 3 },
            { 5, 5, 3, 2, 4, 2, 1, 5, 3, 2 },
            { 3, 4, 5, 6, 2, 3, 5, 1, 2, 4 },
            { 2, 5, 4, 5, 3, 2, 3, 2, 1, 2 },
            { 3, 6, 5, 4, 5, 3, 2, 4, 2, 1 }
    };

    static int N;
    static int[][][] dp;

    public int solution(String numbers) {
        N = numbers.length();
        dp = new int[N + 1][10][10];
        for (int i=0; i<=N; i++) {
            for (int j=0; j<10; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return getResult(0, 4, 6, numbers);
    }

    private static int getResult(int depth, int left, int right, String numbers) {
        if (depth == N) {
            return 0;
        }
        if (dp[depth][left][right] != -1) {
            return dp[depth][left][right];
        }
        int count = Integer.MAX_VALUE;
        int number = numbers.charAt(depth) - '0';
        if (number != right) {
            count = Math.min(getResult(depth + 1, number, right, numbers) + costs[left][number], count);
        }
        if (number != left) {
            count = Math.min(getResult(depth + 1, left, number, numbers) + costs[right][number], count);
        }
        return dp[depth][left][right] = count;
    }
}