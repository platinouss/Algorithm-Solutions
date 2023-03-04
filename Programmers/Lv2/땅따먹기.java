/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 땅따먹기 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12913
 */

import java.util.*;

class Solution {
    int solution(int[][] land) {
        int N = land.length;
        int[][] dp = new int[N][4];
        dp[0] = land[0];

        for (int i=1; i<N; i++) {
            for (int j=0; j<4; j++) {
                for (int k=0; k<4; k++) {
                    if (j == k) {
                        continue;
                    }
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][k] + land[i][j]);
                }
            }
        }

        return Arrays.stream(dp[N - 1]).max().getAsInt();
    }
}