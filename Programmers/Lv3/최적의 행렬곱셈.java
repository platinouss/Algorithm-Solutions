/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 최적의 행렬곱셈 (Lv3)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12942
 */

import java.util.*;

class Solution {

    static int N;
    static int[][] dp;

    public int solution(int[][] matrix_sizes) {
        N = matrix_sizes.length;
        dp = new int[N][N];
        for (int i=0; i<N; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        for (int i=0; i<N; i++) {
            for (int j=0; j<N-i; j++) {
                int a = j;
                int b = j+i;
                if (a == b) { dp[a][b] = 0; }
                else {
                    for (int k=a; k<b; k++) {
                        dp[a][b] = Math.min(dp[a][b], dp[a][k] + dp[k+1][b] +
                                matrix_sizes[a][0] * matrix_sizes[k][1] * matrix_sizes[b][1]);
                    }
                }
            }
        }
        return dp[0][N - 1];
    }
}