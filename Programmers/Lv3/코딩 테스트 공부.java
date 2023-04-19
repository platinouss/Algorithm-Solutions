/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 코딩 테스트 공부 (Lv3)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/118668
 */

import java.util.*;

class Solution {

    static int[][] dp;

    public int solution(int alp, int cop, int[][] problems) {
        int alpMax = 0;
        int copMax = 0;
        for (int[] problem : problems) {
            alpMax = Math.max(alpMax, problem[0]);
            copMax = Math.max(copMax, problem[1]);
        }
        if (alp >= alpMax && cop >= copMax) {
            return 0;
        }
        if (alp >= alpMax) {
            alp = alpMax;
        }
        if (cop >= copMax) {
            cop = copMax;
        }

        dp = new int[alpMax + 2][copMax + 2];
        for (int i=0; i<=alpMax; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[alp][cop] = 0;
        for (int i=alp; i<=alpMax; i++) {
            for (int j=cop; j<=copMax; j++) {
                dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j] + 1);
                dp[i][j+1] = Math.min(dp[i][j+1], dp[i][j] + 1);
                for (int[] problem : problems) {
                    if (i < problem[0] || j < problem[1]) {
                        continue;
                    }
                    if (i + problem[2] > alpMax && j + problem[3] > copMax) {
                        dp[alpMax][copMax] = Math.min(dp[alpMax][copMax], dp[i][j] + problem[4]);
                    } else if (i + problem[2] > alpMax) {
                        dp[alpMax][j+problem[3]] = Math.min(dp[alpMax][j+problem[3]], dp[i][j] + problem[4]);
                    } else if (j + problem[3] > copMax) {
                        dp[i+problem[2]][copMax] = Math.min(dp[i+problem[2]][copMax], dp[i][j] + problem[4]);
                    } else {
                        dp[i+problem[2]][j+problem[3]] = Math.min(dp[i+problem[2]][j+problem[3]], dp[i][j] + problem[4]);
                    }
                }
            }
        }

        return dp[alpMax][copMax];
    }
}